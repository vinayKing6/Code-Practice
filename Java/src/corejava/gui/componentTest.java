package corejava.gui;

import javax.swing.*;
import java.awt.*;

public class componentTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            var frame = new paintFrame();
            frame.setTitle("hello");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } );
    }
}

class myComponent extends JComponent{
    public static final int MESSAGE_X=75;
    public static final int MESSAGE_Y=100;

    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;

    public void paintComponent(Graphics g)
    {
        g.drawString("hello i am vinay!",MESSAGE_X,MESSAGE_Y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        //above:the method only decide the size of the component not the window
    }
}

class myFrame extends JFrame{
    public myFrame()
    {
        add(new myComponent());
        pack();//adjust the size of the window to fit the size of the component
    }
}
