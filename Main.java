import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Main {
    public static void main(String[] args) 
    {

        System.out.println("Pico GUI running...");       

        MainWindow mainWindow = MainWindow.getInstance();


        Plot2dWidget plot2dWidget = new Plot2dWidget(300, 150);
        mainWindow.add(plot2dWidget);

        DataWidget dataWidget = new DataWidget(200, 150);
        mainWindow.add(dataWidget);

        ViewWidget rectangle = new ViewWidget(300, 300);
        mainWindow.add(rectangle);

        SliderWidget sliderWidget = new SliderWidget(200, 400);
        sliderWidget.setDisplay(dataWidget);
        mainWindow.add(sliderWidget);

        mainWindow.setVisible(true);

    }

}