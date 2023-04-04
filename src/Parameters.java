import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class Parameters {

	WebDriver driver ;
	SoftAssert myAssert;
	Random Rand ;
	JavascriptExecutor Jse ;
	//Actions actions = new Actions(driver);
	@BeforeTest
	public void MySetup() {	
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");  
		driver = new ChromeDriver(options);
		myAssert= new SoftAssert();
		Rand = new Random();
		Jse = (JavascriptExecutor) driver;
		driver.get("https://magento.softwaretestingboard.com/");
	}
}
