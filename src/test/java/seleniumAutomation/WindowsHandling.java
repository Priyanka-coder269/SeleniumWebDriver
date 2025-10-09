package seleniumAutomation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
	
	Set<String> windowIDs=driver.getWindowHandles();
	
	for(String ID:windowIDs) {
		String title=driver.switchTo().window(ID).getTitle();
		
		if(title.equals("Human Resources Management Software | HRMS | OrangeHRM")) {
			driver.close();
		}
		if( title.equals("OrangeHRM")) {
			driver.switchTo().window(ID);
		}
	}
	
	

	}

}
