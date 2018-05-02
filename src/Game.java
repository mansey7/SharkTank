import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
    
    public static final int SEAWEED_DELAY = 100;
    
    private int restartDelay;
    private int seaweedDelay;
    private Shark shark;
    
    private Keyboard keyboard;
    private ArrayList<Seaweed> seaweeds;

    public int score;
    public int val;
    public Boolean gameover;
    public Boolean started;
    public Boolean win;

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
        val = score;
        if(val == 5) {// this checks the score value and if it is 5 displays the win screen
        	gameover = true;
        	win = true;}
        if (gameover)
            return;
        if(win)
        	return;
        
         moveSeaweeds();
        checkYoSelfBeforeYoWreckYoself();
      }
    
    public void restart() {//resets all the variables , ready for new start of game
      
        started = false;
        gameover = false;
        win = false;

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
    
      public ArrayList<Load> getLoads() {
        ArrayList<Load> loads = new ArrayList<Load>();
        loads.add(new Load(0, 0, "lib/background.png"));
        for (Seaweed seaweed : seaweeds)
            loads.add(seaweed.getLoad());
        //loads.add(new Load(0, 0, "lib/foreground.png"));
        loads.add(shark.getLoad());
        return loads;
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
            northSeaweed.y = southSeaweed.y + southSeaweed.height + 140;
        }//calls function to move seaweed
        for (Seaweed seaweed : seaweeds) {
        	seaweed.update();
        }
    }
    
      private void checkYoSelfBeforeYoWreckYoself() {
    	
        for (Seaweed seaweed : seaweeds) {
            if (seaweed.collides(shark.x, shark.y, shark.width, shark.height)) {// calls the collision function
                gameover = true;
                shark.dead = true;
            }
            else if (shark.x > seaweed.x +100 && seaweed.position.equalsIgnoreCase("south") ) {//updates the score if there was no collision
                score++;
                
              
            
        }

        // Seabed + shark collision
        if (shark.y + shark.height > App.HEIGHT - 80) {
            gameover = true;
            shark.y = App.HEIGHT - 80 - shark.height;
        }
    }
    }
    
}
