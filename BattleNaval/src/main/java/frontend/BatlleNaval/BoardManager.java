/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.BatlleNaval;

import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class BoardManager implements Observer {

    private BoatTable boatTable;

    public BoardManager() {
        boatTable = new BoatTable(this);
        boatTable.setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Cell) {
            boatTable.fillMainBoardRepaint();
        }

    }


}
