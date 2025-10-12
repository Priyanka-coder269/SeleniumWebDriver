package seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class JavascriptExecutor_Scrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement ele=driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView();",ele);
		
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	}

}
