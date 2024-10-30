import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    Dimension screenSize;
    int screenHeight;
    int screenWidth;

    static Color defaultColor = new Color(0, 0, 30);

    static private MainWindow instance = null;
    
    private MainWindow()
    {

            this.setTitle("Pico");
            screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            screenHeight = (int)(((float)screenSize.height) * 0.7);
            screenWidth = (int)(((float)screenSize.width) * 0.7);
            this.setSize(screenWidth, screenHeight);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setBackground(defaultColor);
            getContentPane().setBackground(defaultColor);
            this.setVisible(true);
    }

    public static MainWindow getInstance()
    {
        if(instance == null)
        {
            instance = new MainWindow();
        }
        return instance;
    }


}
