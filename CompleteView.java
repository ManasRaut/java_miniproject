package java_miniproject;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
//import java.awt.datatransfer.DataFlavor;
import javax.swing.*;

public class CompleteView {
    private String u;
    private String w;
    JFrame frame;
    JTextField webnameField;
    JTextField usrnameField;
    JPasswordField passwordField;
    Clipboard clipboard;
    CompleteView thisClass;

    CompleteView() {
        thisClass = this;
        clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
        frame = new JFrame("All Details");
        frame.setName("CompleteView");
        frame.setSize(500, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
            }
			public void windowLostFocus(WindowEvent e) {
                if(e.getOppositeWindow() != null) {
                    if(e.getOppositeWindow().getName().equals("Home")) {
                        frame.requestFocus();
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    }
                }
			}
        });
        initUi();
    }

    public void initUi() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel4 = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("Website: ");
        JLabel label2 = new JLabel("Username: ");
        JLabel label3 = new JLabel("Password: ");
        JLabel label4 = new JLabel("Actions: ");
        label4.setAlignmentX(JLabel.LEFT);
        webnameField = new JTextField(30);
        usrnameField = new JTextField(30);
        passwordField = new JPasswordField(30);
        passwordField.setEchoChar('*');
        passwordField.setEditable(false);;
        JButton copyBtn = new JButton("Copy");
        JButton editbtn = new JButton("Edit");
        JButton remoButton = new JButton("delete");
        JButton savebtn = new JButton("Save");

        panel1.add(label1);
        panel1.add(webnameField);
        panel2.add(label2);
        panel2.add(usrnameField);
        panel3.add(label3);
        panel3.add(passwordField);
        panel3.add(copyBtn);
        panel4.add(label4);
        panel4.add(editbtn);
        panel4.add(remoButton);
        panel4.add(savebtn);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        copyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String s = String.valueOf(passwordField.getPassword());
                clipboard.setContents(new StringSelection(s), null);
            }
        });
        editbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //TODO
                new ActionCnfm(u, thisClass);
            }
        });
        remoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //TODO
            }
        });
        savebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //TODO
            }
        });
    }

    public void show(String w, String u) {
        frame.setVisible(true);
    }

    public void allow() {
        passwordField.setEditable(true);
        passwordField.setEchoChar((char) 0);
    }
}