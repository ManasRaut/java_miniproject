package java_miniproject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LogIn {
    JFrame frame;
    JTextField userField;
    JPasswordField pswordField;
    JLabel warning;

    LogIn() {
        frame = new JFrame("Log In");
        frame.setSize(500, 300);
        warning = new JLabel("Incorrect details");
        warning.setForeground(Color.RED);
        warning.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        initUi();
        frame.setVisible(true);
    }

    private void initUi() {
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Log In");
        panel4.add(label1);
        label1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));

        JPanel panel1 = new JPanel();
        JLabel label2 = new JLabel("Username: ");
        userField = new JTextField(30);
        panel1.setLayout(new FlowLayout());
        panel1.add(label2);
        panel1.add(userField);

        JPanel panel2 = new JPanel();
        JLabel label3 = new JLabel("Password: ");
        pswordField = new JPasswordField(30);
        pswordField.setEchoChar('*');
        panel2.setLayout(new FlowLayout());
        panel2.add(label3);
        panel2.add(pswordField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JButton loginBtn = new JButton("Log In");
        JButton clearBtn = new JButton("Clear");
        panel3.add(loginBtn);
        panel3.add(clearBtn);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        JButton signupBtn = new JButton("Sign Up");
        panel5.add(signupBtn);

        frame.add(panel4);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(warning);
        frame.add(panel5);

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                pswordField.setText("");
                userField.setText("");
                warning.setVisible(false);
            }
        });
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //TODO
                new Home("sd");
            }
        });
        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new SignUp(frame);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LogIn();
            }
        });
    }
}