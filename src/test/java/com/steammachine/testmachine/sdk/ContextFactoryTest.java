package com.steammachine.testmachine.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContextFactoryTest {

    @Test
    void testFqcn() {
        assertEquals("com.steammachine.testmachine.sdk.ContextHook",
                ContextHook.class.getName());
    }

}