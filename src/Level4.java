import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 4.
 */
public class Level4 implements LevelInformation {
    private Background4 background;
    private List<Block> blocks;

    /**
     * constructor.
     */
    public Level4() {

        this.background = new Background4();
        this.blocks = new ArrayList<Block>();

        int blockWidth = 76;
        int blockHeight = 25;
        int x = 20;
        int y = 200;
        int tempX = x;

        Block block;

        for (int i = 0; i < 10; i++) {
            block = new Block(new Point(tempX, y), blockWidth, blockHeight, Color.red, 2);
            tempX += blockWidth;
            this.blocks.add(block);
        }
        tempX = x;
        y += blockHeight;

        for (int i = 0; i < 10; i++) {
            block = new Block(new Point(tempX, y), blockWidth, blockHeight, Color.orange, 1);
            tempX += blockWidth;
            this.blocks.add(block);
        }
        tempX = x;
        y += blockHeight;

        for (int i = 0; i < 10; i++) {
            block = new Block(new Point(tempX, y), blockWidth, blockHeight, Color.yellow, 1);
            tempX += blockWidth;
            this.blocks.add(block);
        }
        tempX = x;
        y += blockHeight;

        for (int i = 0; i < 10; i++) {
            block = new Block(new Point(tempX, y), blockWidth, blockHeight, new Color(81, 115, 201), 1);
            tempX += blockWidth;
            this.blocks.add(block);
        }


    }

    /**
     * return number of balls.
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * return list of velocities.
     * @return list of velocities
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();

        velocities.add(Velocity.fromAngleAndSpeed(65, 7));
        velocities.add(Velocity.fromAngleAndSpeed(90, 7));
        velocities.add(Velocity.fromAngleAndSpeed(115, 7));

        return velocities;
    }

    /**
     * return paddle speed.
     * @return paddle speed.
     */
    public int paddleSpeed() {
        return 7;
    }

    /**
     * return paddle width.
     * @return paddle width.
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * return the level name.
     * @return th level name.
     */
    public String levelName() {
        return "Final Four";
    }

    /**
     * return the background.
     * @return the background.
     */
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * the block builder.
     * @return list of blocks.
     */
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * call to remove ine block.
     * @return 1.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}
