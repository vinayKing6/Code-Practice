package corejava.gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class guiTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame=new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //above:decide the action of the operation when it is closed and here it just finished
            System.out.println(frame.isVisible());
            frame.setResizable(false);
            System.out.println(frame.isResizable());
            frame.setTitle("my first gui");
            System.out.println(frame.getTitle());
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    static Class<SimpleFrame> cl=SimpleFrame.class;
    public SimpleFrame(){
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        System.out.println(screenWidth+" "+screenHeight);
        setSize(screenWidth/2,screenHeight/2);
        URL ul=cl.getResource("images/myLogo.png");
        Image img=new ImageIcon(ul).getImage();//if to use the pathname of a file then have to use this form
        if (img==null)
            System.out.println("images not found");
        setIconImage(img);
        setLocation((screenWidth-getWidth())/2,(screenHeight-getHeight())/2);
    }
}
