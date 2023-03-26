/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.BatlleNaval;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class CellManager implements Observer {


    private ArrayList<Cell> cellList;

    private boolean boatAvaliable4 = true;
    private boolean boatAvaliable3 = true;
    private boolean boatAvaliable2 = true;
    private boolean boatAvaliable1 = true;
    private BoardManager boardManager;
    private boolean btnAdd4BoatsStatus;
    private boolean btnAdd3BoatsStatus;
    private boolean btnAdd2BoatsStatus;
    private boolean btnAdd1BoatsStatus;
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
            if (y + (boatSize - 1) <= 8) {
                for (int i = 0; i < boatSize; i++) {
                    Cell cellPanel = search(x, y);
                    cellPanel.setPermanent(true);
                    y++;
                }
            }
        }
    }


    public void setBoatAvaliable4(boolean boatAvaliable4) {
        this.boatAvaliable4 = boatAvaliable4;
    }

    public void setBoatAvaliable3(boolean boatAvaliable3) {
        this.boatAvaliable3 = boatAvaliable3;
    }

    public void setBoatAvaliable2(boolean boatAvaliable2) {
        this.boatAvaliable2 = boatAvaliable2;
    }

    public void setBoatAvaliable1(boolean boatAvaliable1) {
        this.boatAvaliable1 = boatAvaliable1;
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

    @Override
    public void update(Observable currentPanel, Object arg) {
        try {
            if (currentPanel instanceof Cell) {
                switch (Mouse.getMyMouse().getComponentClicked().getName()) {
                    case "btnAddBoat4Size":
                        if (boatAvaliable4) {
                            setBoat((Cell) currentPanel, 4);
                        }
                        break;
                    case "btnAddBoat3Size":
                        if (boatAvaliable3) {
                            setBoat((Cell) currentPanel, 3);
                        }
                        break;
                    case "btnAddBoat2Size":
                        if (boatAvaliable2) {
                            setBoat((Cell) currentPanel, 2);
                        }
                        break;
                    case "btnAddBoat1Size":
                        if (boatAvaliable1) {
                            setBoat((Cell) currentPanel, 1);
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
     * @return 
     */
    public String generateMapBoats(){
        String map = "";
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (search(i, j).isPermanent()) {
                    map += "-";
                } else {
                    map += ".";
                }
                System.out.println( "Coordenada: " + i + " , " + j+ " \nSe agrego, posicion actual: " + map.length());

            }
        }
        return map;
    }


    
    public static void main(String[] args) {
        CellManager a =  new CellManager();
        a.fillMainBoardStart();
        Cell b = a.search(8, 2);
        System.out.println(a.generateMapBoats().length());
    }
}
