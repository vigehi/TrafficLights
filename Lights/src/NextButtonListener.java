import java.awt.event.*;

public class NextButtonListener implements ActionListener

{

    private Sequencer sequencer;
public NextButtonListener( Sequencer sequencer )
    {
        this.sequencer = sequencer;
    }
public void actionPerformed( ActionEvent event )
    {
        this.sequencer.next();
    }
}
class Sequencer {
    private TrafficLight light;
    private final static int GO = 0;
    private final static int CAUTION = 1;
    private final static int STOP = 2;
    private int currentState;
    public Sequencer(TrafficLight light) {
        this.light = light;
        this.currentState = GO;
        this.light.setGo();
    }
    public void next() {
        switch (currentState) {
            case GO:
                this.currentState = CAUTION;
                this.light.setCaution();
                break;
                case CAUTION:
                this.currentState = STOP;
                this.light.setStop();
                break;
                case STOP:
                this.currentState = GO;
                this.light.setGo();
                break;
                default: // This will never happen
                System.err.println("What color is the light?!");
        }
    }
}