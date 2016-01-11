package q1;

/**
 * Range defines a range of numbers.
 * 
 * @author Deric
 * @version 1.0
 */
public class Range {

    /** The range of numbers. **/
    private int[] range;

    /** The amount on numbers in the range. **/
    private int size;

    /**
     * Range constructor.
     * 
     * @param r
     *            an array of int's.
     * @param l
     *            the number of int's in the array.
     */
    Range(int[] r, int l) {
        range = r;
        size = l;
    }

    /**
     * Returns the mean of the Range object.
     * 
     * @return the mean.
     */
    public double mean() {
        double sum = 0;
        for (int i : range) {
            sum += i;
        }
        return sum / size;
    }

    /**
     * Returns the standard deviation of the Range object.
     * 
     * @return the standard deviation.
     */
    public double stDiv() {
        double mean = mean();
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Math.pow((range[i] - mean), 2);
        }
        return Math.sqrt(sum / (size - 1));
    }

}
