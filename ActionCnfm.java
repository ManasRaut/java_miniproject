package java_miniproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Box;

public class ActionCnfm {
    JFrame frame;
    private String user;
    private JPasswordField paswordField;
    Object view;

    ActionCnfm(String u, Object v) {
        user = u;
        view = v;
        frame = new JFrame("Confirm");
        frame.setSize(400, 250);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel4.setBackground(Styles.primary_white);
        JLabel label1 = new JLabel("Confirm by entering password: ");
        label1.setFont(new Font("Calibri", Font.PLAIN, 18));
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(Styles.primary_white);
        paswordField = new JPasswordField(20);
        paswordField.setEchoChar('*');
        paswordField.setBorder(Styles.text_field_border);
        paswordField.setFont(Styles.text_field_font);
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.setBackground(Styles.primary_white);
        JButton enterbtn = new JButton("Verify");
        enterbtn.setBackground(Styles.primary_button_color);
        enterbtn.setForeground(Color.WHITE);
        enterbtn.setBorder(Styles.white_button_border);
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(Styles.primary_white);
        
        panel4.add(Box.createHorizontalStrut(80));
        panel4.add(label1);
        panel2.add(paswordField);
        panel1.add(panel2);
        panel3.add(Box.createHorizontalStrut(50));
        panel3.add(enterbtn);
        frame.add(panel4);
        frame.add(panel1);
        frame.add(panel3);
        frame.setVisible(true);

        enterbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String p = String.valueOf(paswordField.getPassword());
                if(verify(p)) {
                    sendResult();
                    frame.setVisible(false);
                }
            }
        });

        frame.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {

            }
            public void windowLostFocus(WindowEvent e) {
                String oppName = e.getOppositeWindow().getName();
                if(e.getOppositeWindow() != null) {
                    if(oppName.equals("CompleteView") || oppName.equals("Home")) {
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

    private void sendResult() {
        if(view.getClass().equals(CompleteView.class)) {
            ((CompleteView) view).action();
        } else if(view.getClass().equals(NewPassword.class)) {
            ((NewPassword) view).action();
        }
    }
}