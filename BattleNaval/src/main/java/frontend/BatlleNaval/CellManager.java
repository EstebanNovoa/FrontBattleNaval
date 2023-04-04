package frontend.BatlleNaval;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class CellManager implements Observer {


    private ArrayList<Cell> cellList;

    private int boatAvaliable4 = 1;
    private int boatAvaliable3 = 0;
    private int boatAvaliable2 = 0;
    private int boatAvaliable1 = 0;
    private BoardManager boardManager;
    private static CellManager myCellManager;

    public CellManager() {
        cellList = new ArrayList<Cell>();
    }

    public static CellManager getMyCellManager() {
        if (myCellManager == null) {
            myCellManager = new CellManager();
        }
        return myCellManager;
    }

    public ArrayList<Cell> getCellList() {
        return cellList;
    }


    public boolean setBoat(Cell currentPanel, int boatSize) {
        String[] coordenate = currentPanel.getPanel().getName().split(",");
        int x = Integer.parseInt(coordenate[0]);
        int y = Integer.parseInt(coordenate[1]);
        boolean isAdded = false;
        if (x + (boatSize - 1) <= 10) {
            for (int i = 0; i < boatSize; i++) {
                Cell cellPanel = search(x, y);
                cellPanel.setPermanent(true);
                MouseEvent mouseEvent = new MouseEvent(cellPanel.getPanel(), MouseEvent.MOUSE_ENTERED, System.currentTimeMillis(), 0, 0, 0, 0, false);
                cellPanel.getPanel().dispatchEvent(mouseEvent);
                x++;
            }
            isAdded = true;
            switch (boatSize) {
                case 4:
                    boatAvaliable4--;
                    break;
                case 3:
                    boatAvaliable3--;
                    break;
                case 2:
                    boatAvaliable2--;
                    break;
                case 1:
                    boatAvaliable1--;
                    break;

            }
        }
        return isAdded;
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


    /**
     * Verifica que el espacio donde se agrega el barco este totalmente libre
     * Retorna true si algún espacio esta lleno y false si no
     *
     * @param x
     * @param y
     * @param boatSize
     * @return
     */
    public boolean isFill(int x, int y, int boatSize) {
        String nameToFind = x + "," + y;
        for (int i = 0; i < boatSize; i++) {
            Cell cellPanel = search(x, y);
            if (cellPanel.isPermanent()) {
                return true;
            }
            x++;
        }
        return false;
    }


    /**
     * Genera el mapa de los botes establecidos - cuando hay botes y . celda sin descubrir
     *
     * @return String que representa el tablero
     */
    public String generateMapBoats() {
        String map = "";
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
                if (search(x, y).isPermanent()) {
                    map += "-";
                } else {
                    map += ".";
                }
            }
        }
        return map;
    }

    /**
     * Obtiene la cantidad de barcos restantes dependiendo del tamaño especificado
     *
     * @param boatSize tamaño del barco a buscar
     * @return barcos restantes
     */
    public int getBoatsAvailable(int boatSize) {
        int number;
        switch (boatSize) {
            case 1 -> number = getBoatAvaliable1();
            case 2 -> number = getBoatAvaliable2();
            case 3 -> number = getBoatAvaliable3();
            case 4 -> number = getBoatAvaliable4();
            default -> throw new IllegalArgumentException("No hay barcos de tamaño: " + boatSize);
        }
        return number;
    }

    /**
     * Obtiene la cantidad total de barcos disponibles
     *
     * @return barcos disponibles
     */
    public int getBoatsAvailable() {
        return boatAvaliable1 + boatAvaliable2 + boatAvaliable3 + boatAvaliable4;
    }

    /**
     * Evalua el click que se genere en el tablero del oponente
     *
     * @param currentPanel
     * @param arg
     */

    @Override
    public void update(Observable currentPanel, Object arg) {
        if (currentPanel instanceof Cell currentCell && !currentCell.isIsOpponent()) {
            switch (currentCell.getStatus()) {
                case CB -> currentCell.getPanel().setBackground(Color.BLUE);
                case CBS -> currentCell.getPanel().setBackground(Color.GRAY);
                case CD -> currentCell.getPanel().setBackground(Color.YELLOW);
                case CBD -> currentCell.getPanel().setBackground(Color.RED);
            }
        }
    }
}
