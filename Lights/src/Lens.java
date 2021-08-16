import java.awt.*;

public class Lens extends Canvas
{
    private Color onColor;                // color on
    private Color offColor = Color.black; // color off
    private Color currentColor;           // color the lens is now
    private final static int SIZE = 100;  // how big is this Lens?
    private final static int OFFSET = 20; // offset of Lens in Canvas
    public Lens( Color color )
    {
        this.setBackground( Color.black );
        this.onColor = color;
        this.setSize( SIZE , SIZE );
        this.turnOff();
    }
    public void paint( Graphics g )
    {
        g.setColor( this.currentColor );
        g.fillOval( OFFSET, OFFSET,
                SIZE - OFFSET*2, SIZE - OFFSET*2 );
    }
    public void turnOn()

    {
        currentColor = onColor;
        this.repaint();
    }
    public void turnOff()
    {
        currentColor = offColor;
        this.repaint();
    }
}

