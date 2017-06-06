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
}
