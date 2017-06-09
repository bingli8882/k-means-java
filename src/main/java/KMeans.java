
/**
 * Created by bing on 4/20/17.
 */
public class KMeans {

    private DistanceFunction df;
    private MeanFunction mf;
    private CentroidGenerator cg;
    private double[][] data;
    private double[][] centroids;
    private int k;

    /**
     * The constructor of KMeans class
     *
     * @param k    the k value
     * @param data the input data set
     * @param df   the distance function
     * @param cg   the centroid generator function
     * @param mf   the mean function
     */
    public KMeans(int k, double[][] data, DistanceFunction df, CentroidGenerator cg, MeanFunction mf) {
        this.k = k;
        this.data = data;
        this.df = df;
        this.mf = mf;
        this.cg = cg;
        try {
            this.generateCentroids();
        } catch (EmptyDataSetException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * The constructor of KMeans class with standard mean function
     *
     * @param k    the k value
     * @param data the input data set
     * @param df   the distance function
     * @param cg   the centroid generator function
     */
    public KMeans(int k, double[][] data, DistanceFunction df, CentroidGenerator cg) {
        this(k, data, df, cg, new StandardMeanFunction());
    }

    /**
     * The short constructor of KMeans class with standard mean function, Euclidean distance function, and random centroid generator.
     *
     * @param k    the k value
     * @param data the input data set
     */
    public KMeans(int k, double[][] data) {
        this(k, data, new Euclidean(), new RandomCentroidGenerator());
    }

    /**
     * Change distance function
     *
     * @param df the distance function
     */
    public void setDistanceFunction(DistanceFunction df) {
        this.df = df;
    }

    /**
     * Change mean function
     *
     * @param mf the mean function
     */
    public void setMeanFunction(MeanFunction mf) {
        this.mf = mf;
    }

    /**
     * Change centroid generator function
     *
     * @param cg the centroid generator function
     */
    public void setCentroidGenerator(CentroidGenerator cg) {
        this.cg = cg;
    }

    /**
     * Generate new centroids
     *
     * @throws EmptyDataSetException if the input data set is empty
     */
    public void generateCentroids() throws EmptyDataSetException {
        this.centroids = cg.generate(this.k, this.data);
    }

    /**
     * Get centroids
     *
     * @return a 2d double array represents the centroids
     */
    public double[][] getCentroids() {
        return centroids;
    }

    /**
     * Training function
     */
    public void train(int it) throws LengthUnmatchedException {
        int time = 0;
        while (time < it) {
            int[] counter = new int[centroids.length];
            double[][] total = new double[centroids.length][centroids[0].length];

            int t;
            for (int i = 0; i < data.length; i++) {
                t = findCentroid(data[i]);
                counter[t]++;
                for (int j = 0; j < data[i].length; j++) {
                    total[t][j] += data[i][j];
                }
            }

            for (int i = 0; i < centroids.length; i++) {
                for (int j = 0; j < centroids[0].length; j++) {
                    centroids[i][j] = total[i][j] / counter[i];
                }
            }
            time++;
        }

    }

    /**
     * find the nearest centroid of the specified point
     *
     * @param d a data point
     * @return the index of target centroid
     * @throws LengthUnmatchedException
     */
    private int findCentroid(double[] d) throws LengthUnmatchedException {
        int index = 0;
        double dis = Double.MAX_VALUE;

        double t;
        for (int i = 0; i < centroids.length; i++) {
            t = df.compute(d, centroids[i]);
            if (t < dis) {
                index = i;
                dis = t;
            }

        }

        return index;
    }

    public static void main(String[] args) throws Exception {

        double[][] centroids = DataGenerator.generateCentroids(3,2000,1,9);
        double[][] data = DataGenerator.generateData(Integer.parseInt(args[0]),centroids);

        KMeans km = new KMeans(3,data);
        long tb = System.currentTimeMillis();
        km.train(1);
        long ta = System.currentTimeMillis();

        System.out.println((ta-tb)/1000.0);
//        System.out.println("c1");
//        System.out.println(DataGenerator.output(centroids));
//        System.out.println("c2");
//        System.out.println(DataGenerator.output(km.getCentroids()));
    }


}
