import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level indicator.
 */
public class LevelIndicator implements Sprite {
    private Rectangle rec;
    private LevelInformation levelInformation;

    /**
     * Instantiates a new Level indicator.
     *
     * @param rec              the rec
     * @param levelInformation the level information
     */
    public LevelIndicator(Rectangle rec, LevelInformation levelInformation) {
        this.levelInformation = levelInformation;
        this.rec = rec;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the draw surface interface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.drawText((int) Math.round(this.rec.getUpperLeft().getX()) + (int) Math.round(this.rec.getWidth()) / 2
                        + (int) Math.round(this.rec.getWidth()) / 4
                , ((int) Math.round(this.rec.getUpperLeft().getY()
                        + (int) Math.round(this.rec.getHeight()) / 2 + 5)),
                "Level Name: " + (this.levelInformation.levelName()), 17);
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

