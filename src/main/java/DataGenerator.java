import java.io.FileWriter;

/**
 * Generate test data
 *
 * Example output
 * c1_x c1_y
 * c2_x c2_y
 * ...
 * ck_x ck_y
 *
 * d1_x d1_y
 * d2_y d2_y
 * ...
 * dszie_x dsize_y
 */
public class DataGenerator {
    /**
     * Main method
     * @param args k size out_file_name
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]); // num of centroids
        int size = Integer.parseInt(args[1]); // size of data

        double[][] data = new double[size][2];

        try {
            FileWriter out = new FileWriter(args[2]); // output file name
            double[][] centroids = new double[k][2];
            for (int i = 0; i < k; i++) {
                centroids[i][0] = Math.random() * 80 + 10;        //range 10 ~ 90
                centroids[i][1] = Math.random() * 80 + 10;

                out.write(centroids[i][0] + " " + centroids[i][1] + "\n");
            }

            out.write("\n");

            for (int i = 0; i < size; i++) {
                int t = (int) (Math.random() * k);
                data[i][0] = centroids[t][0] - 10 + Math.random() * 20;  //range centroid +- 10
                data[i][1] = centroids[t][1] - 10 + Math.random() * 20;

                out.write(data[i][0] + " " + data[i][1] + "\n");
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
