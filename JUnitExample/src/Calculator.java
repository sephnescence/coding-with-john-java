// Following a tutorial from https://www.jetbrains.com/help/idea/junit.html#intellij
// This was done by using intelliJ as the build system

import java.util.stream.DoubleStream;

public class Calculator {
    static double add(double... operands) {
        return DoubleStream.of(operands)
                .sum();
    }

    static double multiply(double... operands) {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }
}
