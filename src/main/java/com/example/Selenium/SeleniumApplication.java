package com.example.Selenium;

import org.opentest4j.AssertionFailedError;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

//Видео https://www.youtube.com/watch?v=L2jMIJy0u90



public class SeleniumApplication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\Selenium\\chromedriver.exe");

//		//Общая базовая работа с Selenium
//		WebDriver driver = new ChromeDriver();
//
//		// Ожидание выполнения какого то условия устанавливаем на 10 секунд (см. строка 115)
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //далее используя метод "until()", мы в его скобки передаем класс "ExpectedConditions" у которого есть больше 40-ка методов ожидания чего угодно(элемент появился/пропал, чтобы стал кликабельным, URL-адресс текущей страницы содержит определенный текст и т.д.)
		// Устанавливаем неявное время ожидания перед выбрасыванием ошибки о не нахождении элемента на странице на 10 секунд для любого поиска "driver.findElement()"
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		driver.get("https://google.com");
////		driver.get("https://id.heroku.com/login");
//
//		WebElement input1 = driver.findElement(By.xpath("//textarea[@aria-label='Найти']"));
//		//1. Можно отправить на сервер введенные данные сразу тут, иммитировав нажатие ENTER-ом
//		input1.sendKeys("java", Keys.ENTER); //кроме текста можно написать путь до файла и будет отправлен файл,
//		// кроме того каждая написанная в тексте буква вводится Selenium-ом по одной и в три действия, а на какое-то из этих
//		// действий разработчик мог повесить обработку события (проверку на что-то и т.д.) поэтому длинный текст может вводиться
//		// медленно и тогда лучше будет использовать механизм "CTRL C/CTRL V", а не "sendKeys".
//		//2. Можно вначале найти кнопку ввода и после этого на нее нажать
////		WebElement input2 = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@aria-label='Поиск в Google']"));
////		input2.click();
//
//		//Получаем данные полей, которые находятся на вкладке "Properties" из нижнего/правого блока. Тут находится
//		// более полная информация чем в верхней вкладке + больше полей (т.е. все поля этого элемента)
//		WebElement input3 = driver.findElement(By.xpath("//link[contains(@href,'/xjs/_/js/k=xjs')]"));
//		String par1 = input3.getAttribute("href");
//		System.out.println(par1);
//
//		//Получаем данные полей, которые находятся на вкладке "Style" из нижнего/правого блока.
//		String par2 = input3.getCssValue("font-size");
//		System.out.println(par2);
//
//		//Очищение поля
//		//input1.clear();




		//Самые основные действия с классом для более сложных действий "Actions"!!!!!!!!!!!!!
		//Actions actions = new Actions();
		//actions
		//		.moveToElement() //навести курсор на какой-то элемент
		//		.contextClick() //клик пкм
		//		.keyDown().keyUp() //нажимаем/отжимаем лкм на какой-то кнопке
		//		.doubleClick() //двойное нажатие лкм
		//		.clickAndHold() //нажать лкм и задержать
		//      .pause() //пауза
		//		.release() //отпустить лкм
		//		.build().perform(); //собираем все действия/применяем сборку

//		//Делаем на сайте перетаскивание элемента
//		WebDriver driver2 = new ChromeDriver();
//		try {
//			driver2.get("https://crossbrowsertesting.github.io/drag-and-drop");
//			//Делаем задержку перед началом работы с элементами страницы всегда!!!
//			Thread.sleep(2000);
//			WebElement element1 = driver2.findElement(By.cssSelector("#draggable")); //через cssSelector
////			WebElement element1 = driver2.findElement(By.id("draggable"));
//			WebElement element2 = driver2.findElement(By.id("droppable"));
//
//			Actions actions = new Actions(driver2);
//			//1. записываем все действия пошагово
//			actions.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();
//			//2. делаем все то же самое через специальный метод
////			actions.dragAndDrop(element1, element2).perform();
//			//3. есть еще один метод, но он уже перетаскивает элемент используя переданные ему данные о смещении по осям
////			actions.dragAndDropBy(element1, 100, 100).perform();
//		} catch (InterruptedException e) { e.printStackTrace();
//		} finally {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {e.printStackTrace();}
//			driver2.quit();
//		}


