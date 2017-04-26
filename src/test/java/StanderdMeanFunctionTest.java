import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bing on 4/25/17.
 */
public class StanderdMeanFunctionTest {
    MeanFunction m = new StandardMeanFunction();

    @Test(expected = EmptyDataSetException.class)
    public void EmptyInputTest() throws EmptyDataSetException {
        m.compute(new double[0][0]);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerTest() throws EmptyDataSetException, NullPointerException{
        m.compute(null);
    }

    @Test
    public void evaluateFunction() throws EmptyDataSetException {
        double[][] data = {{1, 3, 3}, {2, 3, 5}, {3, 4, 6}};
        double[] r = m.compute(data);
        assertEquals(2.0, r[0], 0.000001);
        assertEquals(3.3333,r[1],0.0001);
        assertEquals(4.6666,r[2],0.0001);
    }
}
