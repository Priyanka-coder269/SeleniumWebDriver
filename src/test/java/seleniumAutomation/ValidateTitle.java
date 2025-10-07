package seleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitle {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		
		if(title.equalsIgnoreCase("google")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		driver.quit();

	}

}
