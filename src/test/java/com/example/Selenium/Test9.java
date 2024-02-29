package com.example.Selenium;

import org.junit.jupiter.api.Test;

import static java.lang.Thread.currentThread;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test9 {
    @Test
    public void test9(){
        System.out.println(currentThread().getName());
        System.out.println("Test9");
        assertThat("a").isEqualTo("a");
    }
}
