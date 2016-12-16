package emailsorter;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.Arrays;


public class SignIn implements ActionListener {

    ButtonGroup rd = new ButtonGroup();
    static JFrame frame = new JFrame("Welcome");
    static JLabel title = new JLabel("Sign In");
    static JPanel Panel = new JPanel();
    static JButton enter = new JButton("Enter");
    static JTextField usr = new JTextField("Username");
    static JPasswordField pss = new JPasswordField("Password");
    static JRadioButton google = new JRadioButton("Google");
    static JRadioButton yahoo = new JRadioButton("Yahoo");
    static JRadioButton hotmail = new JRadioButton("Hotmail");
    String username, password = "";
    boolean focus = false, focus2 = false;
    boolean focus3 = true;
    
    Email[] emails;

    public SignIn(Email[] emails) {
        this.emails = emails;
        init();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (yahoo.isSelected()) {
            rd.clearSelection();

            JOptionPane.showMessageDialog(null, "Error: Currently not Supported");

        } else if (hotmail.isSelected()) {
            rd.clearSelection();
            JOptionPane.showMessageDialog(null, "Error: Currently not Supported");
        } else if (google.isSelected()) {
            if (focus3) {
                focus3 = false;

            } else {
                rd.clearSelection();
                focus3 = true;
            }
        }
        if(ae.getSource().equals(enter)){
            String userName = usr.getText();
            String password = pss.getText();
            
            Inbox tunnel = new Inbox(userName, password);
            
        }

    }

    public void tick() {
        if (usr.isFocusOwner()) {
            if (!focus) {
                usr.setText("");
                focus = true;
            }
        }
        if (pss.isFocusOwner()) {
            if (!focus2) {
                pss.setText("");
                focus2 = true;
            }
        }
        
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return password;
    }

    private void init() {
        usr.setColumns(25);
        pss.setColumns(25);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.add(Panel);
        Panel.add(title);
        Panel.add(usr);
        Panel.add(pss);
        Panel.add(google);
        Panel.add(yahoo);
        Panel.add(hotmail);
        Panel.add(enter);

        rd.add(google);
        rd.add(yahoo);
        rd.add(hotmail);

        frame.setVisible(true);

        enter.addActionListener(this);
        google.addActionListener(this);
        yahoo.addActionListener(this);
        hotmail.addActionListener(this);
        frame.requestFocus();
    }

}
