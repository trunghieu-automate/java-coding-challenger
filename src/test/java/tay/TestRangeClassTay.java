package tay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRangeClassTay {

    @Test
    public void testCreateRangeClass(){
        Range girlAgeThatHuyPhamLike = Range.of(35, 45);
        assertEquals(girlAgeThatHuyPhamLike.getClass().toString(),  "class tay.Range");
    }

    @Test
        public void testCreateMultipleRangeInstance(){
        Range rangeHieuOpenA = Range.open(2, 10);
        Range rangeHieuOpenB = Range.open(3, 10);
        assertFalse(rangeHieuOpenA.contains(2));
        assertFalse(rangeHieuOpenB.contains(3));
    }

    @Test
    public void testCreateRangeClassWithLowerboundIsLargerThanUpperbound(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Range girlAgeThatHuyPhamLike = Range.of(45, 44);
        });

        String expectedMessage = "lowerBound value cannot be greater than upper value";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testNumberContainsInRange(){
        Range sampleRangeHieu = Range.of(35, 44);
        assertTrue(sampleRangeHieu.contains(35));
        assertFalse(sampleRangeHieu.contains(45));
    }

    @Test
    public void testOpen(){
        Range openRangeHieu = Range.open(10, 100);
        assertFalse(openRangeHieu.contains(100));
        assertFalse(openRangeHieu.contains(10));
    }

    @Test
    public void testClosedRange(){
        Range closedRangeHieu = Range.closed(10, 100);
        assertTrue(closedRangeHieu.contains(10));
        assertTrue(closedRangeHieu.contains(100));
    }

    @Test
    public void testClosedOpenRange(){
        Range closedOpenRangeHieu = Range.closedOpen(10, 100);
        assertTrue(closedOpenRangeHieu.contains(10));
        assertFalse(closedOpenRangeHieu.contains(100));
    }

    @Test
    public void testOpenClosedRange(){
        Range openClosedRangeHieu = Range.openClosed(10, 100);
        assertFalse(openClosedRangeHieu.contains(10));
        assertTrue(openClosedRangeHieu.contains(100));
    }
}