/**
 * The interface of observation generator
 */
public interface ObservationGenerator {
    /**
     * Generate k observations.
     * @param k An int value representing the number of observations being generated.
     * @param data The data set containing all data points.
     * @return A list of all generated observations.
     */
    double[][] generate(int k, double[][] data);
}
