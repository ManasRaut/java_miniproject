package java_miniproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionCnfm {
    JFrame frame;
    private String user;
    private JPasswordField paswordField;
    CompleteView view;

    ActionCnfm(String u, CompleteView v) {
        user = u;
        view = v;
        frame = new JFrame("Confirm");
        frame.setSize(375, 120);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JLabel label1 = new JLabel("Confirm by entering password: ");
        paswordField = new JPasswordField(30);
        paswordField.setEchoChar('*');
        JButton enterbtn = new JButton("Verify");
        JPanel panel1 = new JPanel(new FlowLayout());
        frame.add(label1);
        panel1.add(paswordField);
        frame.add(panel1);
        frame.add(enterbtn);
        frame.setVisible(true);

        enterbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String p = String.valueOf(paswordField.getPassword());
                if(verify(p)) {
                    view.allow();
                    frame.setVisible(false);
                }
            }
        });

        frame.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {

            }
            public void windowLostFocus(WindowEvent e) {
                if(e.getOppositeWindow() != null) {
                    if(e.getOppositeWindow().getName().equals("CompleteView")) {
                        frame.requestFocus();
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    }
                }
            }
        });
    }

    private boolean verify(String p) {
        return true;
    }
}