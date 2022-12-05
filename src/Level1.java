import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Level 1.
 */
public class Level1 implements LevelInformation {

    /**
     * return number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * return list of velocities.
     *
     * @return list of velocities
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        velocities.add(Velocity.fromAngleAndSpeed(90, 7));
        return velocities;
    }

    /**
     * return paddle speed.
     *
     * @return paddle speed.
     */
    public int paddleSpeed() {
        return 2;
    }

    /**
     * return paddle width.
     *
     * @return paddle width.
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * return the level name.
     *
     * @return th level name.
     */
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * return the background.
     *
     * @return the background.
     */
    public Sprite getBackground() {
        return new Background1();


    }

    /**
     * the block builder.
     *
     * @return list of blocks.
     */
    public List<Block> blocks() {
        int width = 20;
        int height = 20;
        double upperX = 400 + width / 2 - 10;
        double upperY = 200;
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(new Block(new Point(upperX - 10, upperY), width, height, Color.RED, 1));
        return blocks;
    }

    /**
     * call to remove ine block.
     *
     * @return 1.
     */
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
