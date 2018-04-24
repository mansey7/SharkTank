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
            return;//update() will loop around to this point until game is started

        shark.update();// calls function to update the shark position on screen
        watchForReset();

        if (gameover)
            return;
         moveSeaweeds();
      }
    
    public void restart() {//resets all the variables , ready for new start of game
      
        started = false;
        gameover = false;

        score = 0;
 
        restartDelay = 0;
        seaweedDelay = 0;

        shark = new Shark();
        seaweeds = new ArrayList<Seaweed>();
    }
    
    private void watchForStart() {
        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) {//checks for start of the game by press of the space bar
            started = true;
        }
    }
    private void watchForReset() {
        if (restartDelay > 0)
            restartDelay--;//decrements the restart time

        if (keyboard.isDown(KeyEvent.VK_R) && restartDelay <= 0) {
            restart();
            restartDelay = 50;// this causes a delay on the restart button so it cannot be spammed
            return;
        }
    }
    private void moveSeaweeds() {
        seaweedDelay--;
        if (seaweedDelay < 0) {
            seaweedDelay = SEAWEED_DELAY;
            Seaweed northSeaweed = null;
            Seaweed southSeaweed = null;

            // Look for Seaweed off the screen
            for (Seaweed seaweed : seaweeds) {
                if (seaweed.x - seaweed.width < 0) {
                    if (northSeaweed == null) {
                        northSeaweed = seaweed;
                    } else if (southSeaweed == null) {
                        southSeaweed = seaweed;
                        break;
                    }
                }
            }//creates a north and south seaweed if they are not onscreen
            if (northSeaweed == null) {
            	Seaweed seaweed = new Seaweed("north");
            	seaweeds.add(seaweed);
                northSeaweed = seaweed;
            } else {
                northSeaweed.reset();
            }
            if (southSeaweed == null) {
            	Seaweed seaweed = new Seaweed("south");
            	seaweeds.add(seaweed);
                southSeaweed = seaweed;
            } else {
                southSeaweed.reset();
            }
            //sets the distance between the seaweeds
            northSeaweed.y = southSeaweed.y + southSeaweed.height + 175;
        }//calls function to move seaweed
        for (Seaweed seaweed : seaweeds) {
        	seaweed.update();
        }
    }
    
}