//       // Ожидание исчезновения элемента из DOM (со страницы) - использовать при переходе на следующую страницу, в случае
//       когда не загружается полностью новая страница, а теже элементы на листе просто заполняются новыми данными/надписями
//		WebDriver driver3 = new ChromeDriver();
//		driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait3 = new WebDriverWait(driver3, Duration.ofSeconds(10));
//		try {
//			driver3.get("https://pagination.js.org/");
//			Thread.sleep(2000);
//
//			List<WebElement> elements = driver3.findElements(By.xpath("//div[@class='data-container']/ul/li"));
//			List<WebElement> pages = driver3.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));
//			System.out.println("5 element of collection \"elements\" = " + elements.get(4).getText() +  " , 3 element of collection \"pages\" = " + pages.get(2).getText());
//
//            //переходим на 2-ю страницу
//			pages.get(2).click();
//			//делаем паузу и ждем пока пропадет, выбранный нами элемент, полученный со старой страницы. Однозначно удостовериваемся, что старая страница уже закрыта.
//			wait3.until(ExpectedConditions.stalenessOf(elements.get(5)));
//			Thread.sleep(3000);
//			//И только теперь можем выполнять какие-то действия с новой страницей. Например
//			// перезаполняем наши переменные "elements" и "pages" новой информацией (информацией с новой страницы)
//			elements = driver3.findElements(By.xpath("//div[@class='data-container']/ul/li"));
//			pages = driver3.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));
//			System.out.println("AND NOW 5 element of collection \"elements\" = " + elements.get(4).getText() + " , 3 element of collection \"pages\" = " + pages.get(2).getText());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver3.quit();


//		//Проверка всплывающих окон JS - alert, prompt, confirm на нами самими созданной в VisualStudio странице,
//		// лежащей в папке "../Java/Selenium/index.html". Она запускается на порту "5500" если в Visual Studio
//		// открыть этот файл и нажать внизу на значок "Go Live"
//		WebDriver driver4 = new ChromeDriver();
//		driver4.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait4 = new WebDriverWait(driver4, Duration.ofSeconds(10));
//
//		try {
//			driver4.get("http://127.0.0.1:5500/index.html");
//			Thread.sleep(5000);
//
//			WebElement element1 = driver4.findElement(By.id("a"));
//			WebElement element2 = driver4.findElement(By.id("b"));
//			WebElement element3 = driver4.findElement(By.id("c"));
//
//			element1.click();
//			Alert alert1 = wait4.until(alertIsPresent()); //именно такое написание позволяет убедиться, что alert уже появился
//			Thread.sleep(2000);
//			alert1.accept(); //это аналогично нажатию на появляющуюся с alert-ом кнопку "OK"
//
//			element2.click();
//			Alert prompt = wait4.until(alertIsPresent());
//			Thread.sleep(2000);
//			prompt.sendKeys("Super !!");
//			prompt.accept();
//			//тут мы создаем экземпляр для alert-а который появляется сразу после закрытия prompt (см.функцию "myFunc" для второй ссылки)
//			Alert alert2 = wait4.until(alertIsPresent());
//			Thread.sleep(2000);
//			alert2.accept();
//
//			element3.click();
//			Alert confirm = wait4.until(alertIsPresent());
//			Thread.sleep(2000);
//			confirm.dismiss(); //это кнопка отмены, противоположная accept()
//
//		} catch (InterruptedException e) {e.printStackTrace();
//		} finally { driver4.quit();	}
//
//		System.out.println("Hello word !!");


