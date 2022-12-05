import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Background 2.
 */
public class Background2 implements Sprite {

    /**
     * drawOn.
     * @param d the draw surface interface.
     */
    public void drawOn(DrawSurface d) {

        int centerX = 100;
        int centerY = 150;

        Block b = new Block(new Point(0, 0), 800, 600, new Color(224, 204, 219), 1);
        b.drawOn(d);

        d.setColor(new Color(237, 222, 150));


        for (int i = 0; i < 100; i++) {
            d.drawLine(100, 150, 10 * i, 300);
        }

        d.fillCircle(centerX, centerY, 60);


        d.setColor(new Color(242, 200, 94));
        d.fillCircle(centerX, centerY, 45);


        d.setColor(new Color(230, 212, 124));

        d.fillCircle(centerX, centerY, 35);

    }

    /**
     * does nothing.
     */
    public void timePassed() {

    }

}
