/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Mouse to edit this template
 */
package frontend.BatlleNaval;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author novoa
 */
public class Mouse extends MouseAdapter {

    
    private static Mouse myMouse;
    private Component componentClicked;
    private String panelActive;
    private Mouse() {
        super();
    }

    // Método estático que devuelve la instancia única de la clase
    public static Mouse getMyMouse() {
        if (myMouse == null) {
            myMouse = new Mouse();
            
        }
        return myMouse;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent().getClass().equals(JPanel.class)) {
           JPanel panel = (JPanel) e.getComponent();
           panel.setBackground(Color.GREEN);
        }
    }


    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent().getClass().equals(JPanel.class)) {
           JPanel panel = (JPanel) e.getComponent();
           panel.setBackground(Color.lightGray);
        }
    }

    public Component getComponentClicked() {
        return componentClicked;
    }

    public String getPanelActive() {
        return panelActive;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        componentClicked = e.getComponent();

        
    }
}
