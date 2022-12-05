/**
 * @author liran baruch.
 * Implementation of the Point class.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Point object constructor.
     *
     * @param x **X value for the constructed Point**
     * @param y **Y value for the constructed Point**
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns the distance between the current Point and another Point.
     *
     * @param other **Point which distance will be measured to**
     * @return **double - the distance between both Points**
     */
    public double distance(Point other) {
        double x1 = this.x;
        double x2 = other.x;
        double y1 = this.y;
        double y2 = other.y;
        double distance = Math.sqrt((x1 - (x2)) * (x1 - (x2)) + ((y1 - (y2)) * (y1 - (y2))));
        return distance;
    }

    /**
     * compares X and Y values of both points. If at least one differs, returns false, otherwise true.
     *
     * @param other **Point which will be compared to the current Point**
     * @return **boolean - true if equals, false otherwise**
     */
    public boolean equals(Point other) {
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }

    /**
     * Getter for the X field of the current Point.
     *
     * @return x  **double - X value of current Point**
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter for the Y field of the current Point.
     *
     * @return y  **double - Y value of current Point**
     */
    public double getY() {
        return this.y;
    }
}