import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRangeClass {

    @Test
    public void testCreateRangeClass(){
        Range girlAgeThatHuyPhamLike = Range.of(35, 45);
        assertEquals(girlAgeThatHuyPhamLike.getClass().toString(),  "class Range");
    }

    @Test
        public void testCreateMultipleRangeInstance(){
        Range rangeA = Range.of(1, 2);
        Range rangeB = Range.of(2, 3);
        Range rangeOpenA = Range.open(2, 10);
        Range rangeOpenB = Range.open(3, 10);
        assertFalse(rangeA.contains(2));
        assertFalse(rangeB.contains(3));

    }

    @Test
    public void testCreateRangeClassWithLowerboundIsLargerThanUpperbound(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Range girlAgeThatHuyPhamLike = Range.of(45, 44);
        });

        String expectedMessage = "Lowerbound should be less than upperbound";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testNumberContainsInRange(){
        Range sampleRange = Range.of(35, 44);
        assertTrue(sampleRange.contains(35));
        assertFalse(sampleRange.contains(45));
    }

    @Test
    public void testOpen(){
        Range openRange = Range.open(10, 100);
        assertFalse(openRange.contains(100));
        assertFalse(openRange.contains(10));
    }

    @Test
    public void testClosedRange(){
        Range closedRange = Range.closed(10, 100);
        assertTrue(closedRange.contains(10));
        assertTrue(closedRange.contains(100));

    }

    @Test
    public void testClosedOpenRange(){
        Range closedOpenRange = Range.closedOpen(10, 100);
        assertTrue(closedOpenRange.contains(10));
        assertFalse(closedOpenRange.contains(100));

    }

    @Test
    public void testOpenClosedRange(){
        Range openClosedRange = Range.openClosed(10, 100);
        assertFalse(openClosedRange.contains(10));
        assertTrue(openClosedRange.contains(100));
    }
}