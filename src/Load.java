import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Load {
    public int x;
    public int y;
    public Image image;
    public AffineTransform transform;//Java function which allows for the parallelness and straightness of lines

    public Load() {
    }
    
    public Load(int x, int y, String imagePath) {//function to load images onto screen
        this.x = x;
        this.y = y;
        this.image = Util.loadImage(imagePath);
    }
}

