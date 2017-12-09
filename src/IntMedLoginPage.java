

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntMedLoginPage extends IntMedPage{
	
	public IntMedLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() throws Exception {
		driver.get("http://med-profile.apps.intmed.com.br/");
		driver.manage().window().maximize(); 
	}
	
	public void fillEmail(String email) {
		By locator = By.id("user_email");
		WebElement field = driver.findElement(locator);
		field.sendKeys(email);
	}
	
	public void fillPassword(String password) {
		By locator = By.id("user_password");
		WebElement field = driver.findElement(locator);
		field.sendKeys(password);
	}
	
	public void clickLogin() {
		By locator = By.xpath("/html/body/div/div[2]/form/div[3]/div[2]/input");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickCadastro(){
		By locator = By.xpath("/html/body/div/div[2]/form/a[1]");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickEsqueceuSenha(){
		By locator = By.xpath("/html/body/div/div[2]/form/a[2]");
		WebElement button = driver.findElement(locator);
		button.click();
	}
}
