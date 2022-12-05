import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * @author liran baruch.
 * Implementation of the SpriteCollection class.
 */
public class SpriteCollection {
    private List<Sprite> list;

    /**
     * creates a list for the sprite collection.
     */
    public SpriteCollection() {
        this.list = new ArrayList<Sprite>();
    }

    /**
     * adds a sprite to the list.
     *
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     * removes a sprite from the list.
     *
     * @param s sprite.
     */
    public void removeSprite(Sprite s) {
        this.list.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d draw surface interface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).drawOn(d);
        }
    }
}