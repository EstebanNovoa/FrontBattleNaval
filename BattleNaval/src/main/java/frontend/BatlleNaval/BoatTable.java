package frontend.BatlleNaval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * @author novoa
 */
public class BoatTable extends JFrame implements Observer {

    public static final int BoardWidth = 10;
    private final BoardManager boardManager;
    private String namePlayer;
    private JButton btnAddBoat1Size;
    private JButton btnAddBoat2Size;
    private JButton btnAddBoat3Size;
    private JButton btnAddBoat4Size;
    private JButton btnSearchMatch;
    private JButton btnStart;
    private JLabel labelTextTittle;
    private JLabel labelNameOpponent;
    private JLabel labelRemainingBoats;
    private JLabel labelAvailableBoats;
    private JLabel labelTime;
    private JTextField textFieldTime;
    private JLabel lblNumberBoat1Size;
    private JLabel lblNumberBoat2Size;
    private JLabel lblNumberBoat3Size;
    private JLabel lblNumberBoat4Size;
    private JPanel backgroundPanel;
    private JPanel panelSelectBoats;
    private JPanel userBoard;
    private JPanel opponentBoard;
    private CellManagerOpponent cellManagerOponent;


    public BoatTable(BoardManager boardManager, ActionListener actionListener) {
        initComponents(actionListener);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(1100, 550);
        userBoard.setLayout(new GridLayout(BoardWidth, BoardWidth));
        opponentBoard.setLayout(new GridLayout(BoardWidth, BoardWidth));
        this.boardManager = boardManager;
        btnAddBoat4Size.addMouseListener(Mouse.getMyMouse());
        btnAddBoat3Size.addMouseListener(Mouse.getMyMouse());
        btnAddBoat2Size.addMouseListener(Mouse.getMyMouse());
        btnAddBoat1Size.addMouseListener(Mouse.getMyMouse());
        btnAddBoat4Size.setName("btnAddBoat4Size");
        btnAddBoat3Size.setName("btnAddBoat3Size");
        btnAddBoat2Size.setName("btnAddBoat2Size");
        btnAddBoat1Size.setName("btnAddBoat1Size");
        cellManagerOponent = CellManagerOpponent.getMyCellManagerOpponent();
        fillUserBoardStart();
        fillBoardOpponent("--...---............----.--..................---.-.---..........----...--.........----..............");
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
        this.labelTextTittle.setText("Bienvenido a Batalla Naval: " + namePlayer);
    }

