import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.*;
import javax.swing.*;


public class Widget extends JPanel{
    private static int id_counter = 0;

    private int id;

    private int width;
    private int height;
    private Color backgroundColor;
    private JFrame widgetWindow;

    static Color defaultBorderColor = new Color(70, 70, 140);

    JButton detachButton = new JButton("detach");

    Widget(int width, int height, Color bg_color)
    {
        this.id = id_counter++;
        this.width = width;
        this.height = height;
        this.backgroundColor = bg_color;

        this.setBackground(backgroundColor);
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);

        detachButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a)
            {
                detach();
            }
        });
        detachButton.setBackground(new Color(0, 0, 50));
        detachButton.setForeground(new Color(200, 200, 200));

        this.setLayout(new BorderLayout());

        this.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, defaultBorderColor));


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setOpaque(false);
        topPanel.add(detachButton);

        this.add(topPanel, BorderLayout.NORTH);






    }

    public void detach()
    {
        MainWindow.getInstance().remove(this);
        MainWindow.getInstance().revalidate();
        MainWindow.getInstance().repaint();

        detachButton.setVisible(false);

        widgetWindow = new JFrame();
        widgetWindow.setSize(width, height);
        widgetWindow.add(this);
        widgetWindow.setVisible(true);
        widgetWindow.addWindowListener(
            new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e){
                    reattach();
                }
            }

        );

    }

    private void reattach()
    {
        if(widgetWindow != null)
        {
            widgetWindow.remove(this);
            widgetWindow.dispose();
            widgetWindow = null;
        }
        MainWindow.getInstance().add(this);
        detachButton.setVisible(true);
        MainWindow.getInstance().revalidate();
        MainWindow.getInstance().repaint();
    }




    
}
