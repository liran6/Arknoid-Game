import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liran baruch.
 * Implementation of the Block class.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    // private Point upperLeft;
    //private double width;
    //private double height;
    private Rectangle rect;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    private int life;

    /**
     * Block constructor.
     *
     * @param upperLeft the upperLeft vertex of the block.
     * @param width     the width of the block.
     * @param height    the height of the block.
     * @param color     the color of the block.
     * @param life    the number of hits left written on the block.
     */
    /**
     * public Block(Point upperLeft, double width, double height, java.awt.Color color, int life) {
     * this.upperLeft = upperLeft;
     * this.width = width;
     * this.height = height;
     * this.color = color;
     * this.hitListeners = new ArrayList<HitListener>();
     * this.life = life;
     * }
     * /**
     * constructor.
     *
     * @param rect the rectangle of the block.
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        this.color = new Color(113, 89, 128);
        this.life = 3;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * constructor.
     *
     * @param rect  the rectangle of the block
     * @param color the color of the block
     * @param hits  the hits of the block
     */
    public Block(Rectangle rect, Color color, int hits) {
        this.rect = rect;
        this.color = color;
        this.life = life;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * constructor.
     *
     * @param upperLeft the x and y value of the upper point.
     * @param width     the width of the block
     * @param height    the height of the block
     * @param color     the color of the block
     * @param lifes     the life of the block.
     */
    public Block(Point upperLeft, int width, double height, Color color, int lifes) {
        this.rect = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.life = lifes;
        this.hitListeners = new ArrayList<HitListener>();
    }


    /**
     * create a rectangle with the variables given by the block constructor.
     *
     * @return rectangle.
     */

    public Rectangle getCollisionRectangle() {
        rect = new Rectangle(this.rect.getUpperLeft(), this.rect.getWidth(), this.rect.getHeight());
        return rect;
    }

    /**
     * Get the color of the current Block.
     *
     * @return - integer - color of the Block.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Get the string number written on the current Block.
     *
     * @return - string - the number on the Block.
     */
    public int getLife() {
        return this.life;
    }

    /**
     * @param surface surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY()
                , (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY()
                , (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.white);
        //surface.drawText((int) (this.upperLeft.getX() + this.width / 2) - 4
        //      , (int) (4 + this.upperLeft.getY() + this.height / 2), this.getNumber(), 17);

    }

    /**
     * create a list of hit listener.
     * @param hitter the hitting ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Add hl as a listener to hit events.
     * @param hl Hit Listener.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * // Remove hl from the list of listeners to hit events.
     * @param hl the Hit listener.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  the trajectory and rectangle collision point.
     * @param hitter          the hitting ball.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity velocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        double x = rect.getUpperLeft().getX();
        double y = rect.getUpperLeft().getY();
        Point upperLeft1 = new Point(x, y);
        Point upperRight = new Point(x + rect.getWidth(), y);
        Point lowerLeft = new Point(x, y + rect.getHeight());
        Point lowerRight = new Point(x + rect.getWidth(), y + rect.getHeight());
        Line upperLine = new Line(upperLeft1, upperRight);
        Line leftLine = new Line(upperLeft1, lowerLeft);
        Line rightLine = new Line(upperRight, lowerRight);
        Line bottomLine = new Line(lowerLeft, lowerRight);
        if (collisionPoint.getY() == upperLeft1.getY() && collisionPoint.getX() < upperRight.getX()
                && collisionPoint.getX() > upperLeft1.getX()) {
            velocity = new Velocity(velocity.getDx(), velocity.getDy() * -1);
        }
        if (collisionPoint.getY() > upperLeft1.getY() && collisionPoint.getY() < lowerLeft.getY()
                && collisionPoint.getX() == upperLeft1.getX()) {
            velocity = new Velocity(velocity.getDx() * -1, velocity.getDy());
        }
        if (collisionPoint.getY() > upperLeft1.getY() && collisionPoint.getY() < lowerLeft.getY()
                && collisionPoint.getX() == upperRight.getX()) {
            velocity = new Velocity(velocity.getDx() * -1, velocity.getDy());
        }
        if (collisionPoint.getY() == lowerLeft.getY() && collisionPoint.getX() > lowerLeft.getX()
                && collisionPoint.getX() < lowerRight.getX()) {
            velocity = new Velocity(velocity.getDx(), velocity.getDy() * -1);
        }

        if (collisionPoint.equals(upperLeft1) || collisionPoint.equals(upperRight)
                || collisionPoint.equals(lowerLeft) || collisionPoint.equals(lowerRight)) {
            velocity = new Velocity(velocity.getDx() * -1, velocity.getDy() * -1);
        }
        if (this.life > 0) {
            this.life--;
        }
        this.notifyHit(hitter);
        return velocity;
    }

    /**
     * set the upper Left point of the rectangle.
     *
     * @param x x value of the upper left point.
     * @param y y value of the upper left point.
     */
    public void setUpperLeft(double x, double y) {
        this.rect.setUpperLeft(x, y);
    }

    /**
     * does nothing for now.
     */
    public void timePassed() {

    }

    /**
     * add the sprite and collidable to the gameLevel.
     *
     * @param gameLevel the gameLevel class.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * remove the sprite and collidable from the gameLevel.
     *
     * @param gameLevel the gameLevel class.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

}
