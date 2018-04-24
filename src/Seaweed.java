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

    public void reset() {
        width = 66;
        height = 400;
        x = App.WIDTH + 2;

        if (position.equals("south")) {
            y = -(int)(Math.random() * 120) - height / 2;
        }
    }

    public void update() {
        x -= speed;
    }

   
}
