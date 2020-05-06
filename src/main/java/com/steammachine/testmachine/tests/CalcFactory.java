package com.steammachine.testmachine.tests;

import com.steammachine.testmachine.sdk.ContextHook;
import com.steammachine.testmachine.sdk.TestedObjectFactory;

/**
 * {@link com.steammachine.testmachine.tests.CalcFactory}
 */
public class CalcFactory implements ContextHook, Calc {

    private static TestedObjectFactory factory;

    public int sum(int a, int b) {
        return a + b;
    }

    public static Calc instance(Class<Calc> clazz) {
        return factory == null ? new CalcFactory() : factory.get(clazz);
    }

    @Override
    public void install(TestedObjectFactory f) {
        factory = f;
    }
}
