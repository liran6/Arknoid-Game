/**
 * The type Counter.
 */
public class Counter {
    private int counter;

    /**
     * Instantiates a new Counter.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * constructor.
     *
     * @param value the value for the initializing of the counter
     */
    public Counter(int value) {
        this.counter = value;
    }

    /**
     * Increase.
     *
     * @param number the number
     */
// add number to current count.
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * Decrease.
     *
     * @param number the number
     */
// subtract number from current count.
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * Get value int.
     *
     * @return the int
     */
// get current count.
    public int getValue() {
        return this.counter;
    }

    /**
     * sets the value of the counter.
     *
     * @param value the value of the counter to be changed to
     */
    public void setValue(int value) {
        this.counter = value;
    }

}