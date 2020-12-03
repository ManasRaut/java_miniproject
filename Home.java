package java_miniproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Box;
import javax.swing.border.*;
import javax.swing.BorderFactory;

public class Home {
    JFrame frame;
    private String user;

    Home(String u) {
        user = u;
        frame = new JFrame("User: " + user);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setName("Home");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        initUI();
        frame.setVisible(true);
    }

    private void initUI() {
        Border raisedBorder = BorderFactory.createRaisedSoftBevelBorder();
        JPanel parent1 = new JPanel();
        parent1.setLayout(new BoxLayout(parent1, BoxLayout.Y_AXIS));
        parent1.setBorder(raisedBorder);

        JLabel label1 = new JLabel("User: " + user);
        label1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        label1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 26));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label3 = new JLabel("Add new password: ");
        JButton addbtn = new JButton(" New ");
        panel1.add(label3);
        panel1.add(addbtn);
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label2 = new JLabel("Your saved passwords: ");
        panel2.add(label2);

        JPanel parent2 = new JPanel(new BorderLayout());
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        for(int i=0; i<=20; i++) {
            listPanel.add( new ListItem("Website", "mans", i));
            listPanel.add(Box.createVerticalStrut(5));
        }

        parent1.add(label1);
        parent1.add(panel1);
        parent1.add(Box.createVerticalStrut(50));
        parent1.add(panel2);
        frame.add(parent1);
        parent2.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
        parent2.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
        parent2.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
        parent2.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
        parent2.add(scrollPane, BorderLayout.CENTER);
        frame.add(parent2);

        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new NewPassword(user);
            }
        });
    }
}