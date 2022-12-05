import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.Random;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private boolean won;
    private int score;
    private KeyboardSensor ks;
    private Sleeper sleeper;
    private boolean first;


    /**
     * Instantiates a new End screen.
     *
     * @param won   the won
     * @param score the score
     * @param ks    the ks
     */
    public EndScreen(boolean won, int score, KeyboardSensor ks) {
        this.won = won;
        this.score = score;
        this.ks = ks;
        this.sleeper = new Sleeper();
        this.first = true;
    }

    /**
     * draw on frame.
     *
     * @param d the gui surface.
     */
    public void doOneFrame(DrawSurface d) {


        if (this.won) {

            d.setColor(Color.white);
            //d.setColor(new Color(184, 40, 91));
            d.fillRectangle(0, 0, 800, 600);

            Color color = new Color(23, 234, 190);
            int r = 23;
            int g = 234;
            int b = 190;

            int x;
            int y;
            Random rn = new Random();
            for (int i = 0; i <= 100; i++) {

                x = rn.nextInt(800);
                y = rn.nextInt(600);
                d.setColor(new Color(r, g, b));
                r = (int) (Math.random() * 256);
                g = (int) (Math.random() * 256);
                b = (int) (Math.random() * 256);
                d.fillCircle(x, y, 20);
                d.drawLine(x, y, y, x);
                d.drawLine(y, x, x, y);

            }


            d.setColor(Color.black);

            d.drawText(100, d.getHeight() / 3, "You Win!", 60);
            d.drawText(80, d.getHeight() / 2, "Your score is: " + this.score, 60);
            d.drawText(80, d.getHeight() / 2 + d.getHeight() / 3, "Press Space to continue", 60);

            if (this.first) {
                this.first = false;
            } else {
                this.sleeper.sleepFor(200);
            }

        } else {
            d.setColor(Color.black);
            d.fillRectangle(0, 0, 800, 600);

            d.setColor(Color.white);
            d.drawText(100, d.getHeight() / 3, "Game Over!", 100);
            d.drawText(100, d.getHeight() / 2, "Your score is: " + this.score, 60);
            d.drawText(80, d.getHeight() / 2 + d.getHeight() / 3, "Press Space to continue", 60);

        }

    }

    /**
     * boolean function to recognize the space pressed.
     *
     * @return true or false.
     */
    public boolean shouldStop() {
        if (ks.isPressed(KeyboardSensor.SPACE_KEY)) {
            return true;
        }
        return false;
    }
}
