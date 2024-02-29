package cucumber.areal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//Сингтон нужен если необходимо WebDriver запустить в классе для @Befor/Background, потом передать его в класс для
// Scenario, потом закрыть его в классе для @After. При этом нужно не создавать новых объектов класса.
public class MySingleton2 {
    private static volatile MySingleton2 instance2;

    public WebDriver webDriver2;
    public WebDriverWait wait2;

    private MySingleton2(){}

    public static MySingleton2 getInstance2() {
        if (instance2 == null) {
            synchronized (MySingleton2.class) {
                if (instance2 == null) {
                    instance2 = new MySingleton2();
                }
            }
        }
        return instance2;
    }

}
