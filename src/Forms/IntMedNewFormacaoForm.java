package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Pages.IntMedPage;

public class IntMedNewFormacaoForm extends IntMedPage{

	public IntMedNewFormacaoForm(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() throws Exception {
		driver.get("http://med-profile.apps.intmed.com.br/formations/new");
		driver.manage().window().maximize(); 
	}
	
	public void fillInstituicao(String instituicao) {
		By locator = By.id("formation_location");
		WebElement field = driver.findElement(locator);
		field.sendKeys(instituicao);
	}
	
	public void fillMesAno(String mes, String ano) {
		By locator = By.id("years_month");
		Select selectedBox = new Select(driver.findElement(locator));
		selectedBox.selectByValue(mes);
		By locator1 = By.id("years_years");
		Select selectedBox1 = new Select(driver.findElement(locator));
		selectedBox.selectByValue(ano);
		
	}

	public void clickSalvar(){
		By locator = By.cssSelector("#new_formation > div.modal-footer > button");
		WebElement button = driver.findElement(locator);
		button.click();
	}
}
