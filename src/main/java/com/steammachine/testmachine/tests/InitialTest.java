package com.steammachine.testmachine.tests;

import com.steammachine.testmachine.sdk.TestDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@Tag("calc_test")
class InitialTest {

    private final Calc calc = CalcFactory.instance(Calc.class);

    @DisplayName("Elementary checks 1 + 2 = 3")
    @TestDescription("Checks if sum of numbers a and b is a + b")
    @Test
    void test() {
        assertEquals(3, calc.sum(1, 2), "");
    }

    @DisplayName("Elementary checks 2")
    @TestDescription("Checks if sum of numbers a and b is a + b")
    @TestFactory
    Stream<DynamicTest> test2() {
        return IntStream.range(0, 100).boxed()
                        .flatMap(x -> IntStream.range(0, 100).boxed().map(y -> new int[]{x, y}))
                        .map(i -> dynamicTest("test " + i[0] + " + " + i[1] + " = " + (i[0] + i[1]),
                                              () -> assertEquals(i[0] + i[1], calc.sum(i[0], i[1]))));
    }
}
