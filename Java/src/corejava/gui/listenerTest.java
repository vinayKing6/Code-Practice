package corejava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Locale;

public class listenerTest extends JFrame {
    private JPanel buttonPanel;
    private static final int defaultWidth=300;
    private static final int defaultHeight=200;
    private static final Class<listenerTest> cl=listenerTest.class;

    public listenerTest()
    {
        setSize(defaultWidth,defaultHeight);

        var yellowButton=new JButton("Yellow");
        var blueButton=new JButton("Blue");
        var redButton=new JButton("Red");

        buttonPanel=new JPanel();

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        makeButton("Pink",Color.PINK);
        var exitButton=new JButton("Exit");
        exitButton.addActionListener(event->{System.exit(0);});
        buttonPanel.add(exitButton);

        add(buttonPanel);

        var yellowAction=new ColorAction(Color.YELLOW);
        var blueAction=new ColorAction(Color.BLUE);
        var redAction=new ColorAction(Color.RED);
        URL iconUrl=cl.getResource("images/myLogo.png");
        var action=new ActionForColor("Gray",new ImageIcon(iconUrl),Color.LIGHT_GRAY);
        var grayButton=new JButton("gray");
        grayButton.addActionListener(action);
        buttonPanel.add(grayButton);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    private class ColorAction implements ActionListener{
        Color backgroundColor;
        public ColorAction(Color c)
        {
            this.backgroundColor=c;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }

    private class ActionForColor extends AbstractAction {
        public ActionForColor(String name, Icon icon, Color c)
        {
            putValue(Action.NAME,name);
            putValue(Action.SMALL_ICON,icon);
            putValue("color",c);
            putValue(Action.SHORT_DESCRIPTION,"Set panel color to "+name.toLowerCase());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground((Color) getValue("color"));
        }
    }

    public void makeButton(String name,Color c)
    {
        var button=new JButton(name);
        button.addActionListener(event->{buttonPanel.setBackground(c);});
        buttonPanel.add(button);
    }
    public static void main(String[] args) {
        var frame=new listenerTest();
        frame.setVisible(true);
    }
}