//		//Создание новых и переключени между существующими окнами браузеров (во всех браузерах кроме Chrome. Chrome
//		// создает и переключается между закладками окон браузеров).Опять используем нашу собственную страницу
//		// из примера выше, которую нужно вначале запустить(см. выше как)
//		WebDriver driver5 = new ChromeDriver();
//		driver5.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver5; //получаем объект для возможности работать с нашим объектом с помощью языка JS
//
//		try {
//			driver5.get("http://127.0.0.1:5500/index.html");
//			Thread.sleep(5000);
//
//			String window1 = driver5.getWindowHandle(); //получаем ссылку на открытое сейчас окно браузера (!не вкладку в окне)
//
//			js.executeScript("window.open()"); //открываем новое окно браузера (!не вкладку в окне)
//
//			Set<String> currentWindows = driver5.getWindowHandles(); //получаем список всех открытых окон
//
//			String window2 = null;
//
//			//перебираем все окна списка и как только найдем не "window1", присваиваем его переменной "window2"
//			// и тут же выходим из цикла
//			for (String window : currentWindows) {
//				if (!window.equals(window1)) {
//					window2 = window;
//					break;
//				}
//			}
//
//			driver5.switchTo().window(window2); //переключаемся на окно "window2"
//			driver5.get("http://127.0.0.1:5500/index.html"); //открываем в окне "window2" туже страницу и можем с ней выполнять какие-то действия. Причем Chrome (в отличие от других браузеров) откроет ее как новую вкладку, а не новое окно
//			Thread.sleep(3000);
//			driver5.close(); //закрываем окно "window2"
//			driver5.switchTo().window(window1); //переключаемся на окно "window1" и теперь можем уже с нем выполнять какие-то действия
//			Thread.sleep(3000);
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			driver5.quit();
//		}



//		//Работа со скрытыми на листе input-ами, отправляющими на сервер файлы. Такой input мы вначале находим ищя input у которого
//		// есть атрибут type = 'file'. После этого мы вручную в конструкторе(открыв его через F12) на странице в закладке Style
//		// меняем параметры так, чтобы этот элемент стал видим. После этого мы такие-же изменения должны сделать|повторить в коде на java.
//		// Т.е. зачем-то должны вначале сделать этот элемент видимым глазу, чтобы потом работать с ним методом sendKeys???!!!
//		// В примере он меняет значения для параметров opacity, display, height, width. А в коде java меняет значение только для opacity.
//
//		WebDriver driver6 = new ChromeDriver();
//		driver6.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver6; //получаем объект для возможности работать с нашим объектом с помощью языка JS
//
//		try {
//			driver6.get("http://**********");
//			Thread.sleep(5000);
//
//			js.executeScript("document.querySelector('#xxxx').setAttribute('style', 'opacity:1')"); //задаем нашему элементу новые стили,
//			// чтобы он стал видимым. Для чего вначале ищем через document.querySelector('#xxxx') наш элемент, где #xxxx это cssSelecor для
//			// атрибута id со значением xxx. Потом устанавливаем, используя метод setAttribute, для атрибута style устанавливаем opacity со значением 1.
//
//			WebElement input1 = driver6.findElement(By.xpath("//xxxxxxxxxxx"));
//			//И теперь найдя этот элемент мы можем дальше с ним работать, передавая методом sendKeys сюда како-то файл.
//			........................
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			driver6.quit();
//		}




//		//Использование тестирования через Assert
//		WebDriver driver7 = new ChromeDriver();
//		driver7.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait7 = new WebDriverWait(driver7, Duration.ofSeconds(10));
//
//		try {
//			driver7.get("http://127.0.0.1:5500/index.html");
//			Thread.sleep(5000);
//
//			String title = driver7.getTitle();
//			assertThat(title).isEqualTo("Documenttttt");
//
//		} catch (InterruptedException e) {e.printStackTrace();
//		} catch (AssertionFailedError e) {
//			System.out.println(e.getMessage());
//			System.out.println("Fuck");
//		} finally { driver7.quit();	}
	}
}
