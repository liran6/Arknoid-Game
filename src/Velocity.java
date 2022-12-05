/**
 * @author liran baruch.
 * Implementation of the Velocity class.
 */
public class Velocity {
    private double dx;
    private double dy;
    //private double speed;

    /**
     * Velocity object constructor.
     *
     * @param deltaX **change in X axe**
     * @param deltaY **change in Y axe**
     */
    public Velocity(double deltaX, double deltaY) {
        this.dx = deltaX;
        this.dy = deltaY;
    }

    /**
     * Getter for dx field.
     *
     * @return **current dx**
     */
    public int getDx() {
        return (int) this.dx;
    }

    /**
     * Getter for dy field.
     *
     * @return **current dy**
     */
    public int getDy() {
        return (int) this.dy;
    }

    /**
     * applies velocity to Point, thus returning the new Point after the "move" according to Velocity.
     *
     * @param p **current Point the object is at**
     * @return **Point - new Point the object "moved" to**
     */
    public Point applyToPoint(Point p) {
        Point newP = new Point(p.getX() + getDx(), p.getY() + getDy());
        return newP;
    }
    /**
     * static method which allows setting Velocity from angle and speed.
     *
     * @param angle **angle which we want the Ball to move in**
     * @param speed **speed in which we want the Ball to move at**
     * @return **Velocity - new Velocity according to inputed angle and speed**
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(Math.toRadians(angle));
        double dy = speed * Math.sin(Math.toRadians((-1 * angle)));
        return new Velocity(dx, dy);
    }

    /**
     * This mathod returns the speed according to the dx and dy values.
     * @return the speed according to the dx and dy values.
     */
    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }

}