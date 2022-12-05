/**
 * The type Line.
 *
 * @author liran baruch. Implementation of the Line class, which uses the Point class.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor which derives corresponding coordinates from Point objects as arguments.
     *
     * @param start **start Point of the Line**
     * @param end   **end Point of the Line
     **/
// constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Line object constructor for coordinates sent as arguments without creating a Point object.
     *
     * @param x1 **X value of Line starting Point**
     * @param y1 **Y value of Line starting Point**
     * @param x2 **X value of Line ending Point**
     * @param y2 **Y value of Line ending Point
     **/
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * length of current Line method.
     *
     * @return **double - length of current Line, using Point class distance method
     **/
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * method calculating the middle Point of current Line.
     *
     * @return mid **middle point of current Line
     **/
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(midX, midY);
        return middle;
    }

    /**
     * returns starting Point of the current Line.
     *
     * @return start **starting Point of the current Line
     **/
    public Point start() {
        return this.start;
    }

    /**
     * returns ending Point of the current Line.
     *
     * @return end **ending Point of the current Line
     **/
    public Point end() {
        return this.end;
    }

    /**
     * checks if two Lines intersect.
     *
     * @param other **the Line we check intersection with**
     * @return **boolean - true if Lines intersect, otherwise false
     **/
    public boolean isIntersecting(Line other) {
        if (this.intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * calculates and returns the intersection Point between two Lines.
     *
     * @param other **the Line which will be intersected with the current Line**
     * @return intersection **the intersection Point
     **/
    public Point intersectionWith(Line other) {

        double x;
        double y;

        if (this.equals(other)) {
            return null;
        }
        //equations of the form x=c (two vertical lines)
        if (this.start.getX() == this.end.getX()
                && other.start.getX() == other.end.getX()
                && this.start.getX() == other.start.getX()) {
            return null;
        }

        //equations of the form y=c (two horizontal lines)
        if (this.start.getY() == this.end.getY()
                && other.start.getY() == other.end.getY()
                && this.start.getY() == other.start.getY()) {
            return null;
        }

        //equations of the form x=c (two vertical lines)
        if (this.start.getX() == this.end.getX()
                && other.start.getX() == other.end.getX()) {
            return null;
        }

        //equations of the form y=c (two horizontal lines)
        if (this.start.getY() == this.end.getY()
                && other.start.getY() == other.end.getY()) {
            return null;
        }

        //lineA is vertical x1 = x2
        //slope will be infinity
        //so lets derive another solution
        if (this.start.getX() == this.end.getX()) {
            //compute slope of line 2 (m2) and c2
            double m2 = (other.end.getY() - other.start.getY())
                    / (other.end.getX() - other.start.getX());
            double c2 = -m2 * other.start.getX() + other.start.getY();

            //equation of vertical line is x = c
            //if line 1 and 2 intersect then x1=c1=x
            //subsitute x=x1 in (4) => -m2x1 + y = c2
            // => y = c2 + m2x1
            x = this.start.getX();
            y = c2 + m2 * this.start.getX();
        } else if (other.start.getX() == other.end.getX()) {
            //compute slope of line 1 (m1) and c2
            double m1 = (this.end.getY() - this.start.getY())
                    / (this.end.getX() - this.start.getX());
            double c1 = -m1 * this.start.getX() + this.start.getY();

            //equation of vertical line is x = c
            //if line 1 and 2 intersect then x3=c3=x
            //subsitute x=x3 in (3) => -m1x3 + y = c1
            // => y = c1 + m1x3
            x = other.start.getX();
            y = c1 + m1 * other.start.getX();
        } else {
            //compute slope of line 1 (m1) and c2
            double m1 = (this.end.getY() - this.start.getY())
                    / (this.end.getX() - this.start.getX());
            double c1 = -m1 * this.start.getX() + this.start.getY();

            //compute slope of line 2 (m2) and c2
            double m2 = (other.end.getY() - other.start.getY())
                    / (other.end.getX() - other.start.getX());
            double c2 = -m2 * other.start.getX() + other.start.getY();

            //solving equations (3) & (4) => x = (c1-c2)/(m2-m1)
            //plugging x value in equation (4) => y = c2 + m2 * x
            x = (c1 - c2) / (m2 - m1);
            y = c2 + m2 * x;
        }

        //x,y can intersect outside the line segment since line is infinitely long
        //so finally check if x, y is within both the line segments
        if (((x >= this.start.getX() && x <= this.end.getX())
                || (x >= this.end.getX() && x <= this.start.getX()))
                && ((y >= this.start.getY() && y <= this.end.getY())
                || (y >= this.end.getY() && y <= this.start.getY()))
                && ((x >= other.start.getX() && x <= other.end.getX())
                || (x >= other.end.getX() && x <= other.start.getX()))
                && ((y >= other.start.getY() && y <= other.end.getY())
                || (y >= other.end.getY() && y <= other.start.getY()))) {
            return new Point(x, y);
        } else {
            //return default null (no intersection)
            return null;
        }

    }

    /**
     * creates start and end Points for current and other line, and compares end and start Points using the
     * equals method of Point class. end and start Points will be each be compared to end and start Points of
     * the other line. in case one Point isn't the start or end of the other, Lines are not equal.
     *
     * @param other **another Line, which the current Line will be compared to**
     * @return **boolean - true if equals, false otherwise
     **/
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        return false;
    }

    /**
     * check if the line intersect with the rectangle.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param line the trajectory line of the ball.
     * @return null or intersection point.
     */
    private Point intersectionPoint(Line line) {
        if (isIntersecting(line)) {
            return intersectionWith(line);
        }
        return null;
    }

    /**
     * get one intersection point and compare its distance with other points.
     *
     * @param point the first intersection point.
     * @param p2    intersection point(possibly null).
     * @param p3    intersection point(possibly null).
     * @param p4    intersection point(possibly null).
     * @return true if the point is the closest or false if not.
     */
    private boolean minDistance(Point point, Point p2, Point p3, Point p4) {
        double dist1, dist2, dist3, dist4;
        boolean isMin = true;
        dist1 = start.distance(point);
        if (p2 != null) {
            dist2 = start.distance(p2);
        } else {
            dist2 = dist1;
        }
        if (p3 != null) {
            dist3 = start.distance(p3);
        } else {
            dist3 = dist1;
        }
        if (p4 != null) {
            dist4 = start.distance(p4);
        } else {
            dist4 = dist1;
        }

        if (dist2 < dist1) {
            isMin = false;
        }
        if (dist3 < dist1) {
            isMin = false;
        }
        if (dist4 < dist1) {
            isMin = false;
        }
        return isMin;

    }

    /**
     * finds the closest intersection point to the start of the trajectory line.
     *
     * @param rect the collision rectangle.
     * @return null if there is no intersection or the closest intersection point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double x = rect.getUpperLeft().getX();
        double y = rect.getUpperLeft().getY();
        Point upperLeft = new Point(x, y);
        Point upperRight = new Point(x + rect.getWidth(), y);
        Point lowerLeft = new Point(x, y + rect.getHeight());
        Point lowerRight = new Point(x + rect.getWidth(), y + rect.getHeight());
        Line upperLine = new Line(upperLeft, upperRight);
        Line leftLine = new Line(upperLeft, lowerLeft);
        Line rightLine = new Line(upperRight, lowerRight);
        Line bottomLine = new Line(lowerLeft, lowerRight);
        Point upperPoint = intersectionPoint(upperLine);
        Point lowerPoint = intersectionPoint(bottomLine);
        Point leftPoint = intersectionPoint(leftLine);
        Point rightPoint = intersectionPoint(rightLine);

        if (upperPoint != null) {
            if (minDistance(upperPoint, lowerPoint, leftPoint, rightPoint)) {
                return upperPoint;
            }
        }
        if (lowerPoint != null) {
            if (minDistance(lowerPoint, upperPoint, leftPoint, rightPoint)) {
                return lowerPoint;
            }
        }
        if (leftPoint != null) {
            if (minDistance(leftPoint, upperPoint, lowerPoint, rightPoint)) {
                return leftPoint;
            }
        }
        if (rightPoint != null) {
            if (minDistance(rightPoint, lowerPoint, upperPoint, leftPoint)) {
                return rightPoint;
            }
        }


        return null;
    }
    /**
     public Point closestIntersectionToStartOfLine(Rectangle rect){
     List<Point> listOfPoint = rect.intersectionPoints(this);
     if (!(listOfPoint.isEmpty())){
     int minIndex = 0;
     for (int i = 1; i < listOfPoint.size(); i++){
     if (this.start.distance(listOfPoint.get(minIndex)) > this.start.distance(listOfPoint.get(i))){
     minIndex = i;
     }
     }
     return listOfPoint.get(minIndex);
     }
     return null;

     }
     **/
}