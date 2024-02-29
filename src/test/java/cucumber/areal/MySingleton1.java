package cucumber.areal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//Сингтон нужен если необходимо WebDriver запустить в классе для @Befor/Background, потом передать его в класс для
// Scenario, потом закрыть его в классе для @After. При этом нужно не создавать новых объектов класса.
public class MySingleton1 {
    private static volatile MySingleton1 instance1;

    public WebDriver webDriver1;
    public WebDriverWait wait1;

    private MySingleton1(){}

    public static MySingleton1 getInstance1() {
        if (instance1 == null) {
            synchronized (MySingleton1.class) {
                if (instance1 == null) {
                    instance1 = new MySingleton1();
                }
            }
        }
        return instance1;
    }

}
