import java.util.ArrayList;
import java.util.List;

/**
 * @author liran baruch.
 * Implementation of the GameEnviroment class.
 */
public class GameEnvironment {
    private List<Collidable> list;

    /**
     * constructor for the collidable list.
     */
    public GameEnvironment() {
        this.list = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c collidable object.
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    /**
     * remove the given collidable from the environment.
     *
     * @param c collidable object.
     */
    public void removeCollidable(Collidable c) {
        this.list.remove(c);
    }

    /**
     * calculate the closest collision point with the trajectory line.
     *
     * @param trajectory the trajectory line.
     * @return collision info object or null if there is no collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> intersectionpoints = new ArrayList<Point>();
        List<Collidable> objects = new ArrayList<Collidable>();
        for (int i = 0; i < list.size(); i++) {
            Rectangle rec = list.get(i).getCollisionRectangle();
            if (trajectory.closestIntersectionToStartOfLine(rec) != null) {
                Point p1 = trajectory.closestIntersectionToStartOfLine(rec);
                Collidable object1 = list.get(i);
                intersectionpoints.add(p1);
                objects.add(object1);
            }
        }
        if (intersectionpoints.isEmpty()) {
            return null;
        }
        Point minDistance = (intersectionpoints.get(0));
        Collidable object = objects.get(0);
        for (int j = 1; j < intersectionpoints.size(); j++) {
            if (trajectory.start().distance(intersectionpoints.get(j)) < trajectory.start().distance(minDistance)) {
                minDistance = intersectionpoints.get(j);
                object = objects.get(j);
            }
        }
        CollisionInfo collisionInfo = new CollisionInfo(minDistance, object);
        return collisionInfo;
    }

}