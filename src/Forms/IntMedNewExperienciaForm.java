package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.IntMedPage;

public class IntMedNewExperienciaForm extends IntMedPage{

	public IntMedNewExperienciaForm(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() throws Exception {
		driver.get("http://med-profile.apps.intmed.com.br/experiences/new");
		driver.manage().window().maximize(); 
	}
	
	public void fillCargo(String cargo) {
		By locator = By.id("experience_post");
		WebElement field = driver.findElement(locator);
		field.sendKeys(cargo);
	}
	
	public void fillBreveDescricao(String breveDescricao) {
		By locator = By.id("experience_description");
		WebElement field = driver.findElement(locator);
		field.sendKeys(breveDescricao);
	}
	
	public void fillInstituicao(String instituicao) {
		By locator = By.id("experience_location");
		WebElement field = driver.findElement(locator);
		field.sendKeys(instituicao);
	}
	
	public void fillMesInicial(String mesInicial,String anoInicial) {
		By locator = By.name("experience[initial_date]");
		WebElement field = driver.findElement(locator);
		field.click();
		field.clear();
		field.sendKeys(mesInicial+"/"+anoInicial);
	}
	
	public void fillMesFinal(String mesFinal,String anoFinal) {
		By locator = By.id("experience_final_date");
		WebElement field = driver.findElement(locator);
		field.click();
		field.clear();
		field.sendKeys(mesFinal+"/"+anoFinal);
	}
	
	public void checkAtual(){
		By locator = By.id("experience_current");
		WebElement field = driver.findElement(locator);
		if ( !driver.findElement(locator).isSelected() )
		{
		     driver.findElement(locator).click();
		}
		
	}
	
	public void clickSalvar(){
		By locator = By.cssSelector("#new_experience > div.modal-footer > button");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
}
