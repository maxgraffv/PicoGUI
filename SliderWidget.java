import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderWidget extends Widget{
    
    JSlider slider;

    private DataWidget valueDisplay;

    SliderWidget(int width, int height, int min, int max)
    {
        super(width, height);

        slider = new JSlider();
        slider.setPreferredSize(new Dimension(width/2, height/2));
        slider.setMaximum(max);
        slider.setMinimum(min);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                if(valueDisplay != null)
                {
                    valueDisplay.setData(slider.getValue());
                    valueDisplay.showRefresh();
                }
                
            }
        });

        this.add(slider);
    }

    public void setDisplay(DataWidget dw)
    {
        this.valueDisplay = dw;
        valueDisplay.setData(slider.getValue());
        valueDisplay.showRefresh();
    }

}
