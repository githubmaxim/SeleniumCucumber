package cucumber.areal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page2 {
    private By fieldWithText = By.xpath("//div[@class='left-words']//div");
    private By input = By.xpath("//div[@id='inputEditable']");
    private By result = By.xpath("//div[@id='charsPerMin']");

    public void enterFirstLetter(WebDriver driver){
        WebElement element1 = driver.findElement(fieldWithText);
        String allText = element1.getText();

        WebElement element2 = driver.findElement(input);
        if (allText.isEmpty()) {
            element2.sendKeys(Keys.SPACE);
        } else {
            element2.sendKeys(allText);
            //делать ввод по отдельным символам не нужно, т.к. полученный текст и так вводится по символам, а не всем куском.
//            String firstLetter = String.valueOf(allText.charAt(0));
//            element2.sendKeys(firstLetter);
        }
    }

    public int checkResult(WebDriver driver){
        WebElement element = driver.findElement(result);
        String resString = element.getText();
        int resInt = Integer.parseInt(resString);
        return resInt;
    }
}
