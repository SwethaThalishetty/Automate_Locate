package PageComponents;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class BasePage 
{
   WebDriver driver;
   
   
   public BasePage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   
   public void waitForWebElement(WebElement ele) {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.visibilityOf(ele));
   }
   
   public boolean isElementPresent(WebElement ele) {
	   try {
		   waitForWebElement(ele);
		   return ele.isDisplayed();
	   }
	   catch(Exception e) {
		   System.out.println(e);
		   return false;
	   }
	   
   }
   
   public void clickElement(WebElement ele) {
	   try {
		   if(ele.isDisplayed()&&ele.isEnabled()) ele.click();	  
	   }
	   catch(Exception e) {
		   JavascriptExecutor jse=(JavascriptExecutor)driver;
		   jse.executeScript("arguments[0].click();", ele);
	   }
   }
}
