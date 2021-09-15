import static org.junit.Assert.*;

import java.net.URL;
import java.text.MessageFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrStTest {
	
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception{
		
		String BrStack_User = "salaheddine_IuK7v4";
		String BrStack_key = "nko47Z9EMzLCg1S6EgMx";
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platform", "MAC");
	    caps.setCapability("browserName", "Safari");
	    caps.setCapability("name", "BMI Calculator Test");
	    
	    driver = new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@hub-cloud.browserstack.com/wd/hub", BrStack_User, BrStack_key)), caps);
	    driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");	
	}
	
	@After
	public void cleanUp() {
		driver.quit();
	}
	
	
	@Test 
	public void testBMICalc () {
		
		WebElement height = driver.findElement(By.name("heightCMS"));
	    height.sendKeys("181");
	    WebElement weight = driver.findElement(By.name("weightKg"));
	    weight.sendKeys("80");
	    WebElement calculateButton = driver.findElement(By.id("Calculate"));
	    calculateButton.click();
	    WebElement bmi = driver.findElement(By.name("bmi"));
	    assertEquals(bmi.getAttribute("value"), "24.4");
	    WebElement bmiCategory = driver.findElement(By.name("bmi_category"));
	    assertEquals(bmiCategory.getAttribute("value"), "Normal");
	}
}
