package frontend.BatlleNaval;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class CellManager implements Observer {


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


    public void setBoat(Cell currentPanel, int boatSize) {
        String[] coordenate = currentPanel.getPanel().getName().split(",");
        int x = Integer.parseInt(coordenate[0]);
        int y = Integer.parseInt(coordenate[1]);
        if (y + (boatSize - 1) <= 10) {
            for (int i = 0; i < boatSize; i++) {
                Cell cellPanel = search(x, y);
                cellPanel.setPermanent(true);
                MouseEvent mouseEvent = new MouseEvent(cellPanel.getPanel(), MouseEvent.MOUSE_ENTERED, System.currentTimeMillis(), 0, 0, 0, 0, false);
                cellPanel.getPanel().dispatchEvent(mouseEvent);
                y++;
            }
        }
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
                Cell currentCell = (Cell) currentPanel;
                String[] coordenate = currentCell.getPanel().getName().split(",");
                int x = Integer.parseInt(coordenate[0]);
                int y = Integer.parseInt(coordenate[1]);
                switch (Mouse.getMyMouse().getComponentClicked().getName()) {
                    case "btnAddBoat4Size":
                        if (boatAvaliable4 > 0 && !isFill(x,y)) {
                            setBoat((Cell) currentPanel, 4);
                            boatAvaliable4--;
                        }
                        break;
                    case "btnAddBoat3Size":
                        if (boatAvaliable3 > 0 && !isFill(x,y)) {
                            setBoat((Cell) currentPanel, 3);
                            boatAvaliable3--;
                        }
                        break;
                    case "btnAddBoat2Size":
                        if (boatAvaliable2 >0 && !isFill(x,y)) {
                            setBoat((Cell) currentPanel, 2);
                            boatAvaliable2--;
                        }
                        break;
                    case "btnAddBoat1Size":
                        if (boatAvaliable1>0 && !isFill(x,y)) {
                            setBoat((Cell) currentPanel, 1);
                            boatAvaliable1--;
                        }
                        break;
                    default:
                        throw new AssertionError();
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
