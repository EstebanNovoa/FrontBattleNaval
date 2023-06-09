package frontend.BatlleNaval;

import frontend.controllers.Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 * @author novoa
 */
public class CellManagerOpponent implements Observer {

    private Controller controller;
    private ArrayList<Cell> cellList;

    private int boatAvaliable4 = 3;
    private int boatAvaliable3 = 3;
    private int boatAvaliable2 = 3;
    private int boatAvaliable1 = 2;
    private boolean winner;
    private BoardManager boardManager;
    private static CellManagerOpponent myCellManager;

    public CellManagerOpponent() {
        cellList = new ArrayList<Cell>();
    }

    public static CellManagerOpponent getMyCellManagerOpponent() {
        if (myCellManager == null) {
            myCellManager = new CellManagerOpponent();
        }
        return myCellManager;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public ArrayList<Cell> getCellList() {
        return cellList;
    }


    public Cell search(int x, int y) {
        String nameToFind = x + "," + y;
        for (Cell currenCell : cellList) {
            if (currenCell.getPanel().getName().equals(nameToFind)) {
                return currenCell;
            }
        }
        System.out.println("Cooordenada que devuelve null es: " + x + " - " + y);
        return null;

    }

    public boolean isWinner() {
        if ((boatAvaliable1 + boatAvaliable2 + boatAvaliable3 + boatAvaliable4) == 0) {
            winner = true;
            JOptionPane.showMessageDialog(null, "¡Felicidades, ganaste!", "GANADOR", JOptionPane.INFORMATION_MESSAGE);
            Cell.setIsBlocked(true);
        }
        return winner;
    }

    public boolean isFill(int x, int y) {
        String nameToFind = x + "," + y;
        for (Cell currenCell : cellList) {
            if (currenCell.getPanel().getName().equals(nameToFind)) {
                return currenCell.isPermanent();
            }
        }
        return false;
    }

    /**
     * Evalua el click que se genere en el tablero del oponente
     *
     * @param currentPanel
     * @param arg
     */

    @Override
    public void update(Observable currentPanel, Object arg) {
        if (currentPanel instanceof Cell currentCell && currentCell.isIsOpponent()) {
            if (currentCell.getStatus().equals(Status.CB)) {
                currentCell.getPanel().setBackground(Color.red);
                currentCell.setStatus(Status.CBD);
            } else if (currentCell.getStatus().equals(Status.CBS)) {
                currentCell.getPanel().setBackground(Color.YELLOW);
                currentCell.setStatus(Status.CD);
            }
            if (!currentCell.isPermanent()) {
                currentCell.setPermanent(true);
                sendShoot(currentCell.getPanel().getName());
            }
        }
    }

    private void sendShoot(String cellName) {
        String[] coords = cellName.split(",");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        controller.sendShoot(x, y);
    }

    /**
     * Genera el mapa de los botes establecidos - cuando hay botes y . celda sin descubrir
     *
     * @return String que representa el tablero
     */
    public String generateMapBoats() {
        String map = "";
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Cell currentCell = this.search(i, j);
                if (currentCell.getStatus().equals(Status.CB)) {
                    map += Status.CB.getValue();
                } else if (currentCell.getStatus().equals(Status.CBD)) {
                    map += Status.CBD.getValue();
                } else if (currentCell.getStatus().equals(Status.CBS)) {
                    map += Status.CBS.getValue();
                } else if (currentCell.getStatus().equals(Status.CD)) {
                    map += Status.CD.getValue();
                }
                //  System.out.println("Coordenada: " + i + " , " + j + " \nSe agrego, posicion actual: " + map.length());
            }
        }
        return map;
    }
}
