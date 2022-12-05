import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Paddle.
 *
 * @author liran baruch. Implementation of the Paddle class.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block paddle;
    private double speed;

    /**
     * the constructor of the puddle object.
     *
     * @param keyboard the keyboard sensor object.
     * @param paddle   build a block paddle.
     * @param speed    the speed
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Block paddle, int speed) {
        this.keyboard = keyboard;
        this.paddle = paddle;
        this.speed = speed;
    }

    /**
     * function move left.
     */
    public void moveLeft() {
        if (this.paddle.getCollisionRectangle().getUpperLeft().getX() < 21) {
            this.paddle.setUpperLeft(20, this.getCollisionRectangle().getUpperLeft().getY());
        } else {
            this.paddle.setUpperLeft((this.getCollisionRectangle().getUpperLeft().getX() - this.speed)
                    , this.getCollisionRectangle().getUpperLeft().getY());
        }
    }

    /**
     * function to move right.
     */
    public void moveRight() {
        if ((this.paddle.getCollisionRectangle().getUpperLeft().getX() + this.paddle.getCollisionRectangle().getWidth())
                > 779) {
            this.paddle.setUpperLeft(780 - (this.paddle.getCollisionRectangle().getWidth())
                    , this.getCollisionRectangle().getUpperLeft().getY());
        } else {
            this.paddle.setUpperLeft(this.getCollisionRectangle().getUpperLeft().getX() + this.speed
                    , this.getCollisionRectangle().getUpperLeft().getY());
        }
    }

    /**
     * make movement if the keyboard is pressed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the puddle to the game.
     *
     * @param d the draw surface interface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.paddle.getColor());
        d.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX()
                , (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
    }

    /**
     * function returns the collision rectangle.
     *
     * @return the paddle rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * This mathod sets the paddle's location.
     *
     * @param p the upper left point of the new rec location
     */
    public void initializePaddleLocation(Point p) {
        this.paddle.setUpperLeft(p.getX(), p.getY());
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  the trajectory and rectangle collision point.
     * @param currentVelocity the current velocity.
     * @param hitter          the hitting ball.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double fragment = this.paddle.getCollisionRectangle().getWidth() / 5;
       // double ballSpeed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        double xRec = this.getCollisionRectangle().getUpperLeft().getX();
        // check which part of the paddle was hit and determine the angle.
        if (collisionPoint.getX() >= (xRec + (0 * fragment)) && collisionPoint.getX() < (xRec + (1 * fragment))) {
            return Velocity.fromAngleAndSpeed(150, currentVelocity.getSpeed());

        }
        if (collisionPoint.getX() >= (xRec + (1 * fragment)) && collisionPoint.getX() < (xRec + (2 * fragment))) {
            return Velocity.fromAngleAndSpeed(120, currentVelocity.getSpeed());

        }
        if (collisionPoint.getX() >= (xRec + (2 * fragment)) && collisionPoint.getX() < (xRec + (3 * fragment))) {
            //return velocity.fromAngleAndSpeed(360, speed);
            return new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());

        }
        if (collisionPoint.getX() >= (xRec + (3 * fragment)) && collisionPoint.getX() < (xRec + (4 * fragment))) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }
        if (collisionPoint.getX() >= (xRec + (4 * fragment)) && collisionPoint.getX() < (xRec + (5 * fragment))) {
            return Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        }
        //if (currentVelocity.getDy() < 0) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        //}
    }


    /**
     * Add this paddle to the game.
     *
     * @param g game object.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}