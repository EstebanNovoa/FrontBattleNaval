package frontend.controllers;

import frontend.BatlleNaval.BoardManager;
import frontend.BatlleNaval.login.FrameLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller extends WindowAdapter implements ActionListener {

    private FrameLogin frameLogin;
    private BoardManager boardManager;

    public Controller() {
//        this.boardManager = new BoardManager();
        this.frameLogin = new FrameLogin(this, this);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
