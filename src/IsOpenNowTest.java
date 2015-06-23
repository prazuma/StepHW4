import org.junit.Test;
import sun.security.provider.Sun;

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
        Hours[] Sunday = new Hours[1];
        for(int i = 0; i < Sunday.length; i++)
            Sunday[i] = new Hours();
        Sunday[0].startH = 11;
        Sunday[0].finishH = 17;
        Hours[] Monday = new Hours[2];
        for(int i = 0; i < Monday.length; i++)
            Monday[i] = new Hours();
        Monday[0].startH = 11;
        Monday[0].finishH = 15;
        Monday[1].startH = 19;
        Monday[1].finishH = 28;
        Hours[] Tuseday = new Hours[1];
        for(int i = 0; i < Tuseday.length; i++)
            Tuseday[i] = new Hours();
        Tuseday[0].startH = 11;
        Tuseday[0].finishH = 17;
        assertTrue(IsOpenNow.isOpenNow(11, Monday, Sunday));
        assertFalse(IsOpenNow.isOpenNow(9, Monday, Sunday));
        assertFalse(IsOpenNow.isOpenNow(15, Monday, Sunday));
        assertTrue(IsOpenNow.isOpenNow(1, Tuseday, Monday));
    }
}