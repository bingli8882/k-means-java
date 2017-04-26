/**
 * This is the interface of all Mean calculation functions.
 */
public interface MeanFunction {
    /**
     * Calculate the mean of the given observations set
     *
     * @param data the data set
     * @return a double array representing the mean of the given data set.
     */
    double[] compute(final double[][] data) throws EmptyDataSetException, NullPointerException;
}
