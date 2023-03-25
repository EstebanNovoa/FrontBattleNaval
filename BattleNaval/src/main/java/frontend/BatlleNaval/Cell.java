/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.BatlleNaval;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author novoa
 */
public class Cell extends Observable{
    
    
    private boolean status;
    private boolean  permanent = false;
    private JPanel panel; 
    

    public Cell(String name, BoardManager boardManager,BoatTable boatTable) {
        super();
        panel = new JPanel();
        this.addObserver(CellManager.getMyCellManager());
        this.addObserver(boardManager);
        this.addObserver(boatTable);
        mouseActions(panel);
        setProperties(name);
    }
    
    private void setProperties(String name){
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setName(name);
        if (!permanent) {
            panel.setBackground(Color.LIGHT_GRAY);
        }else{
            panel.setBackground(Color.GREEN);
        }
        
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    
    public void setStatus(boolean status) {
        status = false;
        if (status == false) {
            panel.setBackground(Color.GREEN);
        }
        
    }
    
    
    public void mouseActions(JPanel panel) {
        panel.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.GREEN);
                setChanged();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (permanent == false) {
                    panel.setBackground(Color.LIGHT_GRAY);
                }

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setChanged();
                notifyObservers(Cell.this);
                
            }
        }
    

    );
    }
    
    public void notiAll(){
        setChanged();
        notifyObservers(Cell.this);
    }

    public JPanel getPanel() {
        return panel;
    }
    
    


    
    
    
    
    
    
}
