import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Main {
    public static void main(String[] args) 
    {

        System.out.println("Pico GUI running...");       

        MainWindow mainWindow = MainWindow.getInstance();

        Widget Widget = new Widget(300, 150, new Color(0xFF, 0x00, 0x00));
        mainWindow.add(Widget);
        // Widget Widget2 = new Widget(300, 150, new Color(0xFF, 0x00, 0x00));

        // Plot2dWidget plot2dWidget = new Plot2dWidget(300, 150, new Color(0x00, 0xFF, 0x00));

        // mainWindow.add(plot2dWidget);
        // mainWindow.add(Widget2);
        // plot2dWidget.setVisible(true);

        ViewWidget rectangle = new ViewWidget(400, 300, new Color(181, 180, 180));
        mainWindow.add(rectangle);

        mainWindow.setVisible(true);

    }

}