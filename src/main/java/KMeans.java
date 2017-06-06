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
     * @param k the k value
     * @param data the input data set
     * @param df the distance function
     * @param cg the centroid generator function
     * @param mf the mean function
     */
    public KMeans(int k,double[][] data,DistanceFunction df,CentroidGenerator cg,MeanFunction mf){
        this.k = k;
        this.data = data;
        this.df = df;
        this.mf = mf;
        this.cg = cg;
        try {
            centroids = cg.generate(k,data);
        } catch (EmptyDataSetException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * The constructor of KMeans class with standard mean function
     * @param k the k value
     * @param data the input data set
     * @param df the distance function
     * @param cg the centroid generator function
     */
    public KMeans(int k,double[][] data, DistanceFunction df, CentroidGenerator cg){
        this(k,data,df,cg,new StandardMeanFunction());
    }

    /**
     * The short constructor of KMeans class with standard mean function, Euclidean distance function, and random centroid generator.
     * @param k the k value
     * @param data the input data set
     */
    public KMeans(int k, double[][] data){
        this(k,data,new Euclidean(), new RandomCentroidGenerator());
    }

}
