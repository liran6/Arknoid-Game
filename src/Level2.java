import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 2.
 */
public class Level2 implements LevelInformation {
    private Background2 background;
    private List<Block> blocks;

    /**
     * construtor.
     */
    public Level2() {

        this.background = new Background2();
        this.blocks = new ArrayList<Block>();

        int blockWidth = 76;
        int blockHeight = 30;
        int x = 20;
        int y = 300;

        Block block;
        for (int i = 0; i < 2; i++) {
            block = new Block(new Point(x, y), blockWidth, blockHeight, Color.red, 1);
            this.blocks().add(block);
            x += blockWidth;

        }

        for (int i = 0; i < 2; i++) {
            block = new Block(new Point(x, y), blockWidth, blockHeight, Color.orange, 1);
            this.blocks().add(block);
            x += blockWidth;
        }

        for (int i = 0; i < 2; i++) {
            block = new Block(new Point(x, y), blockWidth, blockHeight, Color.yellow, 1);
            this.blocks().add(block);
            x += blockWidth;
        }
        for (int i = 0; i < 2; i++) {
            block = new Block(new Point(x, y), blockWidth, blockHeight, Color.green, 1);
            this.blocks().add(block);
            x += blockWidth;
        }
        for (int i = 0; i < 2; i++) {
            block = new Block(new Point(x, y), blockWidth, blockHeight, new Color(65, 147, 191), 1);
            this.blocks().add(block);
            x += blockWidth;
        }
    }

    /**
     * return number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * return list of velocities.
     *
     * @return list of velocities
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 20; i <= 170; i += 15) {
            velocities.add(Velocity.fromAngleAndSpeed(i, 6));
        }

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
        return 600;
    }

    /**
     * return the level name.
     *
     * @return th level name.
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * return the background.
     *
     * @return the background.
     */
    public Sprite getBackground() {
        return this.background;


    }

    /**
     * the block builder.
     *
     * @return list of blocks.
     */
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * call to remove ine block.
     *
     * @return 1.
     */
    public int numberOfBlocksToRemove() {
        return 10;
    }
}
