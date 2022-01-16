package corejava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class mouseComponent extends JComponent {
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;

    private static final int SIDELENGTH=10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public mouseComponent()
    {
        squares=new ArrayList<>();
        current=null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g)
    {
        var g2=(Graphics2D)g;

        for (Rectangle2D r:squares)
            g2.draw(r);
    }

    public Rectangle2D find(Point2D p)
    {
        for (Rectangle2D r:squares)
        {
            if(r.contains(p))
                return r;
        }
        return null;
    }

    public void add(Point2D p)
    {
        double x=p.getX();
        double y=p.getY();

        current=new Rectangle2D.Double(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
        squares.add(current);
        repaint();
        System.out.println(0);
    }

    public void remove(Rectangle2D s)
    {
        if (s==null) return;
        if (s==current) current=null;
        squares.remove(s);
        repaint();
        System.out.println(1);
    }

    private class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
            current=find(event.getPoint());
            if (current==null)
                add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event)
        {
            current=find(event.getPoint());
            if (current!=null&&event.getClickCount()>=2)
                remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
            if (find(event.getPoint())==null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event)
        {
            if (current!=null)
            {
                int x=event.getX();
                int y=event.getY();

                current.setFrame(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
                repaint();
            }
        }
    }
}
