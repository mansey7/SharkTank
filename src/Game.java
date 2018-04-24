import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
    private Shark shark;
    private Keyboard keyboard;

    public int score;
    public Boolean gameover;
    public Boolean started;

    public Game() {
        keyboard = Keyboard.getInstance();
        restart();
    }
    public void update() {
        watchForStart();

        if (!started)
            return;

        shark.update();

        if (gameover)
            return;
      }
    private void watchForStart() {
        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) {
            started = true;
        }
    }
}
