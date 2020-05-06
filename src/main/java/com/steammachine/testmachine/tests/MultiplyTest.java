package com.steammachine.testmachine.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("multiply_test")
class MultiplyTest {

    private final Multiply multiply = MultiplicationFactory.instance(Multiply.class);

    @Test
    void test() {
        Assertions.assertEquals(8, multiply.multiplication(4, 2));
    }


}