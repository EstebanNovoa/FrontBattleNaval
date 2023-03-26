package frontend.BatlleNaval;


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

    public BoardManager(String namePlayer, ActionListener actionListener) {
        boatTable = new BoatTable(this, actionListener);
        this.actionListener = actionListener;
        boatTable.setVisible(true);
        this.setNamePlayer(namePlayer);
    }

    public void addBoardOpponent() {
        this.boatTable.addBoardOpponent();
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

//    public static void main(String[] args) {
//        new BoardManager();
//    }

    //.........---------.........................-----------------..................-.....-...-.-.-.-...-.-.-...-.-.-.-.-.......-.-..............----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--..................-................----.................---.................----...............--.--.............
}
