/**
 * The interface of all distance function
 */
public interface DistanceFunction {
    /**
     * Compute the distance between two given points.
     * @param a A double array representing one point's coordinate.
     * @param b A double array representing the other point's coordinate.
     * @return A double value representing the distance between two given points.
     */
    double compute(final double[] a, final double[] b) throws LengthUnmatchedException,NullPointerException;
}
