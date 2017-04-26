import java.util.ArrayList;
import java.util.List;

/**
 * Random generate centroids
 */
public class RandomCentroidGenerator implements CentroidGenerator {
    public double[][] generate(final int k, final double[][] data) throws EmptyDataSetException {
        if (data.length == 0 || data[0].length == 0) throw new EmptyDataSetException("The input data set is empty.");
        if (data.length < k) throw new EmptyDataSetException("The input data set size is less than K.");

        double[][] result = new double[k][data[0].length];

        List<Integer> list = new ArrayList<Integer>();
        int index = 0, t;

        while (index < k) {
            t = (int)Math.floor(Math.random()*data.length);
            if(!list.contains(t)){
                list.add(t);
                for (int i = 0; i < data[t].length; i++) {
                    result[index][i] = data[t][i];
                }
                index++;
            }
        }

        return result;
    }
}
