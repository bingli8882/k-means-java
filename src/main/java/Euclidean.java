/**
 * Euclidean distance function
 */
public class Euclidean implements DistanceFunction {
    public double compute(final double[] a, final double[] b) throws LengthUnmatchedException, NullPointerException {
        if (a==null) throw new NullPointerException("The first observation is null.");
        if (b==null) throw new NullPointerException("The second observation is null.");
        if (a.length != b.length) throw new LengthUnmatchedException("A:" + a.length + " B:" + b.length);
        double t, s = 0;
        for (int i = 0; i < a.length; i++) {
            t = a[i] - b[i];
            s += t * t;
        }
        return Math.sqrt(s);
    }
}
