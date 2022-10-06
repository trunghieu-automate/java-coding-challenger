package hieu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRangeClassHieu {

    @Test
    public void testCreateRangeClass(){
        RangeHieu girlAgeThatHuyPhamLike = RangeHieu.of(35, 45);
        assertEquals(girlAgeThatHuyPhamLike.getClass().toString(),  "class tay.Range");
    }

    @Test
        public void testCreateMultipleRangeInstance(){
        RangeHieu rangeHieuOpenA = RangeHieu.open(2, 10);
        RangeHieu rangeHieuOpenB = RangeHieu.open(3, 10);
        assertFalse(rangeHieuOpenA.contains(2));
        assertFalse(rangeHieuOpenB.contains(3));
    }

    @Test
    public void testCreateRangeClassWithLowerboundIsLargerThanUpperbound(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RangeHieu girlAgeThatHuyPhamLike = RangeHieu.of(45, 44);
        });

        String expectedMessage = "Lowerbound should be less than upperbound";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testNumberContainsInRange(){
        RangeHieu sampleRangeHieu = RangeHieu.of(35, 44);
        assertTrue(sampleRangeHieu.contains(35));
        assertFalse(sampleRangeHieu.contains(45));
    }

    @Test
    public void testOpen(){
        RangeHieu openRangeHieu = RangeHieu.open(10, 100);
        assertFalse(openRangeHieu.contains(100));
        assertFalse(openRangeHieu.contains(10));
    }

    @Test
    public void testClosedRange(){
        RangeHieu closedRangeHieu = RangeHieu.closed(10, 100);
        assertTrue(closedRangeHieu.contains(10));
        assertTrue(closedRangeHieu.contains(100));
    }

    @Test
    public void testClosedOpenRange(){
        RangeHieu closedOpenRangeHieu = RangeHieu.closedOpen(10, 100);
        assertTrue(closedOpenRangeHieu.contains(10));
        assertFalse(closedOpenRangeHieu.contains(100));
    }

    @Test
    public void testOpenClosedRange(){
        RangeHieu openClosedRangeHieu = RangeHieu.openClosed(10, 100);
        assertFalse(openClosedRangeHieu.contains(10));
        assertTrue(openClosedRangeHieu.contains(100));
    }
}