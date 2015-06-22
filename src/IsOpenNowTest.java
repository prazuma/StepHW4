import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by hashimotomika on 6/20/15.
 */
public class IsOpenNowTest {

    @Test
    public void testIsOpenNow1() throws Exception {
        assertTrue(IsOpenNow.isOpenNow1(11, 11, 17));
        assertFalse(IsOpenNow.isOpenNow1(17, 11, 17));
        assertTrue(IsOpenNow.isOpenNow1(5, 4, 6));
    }

    @Test
    public void testIsOpenNow2() throws Exception {
        assertTrue(IsOpenNow.isOpenNow2(4, 20, 29));
        assertFalse(IsOpenNow.isOpenNow2(5, 20, 29));
        assertFalse(IsOpenNow.isOpenNow2(5, 4, 6));
    }
}