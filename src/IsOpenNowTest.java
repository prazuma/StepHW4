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

    @Test
    public void testIsOpenNow() throws Exception {
        Hours[] hours1 = new Hours[2];
        for(int i = 0; i < hours1.length; i++)
            hours1[i] = new Hours();
        hours1[0].startH = 11;
        hours1[0].finishH = 15;
        hours1[1].startH = 19;
        hours1[1].finishH = 28;
        Hours[] hours2 = new Hours[1];
        for(int i = 0; i < hours2.length; i++)
            hours2[i] = new Hours();
        hours2[0].startH = 11;
        hours2[0].finishH = 17;
        assertTrue(IsOpenNow.isOpenNow(11, hours1, hours2));
        assertFalse(IsOpenNow.isOpenNow(9, hours1, hours2));
        assertTrue(IsOpenNow.isOpenNow(1, hours2, hours1));
    }
}