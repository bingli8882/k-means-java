/**
 * The interface of centroid generator
 */
public interface CentroidGenerator {
    /**
     * Generate k centroids.
     * @param k An int value representing the number of centroids being generated.
     * @param data The data set containing all data points.
     * @return A list of all generated centroids.
     */
    double[][] generate(int k, double[][] data);
}
