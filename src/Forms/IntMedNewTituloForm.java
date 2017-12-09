package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.IntMedPage;

public class IntMedNewTituloForm extends IntMedPage{
	
	public IntMedNewTituloForm(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() throws Exception {
		driver.get("http://med-profile.apps.intmed.com.br/titulations/new");
		driver.manage().window().maximize(); 
	}
	
	public void fillTipo(String tipo) {
		By locator = By.id("titulation_tipo");
		WebElement field = driver.findElement(locator);
		//TODO
	}
	
	public void fillDescricao(String descricao) {
		By locator = By.id("titulation_description");
		WebElement field = driver.findElement(locator);
		field.sendKeys(descricao);
	}
	
	public void fillInstituicao(String instituicao) {
		By locator = By.id("titulation_location");
		WebElement field = driver.findElement(locator);
		field.sendKeys(instituicao);
	}
	
	public void fillMesAnoInicial(String mes, String ano) {
		By locator = By.id("titulation_start_date");
		WebElement field = driver.findElement(locator);
		//TODO
	}
	
	public void fillMesAnoFinal(String mes, String ano) {
		By locator = By.id("titulation_end_date");
		WebElement field = driver.findElement(locator);
		//TODO
	}
	
	public void checkConcluido(boolean check){
		By locator = By.id("titulation_finished");
		WebElement field = driver.findElement(locator);
		//TODO
	}
	
	public void clickSalvar(){
		By locator = By.cssSelector("#new_titulation > div.modal-footer > button");
		WebElement button = driver.findElement(locator);
		button.click();
	}
}
