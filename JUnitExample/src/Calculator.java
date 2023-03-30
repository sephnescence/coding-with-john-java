// Following a tutorial from https://www.jetbrains.com/help/idea/junit.html#intellij
// That said, I had trouble getting through the Maven instructions as I didn't have a pom.xml

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
