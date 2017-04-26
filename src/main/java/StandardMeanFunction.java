import java.util.Arrays;

/**
 * This is the standard mean function
 */
public class StandardMeanFunction implements MeanFunction {
    public double[] compute(final double[][] data) throws EmptyDataSetException, NullPointerException {
        if (data == null) throw new NullPointerException("Input data is null");
        if (data.length == 0 || data[0].length == 0) throw new EmptyDataSetException("Input data set is empty");
        double[] result = new double[data[0].length];
        int size = data.length;
        Arrays.fill(result, 0.0);

        for (double[] e : data) {
            for (int i = 0; i < e.length; i++) {
                result[i] += e[i];
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] /= size;
        }
        return result;
    }
}
