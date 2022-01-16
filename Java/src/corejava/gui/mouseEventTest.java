package corejava.gui;

import javax.swing.*;

public class mouseEventTest {
    public static void main(String[] args) {
        var frame=new JFrame();
        frame.add(new mouseComponent());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
