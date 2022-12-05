import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The type Life indicator.
 */
public class LifeIndicator implements Sprite {
    private Rectangle rec;
    private Counter remainingLife;

    /**
     * Instantiates a new Life indicator.
     *
     * @param rec           the rec
     * @param remainingLife the remaining life
     */
    public LifeIndicator(Rectangle rec, Counter remainingLife) {
        this.remainingLife = remainingLife;
        this.rec = rec;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the draw surface interface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.drawText((int) Math.round(this.rec.getUpperLeft().getX())
                        + (int) Math.round(this.rec.getWidth()) / 4
                , ((int) Math.round(this.rec.getUpperLeft().getY()
                        + (int) Math.round(this.rec.getHeight()) / 2 + 5)),
                "Lives: " + Integer.toString(this.remainingLife.getValue()), 17);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {

    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

