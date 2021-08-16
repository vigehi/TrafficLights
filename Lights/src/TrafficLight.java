import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends Panel
{
    private Lens red          = new Lens( Color.red );
    private Lens yellow       = new Lens( Color.yellow );
    private Lens green        = new Lens( Color.green );
    private Button nextButton = new Button("Next");
    public TrafficLight()
    {
        this.setLayout(new BorderLayout());
        Panel lensPanel = new Panel();
        lensPanel.setLayout( new GridLayout( 3, 1 ) );
        lensPanel.add( red );
        lensPanel.add( yellow );
        lensPanel.add( green );
        this.add( BorderLayout.NORTH, lensPanel );
        Sequencer sequencer = new Sequencer( this );
        NextButtonListener payAttention =
                new NextButtonListener( sequencer );
        nextButton.addActionListener( payAttention );
        this.add( BorderLayout.CENTER, nextButton);
    }
    public void setStop()
    {
        red.turnOn();
        yellow.turnOff();
        green.turnOff();
    }
    public void setCaution()
    {
        red.turnOff();
        yellow.turnOn();
        green.turnOff();
    }
    public void setGo()
    {
        red.turnOff();
        yellow.turnOff();
        green.turnOn();
    }
    public static void main( String[] args )
    {
        Frame frame         = new Frame();
        TrafficLight light  = new TrafficLight();
        frame.add( light );
        frame.addWindowListener( new ShutDownLight() );
        frame.pack();
        frame.show();
    }
    private static class ShutDownLight extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }
}


