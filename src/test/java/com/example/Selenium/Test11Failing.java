package com.example.Selenium;

import org.junit.jupiter.api.Test;

import static java.lang.Thread.currentThread;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test11Failing {
    @Test
    public void test11(){
        System.out.println(currentThread().getName());
        System.out.println("Test11Failing");
            assertThat("v").isEqualTo("v");
    }
}
