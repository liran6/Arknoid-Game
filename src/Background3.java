import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The type Background 3.
 */
public class Background3 implements Sprite {

    /**
     * drawOn.
     * @param d the draw surface interface.
     */
    public void drawOn(DrawSurface d) {

        int x = 70;
        int y = 480;
        int width = 100;
        int height = 120;

        Block b = new Block(new Point(0, 0), 800, 600, new Color(81, 201, 145), 1);
        b.drawOn(d);

        d.setColor(Color.black);
        d.fillRectangle(x, y, width, height);

        d.setColor(Color.white);
        d.fillRectangle(x + 10, y + 10, width - 20, height - 20);

        int tempX = x;
        d.setColor(Color.black);
        for (int i = 1; i <= 5; i++) {
            d.fillRectangle(tempX, y, 9, height);
            tempX += 18;
        }

        for (int i = 1; i <= 5; i++) {
            d.fillRectangle(x, y, width, 6);
            y += height / 4;
        }

        d.setColor(new Color(49, 56, 46));
        d.fillRectangle(x + width / 2 - 20, 430, 40, 50);

        d.setColor(new Color(92, 99, 90));
        d.fillRectangle(x + width / 2 - 5, 250, 10, 180);

        d.setColor(new Color(237, 222, 150));
        d.fillCircle(x + width / 2, 230, 10);

        d.setColor(new Color(242, 200, 94));
        d.fillCircle(x + width / 2, 230, 7);

        d.setColor(new Color(191, 101, 121));
        d.fillCircle(x + width / 2, 230, 3);
    }

    /**
     * does nothing.
     */
    public void timePassed() {

    }

}
