package java_miniproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CompleteView {
    private String u;
    private String w;
    JFrame frame;

    CompleteView() {
        frame = new JFrame("All Details");
    }

    public void show(String w, String u) {
        frame.setVisible(true);
    }
}