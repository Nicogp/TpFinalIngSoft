
package djview;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Danilo
 */
public class HeartModelTest 
{
    
    public HeartModelTest() {}

    /**
     * Test of getInstance method, of class HeartModel.
     */
    @Test
    public void testGetInstance() 
    {
        System.out.println("getInstance");
        HeartModel expResult = HeartModel.getInstance();
        HeartModel result = HeartModel.getInstance();
        assertEquals(expResult, result);
    }
}
