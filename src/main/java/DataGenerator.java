import java.io.FileWriter;
import java.io.IOException;

/**
 * Generate test data
 * <p>
 * Example output
 * c1_x c1_y
 * c2_x c2_y
 * ...
 * ck_x ck_y
 * <p>
 * d1_x d1_y
 * d2_y d2_y
 * ...
 * dszie_x dsize_y
 */
public class DataGenerator {


    /**
     * Random generate centroids
     *
     * @param n          the number of centroids
     * @param d          the dimensional of centroids
     * @param lowerBound the lower bound of the random range
     * @param upperBound the upper bound of the random range
     * @return a 2d double array represents the list of centroids
     */
    public static double[][] generateCentroids(int n, int d, double lowerBound, double upperBound) {
        double[][] centroids = new double[n][d];
        double range = upperBound - lowerBound;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                centroids[i][j] = lowerBound + range * Math.random();
            }
        }

        return centroids;
    }

    /**
     * Random generate test centroids, 2d, 10~90
     *
     * @param n the amount of centroids
     * @return a 2d double array represents the list of the centroids
     */
    public static double[][] generateCentroids(int n) {
        return generateCentroids(n, 2, 10, 90);
    }

    /**
     * Random generate data
     *
     * @param size      the amount of data
     * @param centroids the seed centroids
     * @param radius    the radius round the seeds
     * @return a 2d double array represents data
     * @throws EmptyDataSetException if input the centroid array is empty.
     */
    public static double[][] generateData(int size, double[][] centroids, double radius) throws EmptyDataSetException {
        if (centroids == null || centroids.length == 0 || centroids[0].length == 0)
            throw new EmptyDataSetException("The input centroids array is empty");
        double[][] data = new double[size][centroids[0].length];

        double r = radius * 2;
        int t = 0; // index of centroid
        for (int i = 0; i < size; i++) {
            t = i % centroids.length;
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = centroids[t][j] - radius + r * Math.random();
            }
        }

        return data;

    }

    /**
     * Random generate test data
     *
     * @param size      the amount of data
     * @param centroids the seed centroids
     * @return a 2d double array represents data
     * @throws EmptyDataSetException if input the centroid array is empty
     */
    public static double[][] generateData(int size, double[][] centroids) throws EmptyDataSetException {
        return generateData(size, centroids, 10);
    }

    /**
     * Output a data set to the specified file
     * @param data the data set
     * @param out the output file
     * @throws IOException if any error caught when write data
     */
    private static void output(double[][] data,FileWriter out) throws IOException {
        if(data.length==0) return;
        for (int i = 0; i < data[0].length; i++) {
            out.write(data[0][i]+" ");
        }
        out.write("\n");

        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                out.write(data[i][j]+" ");
            }
            out.write("\n");
        }

    }

    /**
     * Main method
     *
     * @param args k size out_file_name
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]); // num of centroids
        int size = Integer.parseInt(args[1]); // size of data

        double[][] centroids = generateCentroids(k);
        double[][] data = null;
        try {
            data = generateData(size, centroids);
        } catch (EmptyDataSetException e) {
            e.printStackTrace();
        }

        try {
            FileWriter out = new FileWriter(args[2]);
            output(data,out);
            out.close();

            out = new FileWriter(args[2]+"_centroids");
            output(centroids,out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
