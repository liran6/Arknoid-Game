import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The type Ball.
 *
 * @author liran baruch. Implementation of the Ball class.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private int widthX1;
    private int widthX2;
    private int hightY1;
    private int hightY2;

    /**
     * Ball object constructor.
     *
     * @param center          center Point of the Ball.
     * @param r               radius of the Balls inner circle.
     * @param color           color of the Ball.
     * @param gameEnvironment the game environment.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Get the X value of the current Balls center Point.
     *
     * @return - integer - X value of the center Point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Get the Y value of the current Balls center Point.
     *
     * @return - integer - Y value of the center Point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Get radius value of the current Balls center Point.
     *
     * @return - integer - radius value of the center Point.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Get the color of the current Balls center Point.
     *
     * @return - integer - color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param surface surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(getX(), getY(), getSize());
        surface.setColor(Color.black);
        surface.drawCircle(getX(), getY(), getSize());

    }

    /**
     * Sets velocity.
     *
     * @param v the velocity value.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity.
     *
     * @param dx the delta x of the velocity.
     * @param dy the delta y of the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return velocity. velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Sets limit.
     *
     * @param x1 the right limit of the window.
     * @param y1 the upper limit of the window.
     * @param x2 the left limit of the window.
     * @param y2 the lower limit of the window.
     */
    public void setLimit(int x1, int y1, int x2, int y2) {
        this.widthX1 = x1;
        this.hightY1 = y1;
        this.widthX2 = x2;
        this.hightY2 = y2;
    }

    /**
     * apply the velocity.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo collisionInfo = (gameEnvironment.getClosestCollision(trajectory));
        if (collisionInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            Velocity newVelocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), velocity);
            this.setVelocity(newVelocity);
        }
    }

    /**
     * move the ball one step after the limit time frame has passed.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * add the update ball to the game object.
     *
     * @param g the game object.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * removes this ball from game g.
     *
     * @param g the game from which the ball is removed
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}

