import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//polymorphism used
public class Keyboard implements KeyListener {
    
    private static Keyboard instance;

    private boolean[] keys;
    
      private Keyboard() {
        keys = new boolean[256];
    }
    
    public static Keyboard getInstance() {

        if (instance == null) {
            instance = new Keyboard();
        }
        
        return instance;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() >= 0 && e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() >= 0 && e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = false;
        }
    }
  
}
