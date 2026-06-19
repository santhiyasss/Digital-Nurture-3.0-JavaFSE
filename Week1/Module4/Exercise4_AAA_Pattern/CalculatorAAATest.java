import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calculator;

    // SETUP - runs before every test
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator initialized");
    }

    // TEARDOWN - runs after every test
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator destroyed");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 4, b = 3;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 10, b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(5.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // Arrange
        int a = 10, b = 0;

        // Act - should throw ArithmeticException
        calculator.divide(a, b);

        // Assert - handled by expected = ArithmeticException.class
    }
}