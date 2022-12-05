import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The type Background 4.
 */
public class Background4 implements Sprite {

    /**
     * drawOn.
     *
     * @param d the draw surface interface.
     */
    public void drawOn(DrawSurface d) {

        int x = 70;
        int y = 480;
        int width = 100;
        int height = 120;

        Block b = new Block(new Point(0, 0), 800, 600, new Color(89, 164, 222), 1);
        b.drawOn(d);

        d.setColor(new Color(206, 222, 235));

        for (int i = 0; i < 6; i++) {
            d.drawLine(100 + i * 9, 420, 100 + i * 10, 800);
        }

        d.setColor(new Color(206, 222, 235));
        d.fillCircle(100, 420, 30);
        d.fillCircle(110, 440, 30);


        d.setColor(new Color(194, 203, 209));
        d.fillCircle(130, 420, 35);
        d.fillCircle(140, 440, 35);

        d.setColor(new Color(178, 187, 194));
        d.fillCircle(120, 430, 25);
        d.fillCircle(130, 440, 30);


        for (int i = 0; i < 6; i++) {
            d.drawLine(600 + i * 9, 400, 600 + i * 10, 800);
        }
        d.setColor(new Color(206, 222, 235));
        d.fillCircle(600, 400, 30);
        d.fillCircle(610, 420, 30);


        d.setColor(new Color(194, 203, 209));
        d.fillCircle(630, 400, 35);
        d.fillCircle(640, 420, 35);

        d.setColor(new Color(178, 187, 194));
        d.fillCircle(620, 410, 25);
        d.fillCircle(630, 420, 30);


    }

    /**
     * does nothing.
     */
    public void timePassed() {

    }

}
