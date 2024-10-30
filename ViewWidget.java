import java.awt.*;
import java.awt.geom.*;


public class ViewWidget extends Widget {
    
    

    ViewWidget(int width, int height, Color bg_color)
    {
        super(width, height, bg_color);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(250, 0, 0));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(new Color(0, 250, 0));
        g2d.fillRect(10, 10, getWidth()-20, getHeight()-20);

        AffineTransform originalTransform = g2d.getTransform();

        g2d.translate(20, 40);
        g2d.rotate(Math.toRadians(45),200, 150);
        g2d.setColor(new Color(0, 0, 250));
        g2d.fillRect(100, 100, 200, 20);

        g2d.setTransform(originalTransform);
    }


}
