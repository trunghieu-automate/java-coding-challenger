package testchallenge001;

import challenge001.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class TestRangeClassHieu {
    @BeforeEach
    public void createRangeInstance(){
    }

    @Test
    public void testCreateRangeClass(){
        Range girlAgeThatHuyPhamLike = Range.of(35, 45);
        assertEquals(girlAgeThatHuyPhamLike.getClass().toString(),  "class hieu.RangeHieu");
    }

    @Test
        public void testCreateMultipleRangeInstance(){
        Range rangeOpenA = Range.open(2, 10);
        Range rangeOpenB = Range.open(3, 10);
        assertFalse(rangeOpenA.contains(2));
        assertFalse(rangeOpenB.contains(3));
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
        Range sampleRange = Range.of(35, 45);
        assertTrue(sampleRange.contains(35));
        assertFalse(sampleRange.contains(46));
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

    @Test
    public void test_textInput_thenReturnContainResult(){
        Range textRange = Range.of("a", "b");
    }
    @Test
    public void test_decimalInput_thenReturnContainResult(){
        Range decimalRange = Range.of(BigDecimal.valueOf(1.115), BigDecimal.valueOf(2.3368));

    }
    @Test
    public void test_dayTimeInput_thenReturnContainResult(){
        Range dayTimeRane = Range.of(LocalDate.of(2022, Month.SEPTEMBER,
                01), LocalDate.of(2022, Month.SEPTEMBER, 30));
    }
}