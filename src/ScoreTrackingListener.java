/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * handles the score in case of a hit.
     *
     * @param beingHit the coliddable that is hit.
     * @param hitter   the ball that hits
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getLife() >= 0) {
            currentScore.increase(5);
        }
        if (beingHit.getLife() == 0) {
            currentScore.increase(10);
        }
    }
}
