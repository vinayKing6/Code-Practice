package corejava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class paintTest {
    public static void main(String[] args) {
        var fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName:fontNames)
        {
            System.out.println(fontName);
        }
        EventQueue.invokeLater(()->{
            var frame=new paintFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
                }

        );
    }
}

class paintFrame extends JFrame{
    public paintFrame()
    {
        this.getContentPane().setBackground(Color.PINK);
        add(new paintComponent());
        pack();
    }
}

class paintComponent extends JComponent
{
    private static final int defaultWidth=300;
    private static final int defaultHeight=200;

    @Override
      public void paintComponent(Graphics g) {
        var g2=(Graphics2D) g;
        var message="Hello,World";
        var font=new Font("Serif", Font.ITALIC+Font.BOLD,36);
        g2.setFont(font);//settings of the font

      //measure the size of the given text by using bounds
        FontRenderContext context=g2.getFontRenderContext();
        Rectangle2D bounds=font.getStringBounds(message,context);

        //set(x,y)=top left corner of the text
        double x=(getWidth()-bounds.getWidth())/2;
        double y=(getHeight()-bounds.getHeight())/2;

        //add ascent to y to reach the baseline(noted that the string is drawn start from the baseline)
        double ascent=-bounds.getY();
        double baseY=ascent+y;

        //draw the message
        g2.setPaint(Color.LIGHT_GRAY);//set the color of the string
        g2.drawString(message,(int)x,(int)baseY);


        //draw the baseline
        g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));

        //draw the bounds rectangle
        g2.draw(new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight()));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(defaultWidth,defaultHeight);
    }
}