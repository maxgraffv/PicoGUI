import java.awt.*;
import java.awt.geom.*;


public class ViewWidget extends Widget {
    
    private int degrees; 

    int rectWidth;
    int rectHeight;

    ViewWidget(int width, int height)
    {
        super(width, height);
        this.degrees = 0;

        rectWidth = getWidth()/2;
        rectHeight = getHeight()/20;

        Thread t1 = new Thread( ()->{
            while(true)
            {

                setDegrees(getDegrees()+1);
                if(getDegrees() >= 360)
                    setDegrees(0);

                repaint();

                try{
                    Thread.sleep(20);
                }catch(Exception e)
                {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } );
        t1.start();

    }

    public void setDegrees(int deg)
    {
        degrees = deg;
    }

    public int getDegrees()
    {
        return degrees;
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(defaultBorderColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(defaultBackgroundColor);
        g2d.fillRect(10, 10, getWidth()-20, getHeight()-20);

        AffineTransform originalTransform = g2d.getTransform();

        rectWidth = getWidth()/2;
        rectHeight = getHeight()/20;

        g2d.translate( rectWidth , (getHeight()/2)-(rectHeight/2));
        g2d.rotate( Math.toRadians(degrees) );
        g2d.translate(-(rectWidth/2), 0);
        g2d.setColor(new Color(250, 250, 250));
        g2d.fillRect(0, 0, rectWidth, rectHeight);

        g2d.setTransform(originalTransform);
    }


}
