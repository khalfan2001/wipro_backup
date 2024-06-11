package com.day27;
//Task-1-code that should run
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JunitTestMathematicalOperations {

    @Test
    public void testAdd() {
        MathematicalOperations mathOps = new MathematicalOperations();
        assertEquals(5, mathOps.add(2, 3));
        assertEquals(-1, mathOps.add(2, -3));
        assertEquals(0, mathOps.add(-2, 2));
    }

    @Test
    public void testSubtract() {
        MathematicalOperations mathOps = new MathematicalOperations();
        assertEquals(1, mathOps.subtract(3, 2));
        assertEquals(5, mathOps.subtract(2, -3));
        assertEquals(-4, mathOps.subtract(-2, 2));
    }

    @Test
    public void testMultiply() {
        MathematicalOperations mathOps = new MathematicalOperations();
        assertEquals(6, mathOps.multiply(2, 3));
        assertEquals(-6, mathOps.multiply(2, -3));
        assertEquals(4, mathOps.multiply(-2, -2));
    }

    @Test
    public void testDivide() {
        MathematicalOperations mathOps = new MathematicalOperations();
        assertEquals(2, mathOps.divide(6, 3));
        assertEquals(-2, mathOps.divide(6, -3));
        assertEquals(1, mathOps.divide(-3, -3));
    }

    @Test
    public void testDivideByZero() {
        MathematicalOperations mathOps = new MathematicalOperations();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mathOps.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
