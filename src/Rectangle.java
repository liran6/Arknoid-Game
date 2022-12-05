import java.util.ArrayList;
import java.util.List;


/**
 * The type Rectangle.
 *
 * @author liran baruch. Implementation of the Rectangle class.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;


    /**
     * constructor Create a new rectangle with location and width/height.
     *
     * @param upperLeft the upperLeft vertex of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    /**
     * fuction creates a list of intersection points.
     *
     * @param line the trajectory line.
     * @return a (possibly empty) List of intersection points
     */
    public List intersectionPoints(Line line) {
        List<Point> intersectionpoints = new ArrayList<Point>();
        double x = this.getUpperLeft().getX();
        double y = this.getUpperLeft().getY();
        Point upperRight = new Point(x + this.getWidth(), y);
        Point lowerLeft = new Point(x, y + this.getHeight());
        Point lowerRight = new Point(x + this.getWidth(), y + this.getHeight());
        Line upperLine = new Line(this.upperLeft, upperRight);
        Line leftLine = new Line(this.upperLeft, lowerLeft);
        Line rightLine = new Line(upperRight, lowerRight);
        Line bottomLine = new Line(lowerLeft, lowerRight);

        if (upperLine.isIntersecting(line)) {
            Point p1 = upperLine.intersectionWith(line);
            intersectionpoints.add(p1);
        }
        if (bottomLine.isIntersecting(line)) {
            Point p1 = upperLine.intersectionWith(line);
            intersectionpoints.add(p1);
        }
        if (leftLine.isIntersecting(line)) {
            Point p1 = upperLine.intersectionWith(line);
            intersectionpoints.add(p1);
        }
        if (rightLine.isIntersecting(line)) {
            Point p1 = upperLine.intersectionWith(line);
            intersectionpoints.add(p1);
        }

        return intersectionpoints;
    }

    /**
     * Return the width of the rectangle.
     *
     * @return Return the width of the rectangle.
     */
    public double getWidth() {

        return this.width;
    }

    /**
     * Return the height of the rectangle.
     *
     * @return Return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }


    /**
     * Gets upper left.
     *
     * @return Returns the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {

        return this.upperLeft;
    }

    /**
     * set the upper Left point of the rectangle.
     *
     * @param x x value of the upper left point.
     * @param y y value of the upper left point.
     */
    public void setUpperLeft(double x, double y) {
        this.upperLeft = new Point(x, y);
    }

}
