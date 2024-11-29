import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Main {
    public static void main(String[] args) 
    {

        System.out.println("Pico GUI running...");       


        DataParser dp = new DataParser("data.txt");

        for(int i = 0; i < dp.getDataPoints().size(); i++)
        {

            for(int j = 0; j < dp.getDataPoints().get(i).size(); j++)
            {
                System.out.print(" |"+ dp.getDataPoints().get(i).get(j)+ "| ");
            }
            System.out.print("\n ->");
        }




        MainWindow mainWindow = MainWindow.getInstance();


        Plot2dWidget plot2dWidget = new Plot2dWidget(600, 300);
        mainWindow.add(plot2dWidget);

        DataWidget dataWidget = new DataWidget(200, 150);
        mainWindow.add(dataWidget);

        ViewWidget rectangle = new ViewWidget(300, 300);
        mainWindow.add(rectangle);

        SliderWidget sliderWidget = new SliderWidget(200, 400, 0, 10);
        sliderWidget.setDisplay(dataWidget);
        mainWindow.add(sliderWidget);

        mainWindow.setVisible(true);

    }

}