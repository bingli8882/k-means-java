import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bing on 6/6/17.
 */
public class DataGeneratorTest {
    @Test
    public void generateCentroidsTest() {
        double[][] c = DataGenerator.generateCentroids(5, 2, 10, 20);

        assertEquals(5, c.length);
        assertEquals(2, c[0].length);

        for (double[] d : c) {
            for (double e : d) {
                assertTrue(e<=20);
                assertTrue(e>=10);
            }
        }
    }

    @Test(expected = EmptyDataSetException.class)
    public void generateDataTest1() throws EmptyDataSetException{
        DataGenerator.generateData(1,null,10);

    }

    @Test
    public void generateDataTest2() throws EmptyDataSetException {
        double[][] data = DataGenerator.generateData(10,DataGenerator.generateCentroids(2),10);

        assertEquals(10,data.length);
        assertEquals(2,data[0].length);

        for (double[] d: data) {
            for (double e:d) {
                assertTrue(e<=100);
                assertTrue(e>=0);
            }
        }
    }
}
