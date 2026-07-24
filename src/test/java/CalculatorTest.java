import Week1.Friday.CalculatorTesting.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        assertEquals(5, calculator.add(2,3));
        assertEquals(-1, calculator.add(2,-3));
        assertEquals(0, calculator.add(0,0));
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 0));
    }

    @Test
    public void testSubtract(){
        assertEquals(-1, calculator.subtract(2,3));
        assertEquals(5, calculator.subtract(2,-3));
        assertEquals(Integer.MIN_VALUE, calculator.subtract(Integer.MIN_VALUE, 0));
    }

    @Test
    public void testMultiply(){
        assertEquals(6, calculator.multiply(2,3));
        assertEquals(0, calculator.multiply(0,5));
        assertEquals(4, calculator.multiply(-2,-2));
        assertEquals(Integer.MAX_VALUE, calculator.multiply(Integer.MAX_VALUE, 1));
    }

    @Test
    public void testDivide(){
        assertEquals(3, calculator.divide(9,3));
        assertEquals(3, calculator.divide(7,2)); // integer division truncates
        assertEquals(-3, calculator.divide(-7,2));
    }

    @Test
    public void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> calculator.divide(1,0));
    }

    @Test
    public void testSqrt(){
        assertEquals(2.0, calculator.sqrt(4), 1e-9);
        assertEquals(0.0, calculator.sqrt(0), 1e-9);
        assertEquals(Math.sqrt(2), calculator.sqrt(2), 1e-9);
    }

    @Test
    public void testSqrtNegative(){
        assertThrows(ArithmeticException.class, () -> calculator.sqrt(-1));
    }
}