    public void addBoardOpponent() {
//        this.backgroundPanel.add(new JButton("Hola"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(ActionListener actionListener) {
        this.btnSearchMatch = new JButton(Texts.BTN_SEARCH_MATCH);
        this.btnSearchMatch.addActionListener(actionListener);
        this.btnSearchMatch.setActionCommand(Actions.SEARCH_MATCH);

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(10, 10, 1300, 500);
        labelTextTittle = new JLabel();
        labelNameOpponent = new JLabel("Sin oponente");
        userBoard = new JPanel();
        opponentBoard = new JPanel();
        opponentBoard = new JPanel();
        panelSelectBoats = new JPanel();
        btnAddBoat4Size = new JButton();
        btnAddBoat3Size = new JButton();
        btnAddBoat1Size = new JButton();
        btnAddBoat2Size = new JButton();
        lblNumberBoat2Size = new JLabel();
        lblNumberBoat4Size = new JLabel();
        lblNumberBoat3Size = new JLabel();
        lblNumberBoat1Size = new JLabel();
        labelRemainingBoats = new JLabel();
        labelAvailableBoats = new JLabel();
        labelTime = new JLabel("Tiempo restante: ");
        labelTime.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        textFieldTime = new JTextField();
        textFieldTime.setEditable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(MyColors.generateRandomColor(new Color(255, 148, 148)));

        labelTextTittle.setFont(new Font("SEGOE", Font.ITALIC + Font.BOLD, 24)); // NOI18N
        labelTextTittle.setForeground(new Color(255, 255, 255));
        labelTextTittle.setHorizontalAlignment(SwingConstants.CENTER);
        labelNameOpponent.setFont(new Font("SEGOE", Font.ITALIC + Font.BOLD, 24)); // NOI18N
        labelNameOpponent.setForeground(new Color(255, 255, 255));
        labelNameOpponent.setHorizontalAlignment(SwingConstants.LEFT);
        labelTextTittle.setText("Bienvenido a Batalla Naval: " + namePlayer);
        labelTextTittle.setBounds(10, 10, 400, 20);

        labelNameOpponent.setBounds(670, 10, 400, 25);

        backgroundPanel.add(labelTextTittle);
        backgroundPanel.add(labelNameOpponent);

        userBoard.setBackground(new Color(255, 255, 255));
        opponentBoard.setBackground(new Color(255, 255, 255));

        userBoard.setBounds(20, 70, 400, 400);
        opponentBoard.setBounds(660, 70, 400, 400);

        labelTime.setBounds(30, 478, 150, 25);

        textFieldTime.setBounds(170, 480, 40, 25);

        backgroundPanel.add(labelTime);
        backgroundPanel.add(userBoard);
        backgroundPanel.add(opponentBoard);
        backgroundPanel.add(textFieldTime);

        panelSelectBoats.setBackground(new Color(255, 255, 255));

        btnAddBoat4Size.setText("Barco : 4");
        btnAddBoat4Size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddBoat4SizeActionPerformed(evt);
            }
        });

        btnAddBoat3Size.setText("Barco: 3");
        btnAddBoat3Size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddBoat3SizeActionPerformed(evt);
            }
        });

        btnAddBoat1Size.setText("Barco: 1");
        btnAddBoat1Size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddBoat1SizeActionPerformed(evt);
            }
        });

        btnAddBoat2Size.setText("Barco: 2");
        btnAddBoat2Size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddBoat2SizeActionPerformed(evt);
            }
        });

        lblNumberBoat2Size.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumberBoat2Size.setText("3");

        lblNumberBoat4Size.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumberBoat4Size.setText("3");

        lblNumberBoat3Size.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumberBoat3Size.setText("3");

        lblNumberBoat1Size.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumberBoat1Size.setText("2");

        labelRemainingBoats.setFont(new Font("Segoe UI", Font.PLAIN, 10)); // NOI18N
        labelRemainingBoats.setText("Barcos Restantes");

        labelAvailableBoats.setText("Barcos Disponibles");

        this.btnStart = new JButton();
        btnStart.setText(Texts.BTN_INIT_MATCH);
        btnStart.setActionCommand(Actions.SEARCH_MATCH);
        btnStart.addActionListener(actionListener);
        GroupLayout jPanel1Layout = new GroupLayout(panelSelectBoats);
        panelSelectBoats.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(btnAddBoat2Size).addComponent(btnAddBoat1Size).addComponent(btnAddBoat3Size).addComponent(btnAddBoat4Size)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblNumberBoat2Size, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addComponent(lblNumberBoat1Size, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addComponent(lblNumberBoat4Size, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE).addComponent(lblNumberBoat3Size, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)).addContainerGap(15, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(labelRemainingBoats, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(labelAvailableBoats).addGap(36, 36, 36)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(labelAvailableBoats, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE).addGap(11, 11, 11).addComponent(labelRemainingBoats).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnAddBoat4Size).addComponent(lblNumberBoat4Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)).addGap(29, 29, 29).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnAddBoat3Size).addComponent(lblNumberBoat3Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)).addGap(26, 26, 26).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNumberBoat2Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE).addComponent(btnAddBoat2Size)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNumberBoat1Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE).addComponent(btnAddBoat1Size)).addContainerGap(32, Short.MAX_VALUE)));
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnAddBoat2Size)
                                        .addComponent(btnAddBoat1Size)
                                        .addComponent(btnAddBoat3Size)
                                        .addComponent(btnAddBoat4Size))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNumberBoat2Size, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNumberBoat1Size, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNumberBoat4Size, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNumberBoat3Size, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(15, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(labelRemainingBoats, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(labelAvailableBoats)
                                                .addGap(36, 36, 36))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnStart)
                                                .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelAvailableBoats, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(labelRemainingBoats)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddBoat4Size)
                                        .addComponent(lblNumberBoat4Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddBoat3Size)
                                        .addComponent(lblNumberBoat3Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNumberBoat2Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddBoat2Size))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNumberBoat1Size, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddBoat1Size))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(btnStart)
                                .addContainerGap())
        );

        panelSelectBoats.setBounds(450, 100, 180, 300);
        backgroundPanel.add(panelSelectBoats);
        backgroundPanel.add(btnSearchMatch);
        backgroundPanel.add(opponentBoard);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(backgroundPanel, GroupLayout.PREFERRED_SIZE, 1100, GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(backgroundPanel, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textMouseMoved(MouseEvent evt) {//GEN-FIRST:event_textMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_textMouseMoved

    private void btnAddBoat4SizeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAddBoat4SizeActionPerformed

    }//GEN-LAST:event_btnAddBoat4SizeActionPerformed

    private void btnAddBoat3SizeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAddBoat3SizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddBoat3SizeActionPerformed

    private void btnAddBoat1SizeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAddBoat1SizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddBoat1SizeActionPerformed

    private void btnAddBoat2SizeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAddBoat2SizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddBoat2SizeActionPerformed

    public JPanel getUserBoard() {
        return userBoard;
    }

    public JPanel getOpponentBoard() {
        return opponentBoard;
    }


    public void fillUserBoardStart() {
        userBoard.setPreferredSize(new Dimension(350, 350));
        for (int i = 1; i <= BoardWidth; i++) {
            for (int j = 1; j <= BoardWidth; j++) {
                Cell currentPanel = new Cell((i + "," + j), boardManager, this);
                CellManager.getMyCellManager().getCellList().add(currentPanel);
                userBoard.add(currentPanel.getPanel());
            }
        }

    }

//    public void fillOpponentBoardStart() {
//        opponentBoard.setPreferredSize(new Dimension(350, 350));
//        for (int i = 1; i <= BoardWidth; i++) {
//            for (int j = 1; j <= BoardWidth; j++) {
//                Cell currentPanel = new Cell((j + "," + i), boardManager, this);
//                cellManagerOponent.getCellList().add(currentPanel);
//                opponentBoard.add(currentPanel.getPanel());
//            }
//        }
//
//    }

    /**
     * Repinta tomando en cuenta el estado de cada celda
     */
    public void fillMainBoardRepaint() {
        this.repaint();
        userBoard.removeAll();
        userBoard.revalidate();
        for (int i = 1; i <= BoardWidth; i++) {
            for (int j = 1; j <= BoardWidth; j++) {
                Cell currentPanel = CellManager.getMyCellManager().search(i, j);
                //CellManager.getMyCellManager().getCellList().add(currentPanel);
                System.out.println("List SIZE: " + CellManager.getMyCellManager().getCellList().size());
                userBoard.add(currentPanel.getPanel());
            }
        }
    }

//    public void fillOpponentBoardRepaint() {
//        this.repaint();
//        opponentBoard.removeAll();
//        opponentBoard.revalidate();
//        for (int i = 1; i <= BoardWidth; i++) {
//            for (int j = 1; j <= BoardWidth; j++) {
//                Cell currentPanel = cellManagerOponent.search(i, j);
//                cellManagerOponent.getCellList().add(currentPanel);
//                opponentBoard.add(currentPanel.getPanel());
//            }
//        }
//    }

    /**
     * Pinta inicialmente cada celda
     */

    public void fillBoardOpponent(String opponentMap) {
        String prueba = "";
        int global = 0;
        opponentBoard.setPreferredSize(new Dimension(350, 350));
        for (int i = 1; i <= BoardWidth; i++) {
            for (int j = 1; j <= BoardWidth; j++) {
                Cell currentPanel = new Cell((j + 1) + "," + (i + 1), boardManager, this);
                char currentSimbol = opponentMap.charAt((i + j));
                prueba += currentSimbol;
                if (opponentMap.charAt(global) == Status.CB.getValue()) {
                    currentPanel.setStatus(Status.CB);
                } else {
                    currentPanel.setStatus(Status.CBS);
                }
                currentPanel.setIsOpponent(true);
                global++;
                CellManager.getMyCellManager().getCellList().add(currentPanel);
                opponentBoard.add(currentPanel.getPanel());
            }

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables


    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable currentPanel, Object arg) {
        try {
            if (currentPanel instanceof Cell) {
                Cell currentCell = (Cell) currentPanel;
                String[] coordenate = currentCell.getPanel().getName().split(",");
                int x = Integer.parseInt(coordenate[0]);
                int y = Integer.parseInt(coordenate[1]);
                switch (Mouse.getMyMouse().getComponentClicked().getName()) {
                    case "btnAddBoat4Size" -> {
                        int numberBoats4 = CellManager.getMyCellManager().getBoatAvaliable4();
                        if (numberBoats4 > 0 && !CellManager.getMyCellManager().isFill(x,y)) {
                            lblNumberBoat4Size.setText(Integer.toString(numberBoats4 -1));
                        } 
                    }
                    case "btnAddBoat3Size" -> {
                        int numberBoats3 = CellManager.getMyCellManager().getBoatAvaliable3();
                        if (numberBoats3 > 0 && !CellManager.getMyCellManager().isFill(x,y)) {
                            lblNumberBoat3Size.setText(Integer.toString(numberBoats3 -1));
                        }
                    }
                    case "btnAddBoat2Size" -> {
                        int numberBoats2 = CellManager.getMyCellManager().getBoatAvaliable2();
                        if (numberBoats2 > 0 && !CellManager.getMyCellManager().isFill(x,y)) {
                            lblNumberBoat2Size.setText(Integer.toString(numberBoats2 -1));
                        }
                    }
                    case "btnAddBoat1Size" -> {
                        int numberBoats1 = CellManager.getMyCellManager().getBoatAvaliable1();
                        if (numberBoats1 > 0 && !CellManager.getMyCellManager().isFill(x,y)) {
                            lblNumberBoat1Size.setText(Integer.toString(numberBoats1 -1 ));
                        }
                    }
                    default -> throw new AssertionError();
                }

            }
        } catch (Exception e) {
        }
    }

    public void setTime(String time) {
        this.textFieldTime.setText(time);
    }

}
