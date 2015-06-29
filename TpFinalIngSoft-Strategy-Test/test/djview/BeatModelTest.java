
package djview;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Danilo
 */
public class BeatModelTest 
{
    
    public BeatModelTest() {}

    /**
     * Test of getBPM method, of class BeatModel.
     */
    @Test
    public void testGetBPM() 
    {
        System.out.println("getBPM");
        BeatModel instance = new BeatModel();
        int expResult = 90;
        int result = instance.getBPM();
        assertEquals(expResult, result);
    }

}
