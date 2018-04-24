import java.awt.Image;

public class Seaweed {

    public int x;
    public int y;
    public int width;
    public int height;
    public int speed = 5;

    public String position;

    private Image image;

    public Seaweed(String position) {
        this.position = position;
        reset();
    }

  
}
