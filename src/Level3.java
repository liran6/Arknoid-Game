import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 */
public class Level3 implements LevelInformation {
    private Background3 background;
    private List<Block> blocks;

    /**
     * constructor.
     */
    public Level3() {

        this.background = new Background3();
        this.blocks = new ArrayList<Block>();

        int blockWidth = 48;
        int blockHeight = 30;
        int x = 300;
        int y = 250;
        int tempX = x;

        Block block;

        for (int i = 0; i < 10; i++) {
            block = new Block(new Point(tempX, y), blockWidth, blockHeight, new Color(163, 97, 194), 1);
            tempX += blockWidth;
            this.blocks.add(block);
        }
        tempX = x + blockWidth;
        y += blockHeight;

        for (int i = 0; i < 9; i++) {
            block = new Block(new Point(tempX, y), blockWidth, blockHeight, new Color(138, 74, 212), 1);
            tempX += blockWidth;
            this.blocks.add(block);
        }
        tempX = x + blockWidth * 2;
        y += blockHeight;

        for (int i = 0; i < 8; i++) {
            block = new Block(new Point(tempX, y), blockWidth, blockHeight, new Color(101, 81, 201), 1);
            tempX += blockWidth;
            this.blocks.add(block);
        }
        tempX = x + blockWidth * 3;
        y += blockHeight;

        for (int i = 0; i < 7; i++) {
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
        return 2;
    }

    /**
     * return list of velocities.
     * @return list of velocities
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();

        velocities.add(Velocity.fromAngleAndSpeed(45, 7));
        velocities.add(Velocity.fromAngleAndSpeed(135, 7));
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
        return 200;
    }

    /**
     * return the level name.
     * @return th level name.
     */
    public String levelName() {
        return "Green 3";
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
