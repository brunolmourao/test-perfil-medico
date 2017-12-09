package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class IntMedPage {
	protected WebDriver driver;
	
	public void waitElementToBeVisible(By element){
		WebDriverWait wait = new WebDriverWait(driver, 	100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitElementToBeClickable(By element){
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Boolean waitLoading() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	    if((Boolean) executor.executeScript("return window.jQuery != undefined")){
	        while(!(Boolean) executor.executeScript("return jQuery.active == 0")){
	            Thread.sleep(1000);
	        }
	    }
	    return true;
	}
}
