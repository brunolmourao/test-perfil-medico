package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntMedCadastroPage extends IntMedPage{

	public IntMedCadastroPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() throws Exception {
		driver.get("http://med-profile.apps.intmed.com.br/cadastro");
		driver.manage().window().maximize(); 
	}
	
	public void fillNome(String nome) {
		By locator = By.id("user_name");
		WebElement field = driver.findElement(locator);
		field.sendKeys(nome);
	}
	
	public void fillCPF(String cpf) {
		By locator = By.id("user_cpf");
		WebElement field = driver.findElement(locator);
		field.click();
		field.clear();
		field.sendKeys(cpf);
	}
	
	public void fillTelefone(String telefone) {
		By locator = By.id("user_phone");
		WebElement field = driver.findElement(locator);
		field.click();
		field.clear();
		field.sendKeys(telefone);
	}
	
	public void fillEmail(String email) {
		By locator = By.id("user_email");
		WebElement field = driver.findElement(locator);
		field.sendKeys(email);
	}
	
	public void fillSenha(String senha) {
		By locator = By.id("user_password");
		WebElement field = driver.findElement(locator);
		field.sendKeys(senha);
		By locator2 = By.id("user_password_confirmation");
		WebElement field2 = driver.findElement(locator2);
		field2.sendKeys(senha);
	}
	
	public void clickRegistrar(){
		By locator = By.xpath("/html/body/div/div[2]/form/div[7]/div[2]/input");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
}
