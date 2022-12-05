
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private GUI gui;
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private int numOfLives;
    private int score;
    private boolean won;


    /**
     * Instantiates a new Game flow.
     *
     * @param gui        the gui
     * @param ar         the ar
     * @param ks         the ks
     * @param numOfLives the num of lives
     */
    public GameFlow(GUI gui, AnimationRunner ar, KeyboardSensor ks, int numOfLives) {
        this.ar = ar;
        this.ks = ks;
        this.numOfLives = numOfLives;
        this.score = 0;
        this.won = true;

    }

    /**
     * This mathod runs the levels of the game.
     *
     * @param levels the levels to be run
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(gui, levelInfo, this.score, this.numOfLives, this.ks, this.ar);

            level.initialize();


            while (level.getBlockCount() > levelInfo.blocks().size() - levelInfo.numberOfBlocksToRemove()) {
                level.playOneTurn();
                if (level.getNumberOfLives().getValue() == 0) {
                    this.won = false;
                    this.score = level.getScore().getValue();
                    break;
                }
            }

            if (level.getNumberOfLives().getValue() == 0) {
                this.won = false;
                this.score = level.getScore().getValue();
                break;
            }

            this.ar.run(level);
            this.score = level.getScore().getValue();
            this.numOfLives = level.getNumberOfLives().getValue();
        }


        EndScreen endScreen = new EndScreen(this.won, this.score, this.ks);
        this.ar.run(endScreen);

    }
}