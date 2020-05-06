package com.steammachine.testmachine.tests;

import com.steammachine.testmachine.sdk.TestDescription;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("calc_test")
class InitialTest {

    private final Calc calc = CalcFactory.instance(Calc.class);

    @DisplayName("Elementary checks")
    @TestDescription("Checks if sum of numbers a and b is a + b")
    @Test
    void test() {
        Assertions.assertEquals(3, calc.sum(1, 2));
    }


}
