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
  
}
