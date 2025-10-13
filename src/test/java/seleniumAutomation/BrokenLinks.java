package seleniumAutomation;


import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		int brokenLinkCount =0;
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		for(WebElement linkElement : links) {
			
			String hrefValue=linkElement.getAttribute("href");
			if(hrefValue==null || hrefValue.isEmpty()) {
				continue;
			}
			try {
			URL linkURL= new URL(hrefValue);
			HttpURLConnection conn=(HttpURLConnection)linkURL.openConnection();
			conn.connect();
			
			if(conn.getResponseCode()>=400) {
				System.out.println(hrefValue+"====>"+"Broken Link");
				brokenLinkCount++;
			}
			else {
				
				System.out.println(hrefValue+"====>"+"Not a Broken Link");
			}
			
			}catch(Exception e) {
				
			}
			
			
		}
		driver.close();

	}

}
