package java_miniproject;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.event.*;

public class SignUp {
    JFrame loginFrame;
    JFrame frame;
    private JTextField usrField;
    private JPasswordField pswordField;
    private JPasswordField cnfpswordField;
    JLabel warning;

    SignUp(JFrame lf) {
        loginFrame = lf;
        frame = new JFrame("Sign Up");
        warning = new JLabel("password not matching !!");
        warning.setForeground(Color.RED);
        warning.setVisible(false);
        frame.setSize(600, 400);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        initUi();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                close();
            }
        });
    }

    private void initUi() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Sign Up");
        panel1.add(label1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JLabel label2 = new JLabel("Enter new username: ");
        usrField = new JTextField(30);
        panel2.add(label2);
        panel2.add(usrField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JLabel label3 = new JLabel("Enter new Password: ");
        pswordField = new JPasswordField(30);
        pswordField.setEchoChar('*');
        panel3.add(label3);
        panel3.add(pswordField);

        JPanel panel4 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JLabel label4 = new JLabel("Confirm Password: ");
        cnfpswordField = new JPasswordField(30);
        cnfpswordField.setEchoChar('*');
        panel4.add(label4);
        panel4.add(cnfpswordField);
        panel4.add(warning);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        JButton signUpBtn = new JButton("Create new account");
        JButton clearButton = new JButton("Clear");
        panel5.add(signUpBtn);
        panel5.add(clearButton);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);

        cnfpswordField.addCaretListener(new CaretListener(){
            public void caretUpdate(CaretEvent ce) {
                String p,c;
                p = String.valueOf(pswordField.getPassword());
                c = String.valueOf(cnfpswordField.getPassword());
                if (!c.equals(p) && !c.isEmpty()) {
                    warning.setVisible(true);
                } else {
                    warning.setVisible(false);
                }
            }
        });
        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //TODO
                close();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                usrField.setText("");
                pswordField.setText("");
                cnfpswordField.setText("");
                warning.setVisible(false);
            }
        });
    }
    private void close() {
        frame.setVisible(false);
        loginFrame.setVisible(true);
    }
}