import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 5 game.
 *
 * @author liran baruch. Implementation of the Ass5 class.
 */


public class Ass5Game {
    private static final int FRAME_WITH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final int FRAME_PER_SECOND = 60;
    private static final int NUM_OF_LIFE = 7;

    /**
     * This is the main method that runs the game.
     *
     * @param args the commandline input- the levels of the game to be played.
     */
    public static void main(String[] args) {


        GUI gui = new GUI("Arkanoid", FRAME_WITH, FRAME_HEIGHT);
        AnimationRunner ar = new AnimationRunner(gui, FRAME_PER_SECOND);
        GameFlow game = new GameFlow(gui, ar, gui.getKeyboardSensor(), NUM_OF_LIFE);
        List<LevelInformation> levels = new ArrayList<LevelInformation>();


        for (int i = 0; i < args.length; i++) {
            try {
                switch (Integer.parseInt(args[i])) {
                    case 1:
                        levels.add(new Level1());
                        break;
                    case 2:
                        levels.add(new Level2());
                        break;
                    case 3:
                        levels.add(new Level3());
                        break;
                    case 4:
                        levels.add(new Level4());
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        if (levels.isEmpty()) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());

        }

        game.runLevels(levels);
        gui.close();
    }
}
