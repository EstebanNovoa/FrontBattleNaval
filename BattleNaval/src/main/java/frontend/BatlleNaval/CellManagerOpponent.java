package frontend.BatlleNaval;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class CellManagerOpponent implements Observer {


    private ArrayList<Cell> cellList;

    private int boatAvaliable4 = 3 ;
    private int boatAvaliable3 = 3 ;
    private int boatAvaliable2 = 3 ;
    private int boatAvaliable1  = 2;
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

    public ArrayList<Cell> getCellList() {
        return cellList;
    }



    public void setBoatAvaliable4(int boatAvaliable4) {
        this.boatAvaliable4 = boatAvaliable4;
    }

    public void setBoatAvaliable3(int boatAvaliable3) {
        this.boatAvaliable3 = boatAvaliable3;
    }

    public void setBoatAvaliable2(int boatAvaliable2) {
        this.boatAvaliable2 = boatAvaliable2;
    }

    public void setBoatAvaliable1(int boatAvaliable1) {
        this.boatAvaliable1 = boatAvaliable1;
    }

    public int getBoatAvaliable4() {
        return boatAvaliable4;
    }

    public int getBoatAvaliable3() {
        return boatAvaliable3;
    }

    public int getBoatAvaliable2() {
        return boatAvaliable2;
    }

    public int getBoatAvaliable1() {
        return boatAvaliable1;
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
    
    
    
    public boolean isFill(int x, int y) {
        String nameToFind = x + "," + y;
       for (Cell currenCell : cellList) {
            if (currenCell.getPanel().getName().equals(nameToFind)) {
                return currenCell.isPermanent();
            }
        }
        return false;
    }

    @Override
    public void update(Observable currentPanel, Object arg) {
        try {
            if (currentPanel instanceof Cell) {
                System.out.println("El estado de la celda clickeada es: " + ((Cell) currentPanel).getStatus());
                if (((Cell) currentPanel).getStatus().equals(Status.CB)) {
                    ((Cell) currentPanel).getPanel().setBackground(Color.red);
                    ((Cell) currentPanel).setPermanent(true);
                }
            }
        } catch (Exception e) {

        }
    }
    
    


    /**
     * Meotdo de prueba
     */
    public void fillMainBoardStart() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Cell currentPanel = new Cell((j + "," + i));
                cellList.add(currentPanel);
            }
        }
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
                if (search(i, j).isPermanent()) {
                    map += "-";
                } else {
                    map += ".";
                }
                System.out.println("Coordenada: " + i + " , " + j + " \nSe agrego, posicion actual: " + map.length());

            }
        }
        return map;
    }
}
