package cucumber.areal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page1 {
    private By button1minute = By.xpath("//section[@id='secpick2']//b[contains(text(), '1 Min')]");
    private By button2minute = By.xpath("//section[@id='secpick2']//b[contains(text(), '2 Min')]");
    private By buttonGo = By.xpath("//button[@class='progress-button pure-button pure-button-primary']");
    private By textWord = By.xpath("//div[@class='left-words']//div");

    public void choose1minute(WebDriver driver){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(button1minute).click();
    }
    public void choose2minute(WebDriver driver) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(button2minute).click();
    }
    public void pressGo1(WebDriver driver){
        driver.findElement(buttonGo).click();
    }
    public void pressGo2(WebDriver driver) {
        driver.findElement(buttonGo).click();
    }

}
