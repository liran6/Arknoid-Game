import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * The type GameLevel.
 *
 * @author liran baruch. Implementation of the GameLevel class.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter score;
    private Counter numberOfLives;
    private GUI gui;
    private KeyboardSensor keyboardSensor;
    private Sleeper sleeper;
    private Paddle paddle;
    private LevelInformation level;
    private LifeIndicator lifeIndicator;
    private LevelIndicator levelIndicator;
    private static final int PADDLE_HEIGHT = 20;
    private static final int PADDLE_Y_POINT = 560;
    private static final int GUI_WITH = 800;

    /**
     * the constructor of the game members.
     *
     * @param gui            the gui
     * @param level          the level
     * @param score          the score
     * @param numOfLives     the num of lives
     * @param keyboardSensor the keyboard sensor
     * @param runner         the runner
     */
    public GameLevel(GUI gui, LevelInformation level, int score, int numOfLives, KeyboardSensor keyboardSensor
            , AnimationRunner runner) {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        this.gui = gui;
        this.blocksCounter = new Counter();
        this.ballsCounter = new Counter();
        this.score = new Counter(score);
        this.numberOfLives = new Counter(numOfLives);
        this.runner = runner;
        this.level = level;
        this.keyboardSensor = keyboardSensor;
    }

    /**
     * adds the collidable object to the game environment.
     *
     * @param c the collidable object.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * adds the sprite object to the game environment.
     *
     * @param s the sprite object.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        sleeper = new Sleeper();
        BlockRemover blockRemover = new BlockRemover(this, this.blocksCounter);
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        this.addSprite(this.level.getBackground());
        ScoreIndicator scoreIndicator = new ScoreIndicator(new Rectangle(new Point(0, 0)
                , 800, 20), score);
        lifeIndicator = new LifeIndicator(new Rectangle(new Point(0, 0)
                , 800, 20), numberOfLives);
        levelIndicator = new LevelIndicator(new Rectangle(new Point(0, 0)
                , 800, 20), level);
        levelIndicator.addToGame(this);
        lifeIndicator.addToGame(this);
        scoreIndicator.addToGame(this);
        blockRemover.setCounter(this.blocksCounter);
        //biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        this.paddle = new Paddle(this.keyboardSensor, new Block(new Rectangle(new Point(GUI_WITH / 2
                - (this.level.paddleWidth() / 2), PADDLE_Y_POINT), this.level.paddleWidth(), PADDLE_HEIGHT))
                , this.level.paddleSpeed());
        paddle.addToGame(this);
        Block[] frameBlocks = new Block[3];
        Block frameBlock = new Block(new Rectangle(new Point(0, 20), 800, 20), Color.gray, 0);
        frameBlock.addToGame(this);
        frameBlocks[0] = frameBlock;
        frameBlock = new Block(new Rectangle((new Point(0, 20)), 20, 580), Color.gray, 0);
        frameBlock.addToGame(this);
        frameBlocks[1] = frameBlock;
        frameBlock = new Block(new Rectangle((new Point(780, 20)), 20, 580), Color.gray, 0);
        frameBlock.addToGame(this);
        frameBlocks[2] = frameBlock;

        Block deathRegion = new Block((new Point(20, 599)), 760, 1, Color.white, 0);
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);
        for (Block block : this.level.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            this.blocksCounter.increase(1);
        }

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {

        while (this.numberOfLives.getValue() > 0) {

            this.playOneTurn();

        }
        gui.close();
    }

    /**
     * boolean change.
     * @return true or false.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * do one frame.
     * @param d the drawSurface
     */
    public void doOneFrame(DrawSurface d) {
        if (this.keyboardSensor.isPressed("p") || this.keyboardSensor.isPressed("P")) {
            this.runner.run(new PauseScreen(this.keyboardSensor));
        }
        if (this.ballsCounter.getValue() == 0) {
            this.numberOfLives.decrease(1);
        }
        // (this.blocksCounter.getValue() > 0 && this.ballsCounter.getValue() > 0) {
        if (!(this.blocksCounter.getValue() > 0 && this.ballsCounter.getValue() > 0)) {
            this.running = false;
        }
        if (this.getBlockCount() == this.level.blocks().size() - this.level.numberOfBlocksToRemove()) {
            this.score.increase(100);
            this.running = false;
        }

        //long startTime = System.currentTimeMillis(); // timing
        //DrawSurface d = gui.getDrawSurface();
        this.sprites.drawAllOn(d);
        //gui.show(d);
        this.sprites.notifyAllTimePassed();
/**
 // timing
 long usedTime = System.currentTimeMillis() - startTime;
 long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
 if (milliSecondLeftToSleep > 0) {
 sleeper.sleepFor(milliSecondLeftToSleep);
 }
 **/


        // this.running = false;
    }

    /**
     * Play one turn.
     */
    public void playOneTurn() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.runner.run(new CountdownAnimation(6, 3, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * move the paddle to the start point.
     */
    public void movePaddleToStart() {
        this.paddle.initializePaddleLocation(new Point(GUI_WITH / 2
                - (this.level.paddleWidth() / 2), PADDLE_Y_POINT));
    }

    /**
     * puts the balls above the paddle.
     */
    public void createBallsOnTopOfPaddle() {
        Ball ball;
        this.movePaddleToStart();

        double paddleX = this.paddle.getCollisionRectangle().getUpperLeft().getX();
        double paddleY = this.paddle.getCollisionRectangle().getUpperLeft().getY();
        double paddleWidth = this.paddle.getCollisionRectangle().getWidth();


        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            ball = new Ball(new Point(paddleX + paddleWidth / 2, paddleY - 7 * 5), 5
                    , Color.white, this.environment);
            ball.setVelocity(this.level.initialBallVelocities().get(i));
            this.ballsCounter.increase(1);
            ball.addToGame(this);
        }
        this.ballsCounter.setValue(this.level.numberOfBalls());

    }

    /**
     * returns the counter of the blocks in the game.
     *
     * @return the counter of the blocks in the game.
     */
    public int getBlockCount() {
        return this.blocksCounter.getValue();
    }

    /**
     * returns the counter of number of lives.
     *
     * @return the counter of number of lives.
     */
    public Counter getNumberOfLives() {
        return this.numberOfLives;
    }

    /**
     * returns the counter of score.
     *
     * @return the counter of score
     */
    public Counter getScore() {
        return this.score;
    }
}
