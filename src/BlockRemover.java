/**
 * The type Block remover.
 */
// a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel       the game level
     * @param remainingBlocks the remaining blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Blocks that are hit and reach 0 hit-points should is removed
     * from the gameLevel.
     * that is being removed from the gameLevel.
     *
     * @param beingHit block being hit.
     * @param hitter   the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getLife() == 0) {
            beingHit.removeFromGame(this.gameLevel);
            beingHit.removeHitListener(this);
            this.remainingBlocks.decrease(1);
        }
    }

    /**
     * returns the number of remaining blocks in the gameLevel.
     *
     * @return the number of remaining blocks in the gameLevel
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * sets the the counter of number of remaining blocks in the gameLevel.
     *
     * @param c the new counter for the remaining blocks
     */
    public void setCounter(Counter c) {
        this.remainingBlocks = c;
    }
}