package frontend.controllers;

import frontend.BatlleNaval.Actions;
import frontend.BatlleNaval.BoardManager;
import frontend.BatlleNaval.MyColors;
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
import java.util.concurrent.TimeUnit;

public class Controller extends WindowAdapter implements ActionListener {

    private final FrameLogin frameLogin;
    private BoardManager boardManager;
    private static final int PORT = 23370;
    private static final String HOST = "186.114.217.181";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private volatile boolean isWaiting;


    public Controller() {
//        this.boardManager = new BoardManager();
        this.frameLogin = new FrameLogin(this, this, MyColors.generateRandomColor(new Color(212, 104, 104)));

    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Actions.BTN_ACCEPT_LOGIN:
                System.out.println("BTN_ACCEPT_LOGIN");
                this.writeUTF(Actions.SEARCH_MATCH);
                this.writeUTF(this.frameLogin.getNamePlayer());
//                this.writeUTF(this.boardManager.getBoard());
                break;
            case "Hola":
                System.out.println("Hola");
                break;
            default:
                System.out.println("Default");
                break;
        }
    }

    private void acceptLogin() {
//        String name = this.frameLogin.getNamePlayer().trim();
//        if (!name.isEmpty()) {
//            try {
//                this.socket = new Socket(HOST, PORT);
//                if (socket.isConnected()) {
//                    this.output = new DataOutputStream(socket.getOutputStream());
//                    this.input = new DataInputStream(socket.getInputStream());
//                    if (output != null) {
//                        startMatch(name);
//                    }
//                }
//            } catch (IOException e) {
//                Output.showErrorMessage(SERVER_NOT_FOUND);
//            }
//        } else Output.showInfoMessage(MESSAGE_NAME_EMPTY);

    }

    private synchronized void initMatch() {
        isWaiting = false;
//        if (Objects.equals(getInputString(), Actions.START_MATCH)) {
//            guiManager.fillBoard(getInputString());
//            panelLogin.hideDialogWaitMatch();
//            guiManager.setTextGames(0);
//        }
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
//        this.writeUTF(SEARCH_MATCH);
        this.writeUTF(name);
        this.frameLogin.setVisible(false);
//        this.boardManager.setVisible(true);
        this.waitMatch();
//        panelLogin.showDialogWaitMatch(guiManager);
//        this.guiManager.setNamePlayer(panelLogin.getName());
    }

    private String getInputString() {
        String result = null;
        try {
            result = input.readUTF();
        } catch (IOException e) {
//            Output.showErrorMessage(ERROR_NOT_READ);
        }
        return result;
    }

    private void writeUTF(String action) {
        try {
            output.writeUTF(action);
        } catch (IOException e) {
//            Output.showErrorMessage(ERROR_NOT_WRITE);
        }
    }

}
