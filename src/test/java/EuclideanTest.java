import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by bing on 4/20/17.
 */
public class EuclideanTest {
    @Test(expected = NullPointerException.class)
    public void nullPointerTest1() throws NullPointerException,LengthUnmatchedException{
        DistanceFunction d = new Euclidean();
        d.compute(null,new double[10]);
    }
    @Test(expected = NullPointerException.class)
    public void nullPointerTest2() throws LengthUnmatchedException,NullPointerException{
        DistanceFunction d = new Euclidean();
        d.compute(new double[4],null);
    }
    @Test
    public void evaluatesExpression() throws LengthUnmatchedException {
        DistanceFunction d = new Euclidean();
        double[] a = {0,3.0};
        double[] b = {4.0,0};
        assertEquals(5.0,d.compute(a,b),0.0001);
    }
    @Test(expected = LengthUnmatchedException.class)
    public void testUnmatchedInputs()throws LengthUnmatchedException{
        double[] a = {1,2,3,4,5};
        double[] b = {1,2,3};
        new Euclidean().compute(a,b);
    }
}
