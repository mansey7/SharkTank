import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    private Game game;

    public GamePanel() {
        game = new Game();
        new Thread(this).start();
    }

    public void update() {
        game.update();
        repaint();
    }

    protected void paintComponent(Graphics g) {//lots of drawing code for putting the various strongs on screen
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        for (Load r : game.getLoads())
            if (r.transform != null)
                g2D.drawImage(r.image, r.transform, null);
            else
                g.drawImage(r.image, r.x, r.y, null);
             
        g2D.setColor(Color.WHITE);
        if (!game.started) {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press SPACE to start", 150, 240);
        } else {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 24));
            g2D.drawString(Integer.toString(game.score), 10, 445);
        }

        if (game.gameover && !game.win) {
        	g2D.setColor(Color.RED);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            g2D.drawString("WASTED", 115, 60);
            g2D.setColor(Color.WHITE);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 40));
            g2D.drawString("Your Score : " + game.score , 100, 200);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press R to restart", 150, 240);
        }
        if (game.win) {
        	g2D.setColor(Color.YELLOW);
        	g2D.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        	g2D.drawString("Congratulations You Win", 75, 60);
        	g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press R to restart", 150, 240);
        }
        
        }
    

    public void run() {
        try {
            while (true) {
                update();
                Thread.sleep(25);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
