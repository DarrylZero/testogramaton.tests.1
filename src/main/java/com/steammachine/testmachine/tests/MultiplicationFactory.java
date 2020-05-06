package com.steammachine.testmachine.tests;

import com.steammachine.testmachine.sdk.ContextHook;
import com.steammachine.testmachine.sdk.TestedObjectFactory;


/**
 * {@link MultiplicationFactory}
 */
public class MultiplicationFactory implements ContextHook, Multiply {

    private static TestedObjectFactory factory;

    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }

    public static Multiply instance(Class<Multiply> clazz) {
        return factory == null ? new MultiplicationFactory() : factory.get(clazz);
    }

    @Override
    public void install(TestedObjectFactory f) {
        factory = f;
    }


}
