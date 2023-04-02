package frontend.controllers;

import frontend.BatlleNaval.*;
import frontend.BatlleNaval.login.FrameLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static frontend.BatlleNaval.Actions.*;

public class Controller extends WindowAdapter implements ActionListener {

    private FrameLogin frameLogin;
    private BoardManager boardManager;
    private static final int PORT = 23370;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private ServerListener listener;
    private volatile boolean isWaiting;


    public Controller() {
        this.frameLogin = new FrameLogin(this, this, MyColors.generateRandomColor(new Color(212, 104, 104)));
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        switch (actionCommand) {
            case Actions.BTN_PLAY -> playGame();
            case SEARCH_MATCH -> {
                System.out.println("SEARCH MATCH");
                this.startMatch(this.frameLogin.getNamePlayer().trim());
            }
            default -> System.out.println("Default");
        }
    }

    private void playGame() {
        String namePlayer = this.frameLogin.getNamePlayer().trim();
        if (!namePlayer.isEmpty()) {
            System.out.println(Actions.BTN_PLAY);
            System.out.println(namePlayer);
            this.frameLogin.dispose();
            //FOR TESTING
            try {
                socket = new Socket(HOST, PORT);
                if (socket.isConnected()) {
                    this.boardManager = new BoardManager(namePlayer, this);
                    System.out.println("CREANDO SOCKET");
                    input = new DataInputStream(socket.getInputStream());
                    output = new DataOutputStream(socket.getOutputStream());
                    CellManagerOpponent.getMyCellManagerOpponent().setController(this);
                    listener = new ServerListener(this);
                }
            } catch (IOException e) {
                Output.showErrorMessage("Servidor no disponible");
            }
            //FOR TESTING
        } else {
            Output.showInfoMessage("Por favor ingrese su nombre de usuario");
        }
    }


    private synchronized void initMatch() {
        isWaiting = false;
        if (getInputString().equals(Actions.START_MATCH)) {
            System.out.println("Empezando partida");
            boardManager.setOpponentName(getInputString());
            String board = getInputString();
            System.out.println("TABLERO OPONENTE: " + board);
            boardManager.addBoardOpponent(board);
            String turn = getInputString();
            boardManager.updateViewOnTurn(turn.equals(YOUR_TURN));
            boardManager.setBtnStartVisible(false);
            listener.start();
            frameLogin.hideDialogWaitMatch();
        }
    }

    private void waitMatch() {
        isWaiting = true;
        new Thread(() -> {
            while (isWaiting) {
                try {
                    if (input.available() > 0) {
                        this.initMatch();
                    }
                    TimeUnit.SECONDS.sleep(1);
                } catch (IOException | InterruptedException e) {
//                    Output.showErrorMessage(ERROR_WAITING);
                }
            }
        }).start();
    }

    private void startMatch(String name) {
        this.writeUTF(SEARCH_MATCH);
        this.writeUTF(name);
        String boardPattern = CellManager.getMyCellManager().generateMapBoats();
        System.out.println("BOARD PATTERN: " + boardPattern);
        this.writeUTF(boardPattern);
        this.waitMatch();
        frameLogin.showDialogWaitMatch();
    }

    public String getInputString() {
        String result = null;
        try {
            result = input.readUTF();
        } catch (IOException e) {
            Output.showErrorMessage(Texts.ERROR_NOT_READ);
        }
        return result;
    }

    private void writeUTF(String action) {
        try {
            output.writeUTF(action);
        } catch (IOException e) {
            Output.showErrorMessage(Texts.ERROR_NOT_WRITE);
        }
    }
    public void serverAction(String action) {
        if (!action.equals(SET_TIME)) System.out.println(LocalDateTime.now() + " SERVER ACTION: " + action);
        switch (action) {
            case SET_TIME -> setTime(getInputString());
            case TIME_OUT, CHANGE_TURN -> {
                boolean yourTurn = getInputString().equals(YOUR_TURN);
                boardManager.updateViewOnTurn(yourTurn);
            }
            case YOUR_BOARD -> {
                String[] coord = getInputString().split(",");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);
                Status newStatus = Status.getStatus(getInputString().charAt(0));
                System.out.printf("Actualiza el estado de: %d,%d a %s",(x+1),(y+1),newStatus.getValue());
                CellManager.getMyCellManager().search(x+1,y+1).setStatus(newStatus);
            }
            case OPPONENT_BOARD -> {
                String coord = getInputString();
                String value = getInputString();
                System.out.println("Respuesta de disparo del servidor: " + coord + " = " + value);
            }
            default -> System.out.println("COMANDO DESCONOCIDO");
        }
    }

    public void sendShoot(int x, int y){
        Cell.setIsBlocked(true);//No permite más disparos
        writeUTF(Actions.SHOOT);
        System.out.println("DISPARA HACIA: " + (x-1) + "," + (y-1));
        writeUTF((x-1) + "," + (y-1));
    }

    private void setTime(String time) {
        this.boardManager.setTime(time);
    }

    public Socket getSocket() {
        return socket;
    }
}
