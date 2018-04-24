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

    public boolean collides(int _x, int _y, int _width, int _height) {

        

        if (_x + _width > x && _x < x + width) {

            if (position.equals("south") && _y < y + height) {
                return true;
            } else if (position.equals("north") && _y + _height > y) {
                return true;
            }
        }

        return false;
    }

    public Load getLoad() {
        Load r = new Load();
        r.x = x;
        r.y = y;

        if (image == null) {
            image = Util.loadImage("lib/seaweed-" + position + ".png");
        }
        r.image = image;

        return r;
    }
}
