package java_miniproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NewPassword {
    JFrame frame;
    JTextField webnameField;
    JTextField usrnameField;
    JTextField passwordField;
    private String user;

    NewPassword(String u) {
        user = u;
        frame = new JFrame("Create New Password");
        frame.setSize(500, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        initUi();
        frame.setVisible(true);
    }

    private void initUi() {
        JLabel label1 = new JLabel("Add New PassWord");

        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel label2 = new JLabel("Website : ");
        webnameField = new JTextField(30);
        panel1.add(label2);
        panel1.add(webnameField);

        JPanel panel2 = new JPanel(new FlowLayout());
        JLabel label3 = new JLabel("Username : ");
        usrnameField = new JTextField(30);
        panel2.add(label3);
        panel2.add(usrnameField);

        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel label4 = new JLabel("Password : ");
        passwordField = new JTextField(30);
        panel3.add(label4);
        panel3.add(passwordField);

        JPanel panel4 = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");
        panel4.add(addButton);
        panel4.add(cancelButton);

        frame.add(label1);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //TODO
                frame.setVisible(false);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //TODO
            }
        });
    }
}