package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.IntMedPage;

public class IntMedNewCursosForm extends IntMedPage{

	public IntMedNewCursosForm(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() throws Exception {
		driver.get("http://med-profile.apps.intmed.com.br/qualifications/new");
		driver.manage().window().maximize(); 
	}
	
	public void fillDescricao(String descricao) {
		By locator = By.id("qualification_description");
		WebElement field = driver.findElement(locator);
		field.sendKeys(descricao);
	}
	
	public void fillInstituicao(String instituicao) {
		By locator = By.id("qualification_location");
		WebElement field = driver.findElement(locator);
		field.sendKeys(instituicao);
	}
	
	public void fillMesAnoInicial(String mes, String ano) {
		By locator = By.id("qualification_start_date");
		WebElement field = driver.findElement(locator);
		field.click();
		field.sendKeys(mes+"/"+ano);
	}
	
	public void fillMesAnoFinal(String mes, String ano) {
		By locator = By.id("qualification_end_date");
		WebElement field = driver.findElement(locator);
		field.click();
		field.sendKeys(mes+"/"+ano);
	}
	
	public void checkConcluido(boolean check){
		By locator = By.id("qualification_finished");
		WebElement field = driver.findElement(locator);
		if ( !driver.findElement(locator).isSelected() )
		{
		     driver.findElement(locator).click();
		}
	}
	
	public void clickSalvar(){
		By locator = By.cssSelector("#new_qualification > div.modal-footer > button");
		WebElement button = driver.findElement(locator);
		button.click();
	}
}
