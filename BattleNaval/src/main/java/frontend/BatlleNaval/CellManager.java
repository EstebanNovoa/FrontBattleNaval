/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.BatlleNaval;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author novoa
 */
public class CellManager implements Observer{
    
    
    private ArrayList<Cell> cellList;
    private boolean boatAvaliable = true;
    private BoardManager boardManager;
    
    public CellManager(){
        cellList = new ArrayList<Cell>();
        
    }

    public ArrayList<Cell> getCellList() {
        return cellList;
    }

    
      public void setBoat(Cell currentPanel, int boatSize) {
        if (boatSize >= 1) {
            String[] coordenate = currentPanel.getPanel().getName().split(",");
            int x = Integer.parseInt(coordenate[0]);
            int y = Integer.parseInt(coordenate[1]);
            if (y + (boatSize-1)<= 8) {
                for (int i = 0; i < boatSize; i++) {
                    System.out.println("Cordenadas que va a pintar" + search(x,y).getPanel().getName());
                    Cell cellPanel = search(x,y);
                    cellPanel.setPermanent(true);
                    y++;
                }
            }
        } else {
            boatAvaliable = false;
        }

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
        if (currentPanel instanceof Cell) {
            Cell panel = (Cell) currentPanel;
            this.setBoat(panel, 4);
        }
    }
    
    

//    
//    public static void main(String[] args) {
//        CellManager a =  new CellManager();
//        a.prueba();
//        Cell b = a.search(8, 2);
//        System.out.println("El bote buiscado es : " + b.getPanel().getName());
//       // a.setBoat(b, 4);
//        
//    }
}
