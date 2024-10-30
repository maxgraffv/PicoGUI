import java.awt.*;
import javax.swing.*;

public class DataWidget extends Widget{

    private int data;
    private String dataString;
    private JLabel dataLabel;

    DataWidget(int width, int height)
    {
        super(width, height);
        data = 0;
        dataString = Integer.toString(data);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        dataLabel = new JLabel();
        dataLabel.setFont(new Font("Arial", Font.BOLD, height/3));
        dataLabel.setForeground(Color.WHITE);
        dataLabel.setPreferredSize(new Dimension(width/2, height/2));
        dataLabel.setText(dataString);
        dataLabel.setVisible(true);

        this.add(dataLabel);
    }

    public void setData(int data)
    {
        this.data = data;
        dataString = Integer.toString(data);

    }

    public void showRefresh()
    {
        dataLabel.setText(dataString);

    }
    
}
