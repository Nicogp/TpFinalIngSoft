
package djview;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Danilo
 */
public class ElectroTrainingModelTest 
{
    
    public ElectroTrainingModelTest() {}
    
    /**
     * Test of getInstance method, of class ElectroTrainingModel.
     */
    @Test
    public void testGetInstance() 
    {
        System.out.println("getInstance");
        ElectroTrainingModel expResult = ElectroTrainingModel.getInstance();
        ElectroTrainingModel result = ElectroTrainingModel.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNivel method, of class ElectroTrainingModel.
     */
    @Test
    public void testGetNivel() 
    {
        System.out.println("getNivel");
        ElectroTrainingModel instance = ElectroTrainingModel.getInstance();
        int expResult = 1;
        int result = instance.getNivel();
        assertEquals(expResult, result);
    }
}
