import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
//    @DisplayName("Add two numbers") // Still doesn't work, even in Maven
    void add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @Test
//    @DisplayName("Multiply two numbers") // Still doesn't work, even in Maven
    void multiply() {
        assertAll(() -> assertEquals(4, Calculator.multiply(2, 2)),
                () -> assertEquals(-4, Calculator.multiply(2, -2)),
                () -> assertEquals(4, Calculator.multiply(-2, -2)),
                () -> assertEquals(0, Calculator.multiply(1, 0)));
    }
}