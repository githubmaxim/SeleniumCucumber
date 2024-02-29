package com.example.Selenium.package1ForTest;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

//Повторение flaky тестов:
//1. Использовать аннотацию @RepeatTest() над каждым методом, где необходимо. Минус - если методов сотни(задолбаешься
// прописывать). + Повторяет любой тест упавший и не упавший.
//2. В файле pom.xml в плагине maven-surefire-plugin в блоке configuration написать <rerunFailingTestsCount>2</rerunFailingTestsCount>
// (повторит 3 раза только упавшие тесты)
public class RepeatTest3 {
    @RepeatedTest(3)
    public void test2(){
        System.out.println("RepeatTest3");
    }
}
