import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.util.List;
import java.util.ArrayList;


public class Plot2dWidget extends Widget {
    
    private List<Point> pointsList = new ArrayList<>();
    float shift;

    List<List<Double>> dataList;

    Plot2dWidget(int width, int height)
    {
        super(width, height);
        shift = 0;

        DataParser dp = new DataParser("data.txt");
        dataList = dp.getDataPoints(); 
        

        // Thread t1 = new Thread( ()->{
        //     while(true)
        //     {

        //         update();
        //         repaint();

        //         try{
        //             Thread.sleep(20);
        //         }catch(Exception e)
        //         {
        //             Thread.currentThread().interrupt();
        //             break;
        //         }
        //     }
        // } );
        // t1.start();

        addComponentListener(new ComponentAdapter()
            {
                @Override
                public void componentResized(ComponentEvent e) {
                    repaint();
                };
            }
        );


        



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

        int w = getWidth();
        int h = getHeight();

        // setBackground(Color.BLACK);
        g2d.setColor(defaultBackgroundColor);
        g2d.fillRect(10, 10, w-20, h-20);

        g2d.setColor(Color.RED);

        pointsList.clear();
        int x = 0;
        for (int k = 0; k < dataList.size(); k++ ) {
            x += w/dataList.size();

            pointsList.add(new Point(x, dataList.get(k).get(0)));
        }

        System.out.println(dataList.size());

        
        System.out.println("##########");

        for(int i = 1; i < pointsList.size(); i++)
        {
            g2d.drawLine( (int)(pointsList.get(i-1).x), (int)pointsList.get(i-1).y*20 + 40,
                (int)pointsList.get(i).x, (int)pointsList.get(i).y*20 + 40
            );

            System.out.println( "Point x: "+pointsList.get(i).x + " \ty:"+ pointsList.get(i).y );
        }
        System.out.println("##########");

        g2d.setColor(Color.WHITE);

        g2d.drawLine(0, h/2, w, h/2); //x axis
        g2d.drawLine(w / 2, 0, w /2, h); //y axis

    }

}
