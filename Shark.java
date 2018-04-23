import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Shark {

    public int x;
    public int y;
    public int width;
    public int height;

    public boolean dead;

    public double yvel;
    public double gravity;

    private int jumpDelay;
    private double rotation;

    private Image image;
    private Keyboard keyboard;

    //declaring the shark constructor
    public Shark() {
        x = 100;
        y = 150;
        yvel = 0;
        width = 45;
        height = 32;
        gravity = 0.5;
        jumpDelay = 0;
        rotation = 0.0;
        dead = false;

       
    }

}
