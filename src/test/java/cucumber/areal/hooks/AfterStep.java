package cucumber.areal.hooks;


import cucumber.areal.MySingleton1;
import cucumber.areal.MySingleton2;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AfterStep {
    MySingleton1 instance1 = MySingleton1.getInstance1();
    MySingleton2 instance2 = MySingleton2.getInstance2();


    // !!!Аннотации @After запускает с нижней к верхней!!!

    @After
    public void close2() throws InterruptedException {
        if (!(instance2.webDriver2 == null)) {
            //"wait" использую для того, чтобы не закрывал драйвер более долгого 2-минутного теста вместе с драйвером
            // 1-минутного теста сразу после окончания работы последнего, а ждал появления на странице элемента
            // появляющегося после окончания 2-минутного теста
            instance2.wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='main_view']//div[@class='typing-detail-stats']//h3[text()='По словам']")));
            //Делаю такую же паузу как и в методе "enterSymbolsOfTheLineDuring2Minute()" файла "ArealStep.java", чтобы
            // сайт успел подсчитать результаты
            Thread.sleep(9000);
            //чтобы не вылетала ошибка "org.openqa.selenium.remote.http.WebSocket$Listener onError WARNING: Connection reset"
            // нужно закрывать не .close(), а .quit()
            instance2.webDriver2.quit();
        }
    }

    @After
    public void close1() throws InterruptedException {
        //самый быстрый 1-минутный тест, поэтому ни каких дополнительных "танцев с бубном" для закрытия драйвера этого теста не нужно
        if (!(instance1.webDriver1 == null)) {
            //чтобы не вылетала ошибка "org.openqa.selenium.remote.http.WebSocket$Listener onError WARNING: Connection reset"
            // нужно закрывать не .close(), а .quit()
            instance1.webDriver1.quit();
        }
    }


}
