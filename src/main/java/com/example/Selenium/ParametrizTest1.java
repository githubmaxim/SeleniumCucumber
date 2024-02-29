package com.example.Selenium;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametrizTest1 {
    @ParameterizedTest
//    @ValueSource(ints = {1, 2}) //цифры/буквы будут браться прямо отсюда
//    @MethodSource("com.example.Selenium.DataForTest1#dataTest1") ////цифры/буквы будут из метода dataTest1 класса DataForTest1
//    public void test11(int x){ System.out.println("ParametrizTest1 + " + x); }
    @MethodSource("com.example.Selenium.DataForTest1#dataTest2")
    public void test11(int x, int y){ System.out.println("ParametrizTest1 + " + x + "  " + y); }
}
