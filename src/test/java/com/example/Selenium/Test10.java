package com.example.Selenium;

import org.junit.jupiter.api.Test;

import static java.lang.Thread.currentThread;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test10 {
    @Test
    public void test10(){
        System.out.println(currentThread().getName());
        System.out.println("Test10");
        assertThat("f").isEqualTo("f");
    }
}
