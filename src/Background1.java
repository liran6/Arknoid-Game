import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Background 1.
 */
public class Background1 implements Sprite {

    /**
     * drawOn.
     * @param d the draw surface interface.
     */
    public void drawOn(DrawSurface d) {

        int width = 20;
        int height = 20;
        double upperX = 400 + width / 2 - 15;
        double upperY = 200;
        int lineLength = 150;
        Block b = new Block(new Point(0, 0), 800, 600, Color.black, 1);

        b.drawOn(d);
        d.setColor(new Color(33, 207, 126));

        d.drawLine((int) upperX + height / 2, (int) upperY + height / 2
                , (int) upperX + height / 2 + lineLength, (int) upperY + height / 2);

        d.drawLine((int) upperX + width / 2, (int) upperY + 20
                , (int) upperX + width / 2, (int) upperY - lineLength);

        d.drawLine((int) upperX, (int) upperY + height / 2
                , (int) upperX - lineLength, (int) upperY + height / 2);

        d.drawLine((int) upperX + width / 2, (int) upperY + height
                , (int) upperX + width / 2, (int) upperY + height + lineLength);

        d.drawCircle((int) upperX + width / 2, (int) upperY + height / 2, 50);
        d.drawCircle((int) upperX + width / 2, (int) upperY + height / 2, 100);
        d.drawCircle((int) upperX + width / 2, (int) upperY + height / 2, 150);
    }

    /**
     * does nothing.
     */
    public void timePassed() {

    }

}
