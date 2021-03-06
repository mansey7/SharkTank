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

    public Shark() {
        x = 100;
        y = (int)(Math.random()*401) + 40;//sets shark to come at a random position in the screen of range y = (60,440)
        yvel = 0;
        width = 45;
        height = 32;
        gravity = 0.5;
        jumpDelay = 0;
        rotation = 0.0;
        dead = false;

        keyboard = Keyboard.getInstance();
    }
    
    //refreshes the sharks position
    public void update() {
        yvel += gravity;

        if (jumpDelay > 0)
            jumpDelay--;

        if (!dead && keyboard.isDown(KeyEvent.VK_SPACE) && jumpDelay <= 0) {
            yvel = -7;
            jumpDelay = 5;
        }

        y += (int)yvel;
    }

    public Load getLoad() {
        Load r = new Load();
        r.x = x;
        r.y = y;

        if (image == null) {
            image = Util.loadImage("lib/Shark.png");     
        }
        r.image = image;

        rotation = (90 * (yvel + 20) / 20) - 90;
        rotation = rotation * Math.PI / 180;

        if (rotation > Math.PI / 2)
            rotation = Math.PI / 2;

        r.transform = new AffineTransform();
        r.transform.translate(x + width / 2, y + height / 2);
        r.transform.rotate(rotation);
        r.transform.translate(-width / 2, -height / 2);

        return r;
    }
}
