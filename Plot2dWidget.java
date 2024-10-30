import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;


public class Plot2dWidget extends Widget {
    
    private List<Point> pointsList = new ArrayList<>();
    float shift;

    Plot2dWidget(int width, int height, Color bg_color)
    {
        super(width, height, bg_color);
        shift = 0;

        for (int x = 0; x <= width; x += 1) {
            pointsList.add(new Point(x, (int) (height/2 + 25 * Math.sin((x * 0.1) + shift))));
        }

    }

    public void update()
    {
        shift += 0.5;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        setBackground(Color.BLACK);
        int w = getWidth();
        int h = getHeight();


        g2d.setColor(Color.RED);

        

        for(int i = 1; i < pointsList.size(); i++)
        {


            g2d.drawLine(pointsList.get(i-1).x, pointsList.get(i-1).y,
                pointsList.get(i).x, pointsList.get(i).y
            );
        }

        g2d.setColor(Color.WHITE);

        g2d.drawLine(0, h/2, w, h/2); //x axis
        g2d.drawLine(w / 2, 0, w /2, h); //y axis
    }

}
