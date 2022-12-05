import java.util.List;


/**
 * The interface Level information.
 */
public interface LevelInformation {

    /**
     * returns the number of balls in the level.
     *
     * @return the number of balls in the level.
     */
    int numberOfBalls();


    /**
     * // The initial velocity of each ball.
     * //
     *
     * @return a list of velocities of the balls
     */
    List<Velocity> initialBallVelocities();

    /**
     * returns the speed of the paddle.
     *
     * @return the speed of the paddle.
     */
    int paddleSpeed();


    /**
     * returns the Width( of the paddle.
     *
     * @return the Width( of the paddle.
     */
    int paddleWidth();

    /**
     * returns the name of the level.
     *
     * @return the name of the level
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a background -a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * // The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return the list of the blocks in the level
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}