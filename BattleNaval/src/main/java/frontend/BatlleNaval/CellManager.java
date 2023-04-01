package frontend.BatlleNaval;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class CellManager  {


    private ArrayList<Cell> cellList;

    private int boatAvaliable4 = 3 ;
    private int boatAvaliable3 = 3 ;
    private int boatAvaliable2 = 3 ;
    private int boatAvaliable1  = 2;
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
        if (y + (boatSize - 1) <= 10) {
            for (int i = 0; i < boatSize; i++) {
                Cell cellPanel = search(x, y);
                cellPanel.setPermanent(true);
                MouseEvent mouseEvent = new MouseEvent(cellPanel.getPanel(), MouseEvent.MOUSE_ENTERED, System.currentTimeMillis(), 0, 0, 0, 0, false);
                cellPanel.getPanel().dispatchEvent(mouseEvent);
                y++;
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
             y++;
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
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (search(i, j).isPermanent()) {
                    map += "-";
                } else {
                    map += ".";
                }
            }
        }
        return map;
    }
}
