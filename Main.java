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
        // plot2dWidget.setVisible(true);

        ViewWidget rectangle = new ViewWidget(300, 300);
        mainWindow.add(rectangle);
        mainWindow.setVisible(true);

    }

}