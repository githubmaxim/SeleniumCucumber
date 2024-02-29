package com.example.Selenium;


import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({ParametrizTest1.class, TagTest2.class})
@SelectPackages({"com.example.Selenium.package1ForTest"})
@ExcludePackages({"com.example.Selenium.package1ForTest.package11ForTest"})
//@IncludeTags("a")
//аннотация @SelectMetod(type= , name="") не работает хз почему

public class RunnerAllTest {}
