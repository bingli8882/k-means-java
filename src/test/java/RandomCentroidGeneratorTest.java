import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by bing on 4/25/17.
 */
public class RandomCentroidGeneratorTest {

    double[][] a = {{0,1,2},{1,2,3},{2,3,4},{3,4,5},{4,5,6}};
    CentroidGenerator cg = new RandomCentroidGenerator();

    @Test(expected = NullPointerException.class)
    public void testNullPointer() throws EmptyDataSetException, NullPointerException{
        cg.generate(0,null);
    }

    @Test(expected = EmptyDataSetException.class)
    public void testEmptyInput() throws EmptyDataSetException{
        cg.generate(10,new double[3][4]);
    }
    @Test(expected = EmptyDataSetException.class)
    public void smallSizeData() throws EmptyDataSetException{
        cg.generate(10,a);
    }
    @Test
    public void test() throws EmptyDataSetException{
        double[][] r = cg.generate(2,a);
        assertEquals(2,r.length);
        assertEquals(3,r[0].length);

        List<Integer> list = new ArrayList<Integer>();

        for (double[] e:r) {
            assertEquals(false,list.contains((int)e[0]));
            list.add((int)e[0]);
            assertEquals(true,contains(a,e));
        }

    }
    private boolean contains(double[][] a,double[] b){
        for (int i = 0; i < a[(int)b[0]].length; i++) {
            if(a[(int)b[0]][i]!=b[i]) return false;
        }
        return true;
    }

}
