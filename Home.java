package java_miniproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Box;

public class Home {
    JFrame frame;
    private String user;

    Home(String u) {
        user = u;
        frame = new JFrame("User: " + user);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        initUI();
        frame.setVisible(true);
    }

    private void initUI() {
        JLabel label1 = new JLabel("User: " + user);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton addbtn = new JButton("Add new password");
        panel1.add(addbtn);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        for(int i=0; i<=20; i++) {
            listPanel.add( new ListItem("Website", "mans", i));
            listPanel.add(Box.createVerticalStrut(5));
        }

        frame.add(label1);
        frame.add(panel1);
        frame.add(Box.createVerticalStrut(20));
        frame.add(scrollPane);

        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new NewPassword(user);
            }
        });
    }
}