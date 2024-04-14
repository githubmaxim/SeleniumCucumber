package cucumber.areal.steps;

import cucumber.areal.MySingleton1;
import cucumber.areal.MySingleton2;
import cucumber.areal.pages.Page1;
import cucumber.areal.pages.Page2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

//Видео https://www.youtube.com/watch?v=V0msKgJEi3o

public class ArealStep {
    Page1 page1 = new Page1();
    Page2 page2 = new Page2();

   // Поскольку мы в разных классах должны использовать один и тот же "driver"(чтобы не открывало
   // новых Виндовс окон и не пыталось, что то делать уже в них, а не в одном и том же окне), поэтому
   // используем механизм передачи переменной объета в методы через синглтон без создавания новых объектов.
    MySingleton1 instance1 = MySingleton1.getInstance1();
    MySingleton2 instance2 = MySingleton2.getInstance2();

    String fileWithPath = "D:\\Java\\Project IDEA\\Selenium\\src\\test\\java\\cucumber\\areal\\screen\\scr";

// SCENARIO 1
    @Given("open Webdriver1 for site {string}")
    public void openWebdriver1ForSite(String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        instance1.wait1 = new WebDriverWait(driver1, Duration.ofSeconds(10));
        driver1.get(url);
        instance1.webDriver1 = driver1;
    }

    @When("choose test - one minute")
    public void chooseTestOneMinute() {
        page1.choose1minute(instance1.webDriver1);
    }

    @And("start the test")
    public void startTheTest() {
        page1.pressGo1(instance1.webDriver1);
    }

    @And("enter symbols of the line during {int} minute")
    public void enterSymbolsOfTheLineDuringMinute(int time) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime future = LocalTime.now().plusMinutes(time);
        while (LocalTime.now().isBefore(future)) {
            page2.enterFirstLetter(instance1.webDriver1);
        }
        //делаем паузу, чтобы сайт успел подсчитать результаты. И скрин экрана был получен с ними
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("screenshot of result  for {int} minute")
    public void screenshotOfResultFor1Minute(int time) {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot) instance1.webDriver1);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath + time + "min" + LocalTime.now().getSecond() + ".png");
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("check that the quantity of symbols more than {int}")
    public void checkThatTheQuantityOfSymbolsMoreThan(int symbols) {
//        try {
            int result = page2.checkResult(instance1.webDriver1);
            System.out.println("Quantity of symbols in minute " + result);
            Assertions.assertTrue(result>symbols, "Quantity of symbols in minute " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
        //закрытие драйвера можно сделать тут или в отдельном классе с аннотацией @After (у меня класс "AfterStep.java")
//        } finally {
//        //чтобы не вылетала ошибка "org.openqa.selenium.remote.http.WebSocket$Listener
//         //onError WARNING: Connection reset" нужно закрывать не .close(), а .quit()
//            instance1.webDriver1.quit();
//        }
    }
// Отдельный, закрывающий драйвер, метод не использовать, т.к. в случае падения проверки в предыдущем методе, код
// этого метода выполнен не будет. И если необходимо закрыть драйвер именно в этом классе, то в предыдущем
// методе нужно добавить блок try/catch/finally и в finally сделать закрытие драйвера.
//    @And("close Webdriver1")
//    public void closeWebdriver1() {
//        //чтобы не вылетала ошибка "org.openqa.selenium.remote.http.WebSocket$Listener
//        // onError WARNING: Connection reset" нужно закрывать не .close(), а .quit()
//        instance1.webDriver1.quit();
//    }



// SCENARIO 2
    @Given("open Webdriver2 for site {string}")
    public void openWebdriver2ForSite(String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        instance2.wait2 = new WebDriverWait(driver2, Duration.ofSeconds(100));
        driver2.get(url);
        instance2.webDriver2 = driver2;
    }

    @When("start the test №2")
    public void startTheTest2() {page1.pressGo2(instance2.webDriver2);}

    @And("enter symbols of the line during {int} minute  №2")
    public void enterSymbolsOfTheLineDuring2Minute(int time) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime future = LocalTime.now().plusMinutes(time);
        while (LocalTime.now().isBefore(future)) {
            page2.enterFirstLetter(instance2.webDriver2);
        }
        //делаем паузу, чтобы сайт успел подсчитать результаты. И скрин экрана был получен с ними
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("screenshot of result for {int} minute")
    public void screenshotOfResultFor2Minute(int time) {
        TakesScreenshot scrShot =((TakesScreenshot) instance2.webDriver2);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath + time + "min" + LocalTime.now().getSecond() + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("check that the quantity of symbols more than {int}  №2")
    public void checkThatTheQuantityOfSymbolsMoreThan2(int symbols) {
//        try {
            int result = page2.checkResult(instance2.webDriver2);
            System.out.println("Quantity of symbols in minute " + result);
            Assertions.assertTrue(result>symbols, "Quantity of symbols in minute " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //чтобы не вылетала ошибка "org.openqa.selenium.remote.http.WebSocket$Listener
//            // onError WARNING: Connection reset" нужно закрывать не .close(), а .quit()
//            instance2.webDriver2.quit();
//        }
    }

// Отдельный, закрывающий драйвер, метод не использовать, т.к. в случае падения проверки в предыдущем методе, код
// этого метода выполнен не будет. И если необходимо закрыть драйвер именно в этом классе, то в предыдущем
// методе нужно добавить блок try/catch/finally и в finally сделать закрытие драйвера.
//    @And("close Webdriver2")
//    public void closeWebdriver2() {
        //чтобы не вылетала ошибка "org.openqa.selenium.remote.http.WebSocket$Listener
        // onError WARNING: Connection reset" нужно закрывать не .close(), а .quit()
//        instance2.webDriver2.quit();
//    }
}
