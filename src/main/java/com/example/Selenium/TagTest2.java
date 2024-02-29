package com.example.Selenium;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagTest2 {
    @Test
    public void test21(){
        System.out.println("TagTest2");
    }

    @Tag("a")
    @Test
    public void test22(){
        System.out.println("Test72");
    }
}
