//package cucumber.areal.hooks;
//
//import cucumber.areal.MySingleton1;
//import cucumber.areal.MySingleton2;
//import io.cucumber.java.en.Given;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BeforeStep {
//
//// Если использовать открытие сайта тут, то при многопоточном запуске тестов откроет
//// не 2 виндовс окна (по одному для каждого теста), а 4
//    @Given("Open Website {string}")
//    public void open(String url) {
//        System.setProperty("webdriver.chrome.driver", "D:\\Java\\Selenium\\chromedriver.exe");
//        WebDriver driver1 = new ChromeDriver();
//        WebDriver driver2 = new ChromeDriver();
//
//        driver1.get(url);
//        driver2.get(url);
//
//
//        MySingleton1 instance1 = MySingleton1.getInstance1();
//        instance1.webDriver1 = driver1;
//        MySingleton2 instance2 = MySingleton2.getInstance2();
//        instance2.webDriver2 = driver2;
//    }
//}
