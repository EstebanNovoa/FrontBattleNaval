package frontend.BatlleNaval;


import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class BoardManager implements Observer {

    private BoatTable boatTable;
    private ActionListener actionListener;

    public BoardManager(ActionListener actionListener) {
        boatTable = new BoatTable(this, actionListener);
        this.actionListener = actionListener;
        boatTable.setVisible(true);
//        this.setNamePlayer(namePlayer);
    }

    public BoardManager(String namePlayer, ActionListener actionListener) {
        boatTable = new BoatTable(this, actionListener);
        this.actionListener = actionListener;
        this.setNamePlayer(namePlayer);
        boatTable.setVisible(true);
//        this.setNamePlayer(namePlayer);
    }


    public void addBoardOpponent() {
        this.boatTable.addBoardOpponent();
    }

    public void setTime(String time) {
        this.boatTable.setTime(time);
    }

    public JPanel getBoard() {
        return this.boatTable.getUserBoard();
    }

    private void setNamePlayer(String namePlayer) {
        this.boatTable.setNamePlayer(namePlayer);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Cell) {
            boatTable.fillMainBoardRepaint();
        }

    }

    public static void main(String[] args) {
        new BoardManager(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    
}
