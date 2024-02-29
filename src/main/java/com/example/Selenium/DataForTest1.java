package com.example.Selenium;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataForTest1 {

    //передаем по одному параметру
//    static Stream<Integer> dataTest1() {
//        return Stream.of(3, 4);
//    }

    //предаем по 2 параметра
    static Stream<Arguments> dataTest2() {
        return Stream.of(Arguments.of(5, 6), Arguments.of(7, 8));
    }

}
