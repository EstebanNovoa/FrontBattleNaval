/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public JPanel getBoard() {
        return this.boatTable.getMainBoard();
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


}
