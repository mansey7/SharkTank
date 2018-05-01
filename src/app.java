import javax.swing.*;

public class App {
    
    //sets the size of the app screen
    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    
    //made the method for setting up the gaming app
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);

        GamePanel panel = new GamePanel();
        frame.add(panel);
    }
}
