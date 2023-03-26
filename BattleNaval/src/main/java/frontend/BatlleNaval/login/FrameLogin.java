package frontend.BatlleNaval.login;

import frontend.BatlleNaval.Actions;
import frontend.BatlleNaval.Texts;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Objects;

public class FrameLogin extends JFrame implements Texts {

    private ActionListener actionListener;
    private WindowListener windowListener;
    private JLabel labelName;
    private JTextField fieldGetName;
    private JButton btnAcceptLogin;

    private JLabel labelImage;
    private JDialog dialogWaitMatch;

    public FrameLogin(ActionListener actionListener, WindowListener windowListener, Color color) throws HeadlessException {
        super("Batalla Naval");
        this.actionListener = actionListener;
        this.windowListener = windowListener;
        this.getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(550, 300));
        init();
        setVisible(true);
    }

    private void init() {
        this.labelName = new JLabel(NAME_LOGIN);
        this.labelName.setHorizontalAlignment(SwingConstants.CENTER);
        this.fieldGetName = new JTextField();
        this.btnAcceptLogin = new JButton(BTN_LOGIN);
        this.btnAcceptLogin.addActionListener(this.actionListener);
        this.btnAcceptLogin.setActionCommand(Actions.BTN_ACCEPT_LOGIN);
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/imag2.png")));
        this.labelImage = new JLabel(imageIcon);
        this.labelImage.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
        this.labelImage.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        labelImage.setSize(10, 10);
        this.dialogWaitMatch = new JDialog(this, "", true);
        dialogWaitMatch.setLayout(new GridLayout(1, 1, 10, 10));
        JLabel labelWaitMatch = new JLabel(WAIT_MATCH);
        labelWaitMatch.setHorizontalAlignment(SwingConstants.CENTER);
        dialogWaitMatch.setResizable(false);
        dialogWaitMatch.add(labelWaitMatch);
        dialogWaitMatch.addWindowListener(windowListener);
        this.dialogWaitMatch.setSize(250, 100);
        fill();
    }

    public String getNamePlayer() {
        return this.fieldGetName.getText();
    }

    private void fill() {
        Font font = new Font("TimesRoman", Font.BOLD, 15);
        this.setLayout(null);
        this.labelImage.setBounds(5, 5, 250, 250);
        add(this.labelImage);
        this.labelName.setBounds(260, 5, this.getWidth() - this.labelImage.getWidth() - 15, 30);
        this.labelName.setAlignmentX(SwingConstants.CENTER);
        this.labelName.setFont(font);
        add(this.labelName);
        this.fieldGetName.setBounds(260, 40, 270, 30);
        add(this.fieldGetName);
        this.btnAcceptLogin.setBounds(260, 205, 270, 50);
        add(this.btnAcceptLogin);
    }
}
