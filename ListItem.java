package java_miniproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.*;

public class ListItem extends JPanel {
    private JLabel userLabel;
    //private JLabel pswordLabel;
    private JLabel srno;
    private JPanel thisPanel;
    private JLabel webname;

    ListItem(String w, String u, int sr) {
        thisPanel = this;
        userLabel = new JLabel(u);
        webname = new JLabel(w);
        //pswordLabel = new JLabel(p);
        srno = new JLabel(String.valueOf(sr));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(srno);
        this.add(webname);
        this.add(userLabel);
        //this.add(pswordLabel);

        Border noneBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
        this.setBorder(noneBorder);
        Color hoverColor = new Color(202, 219, 236);
        Color noneColor = new Color(238, 238, 238);
        Color clickColor = new Color(176, 202, 225);

        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    //TODO
                    new CompleteView().show(w,u);
                }
            }
            public void mousePressed(MouseEvent e) {
                thisPanel.setBackground(clickColor);
            }
            public void mouseReleased(MouseEvent e) {
                thisPanel.setBackground(hoverColor);
            }
			public void mouseEntered(MouseEvent e) {
                thisPanel.setBackground(hoverColor);
			}
			public void mouseExited(MouseEvent e) {
                thisPanel.setBackground(noneColor);
			}
        });
    }
}