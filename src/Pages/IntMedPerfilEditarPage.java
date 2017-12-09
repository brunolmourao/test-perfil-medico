package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntMedPerfilEditarPage extends IntMedPage{
	public IntMedPerfilEditarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() throws Exception {
		IntMedLoginPage login = new IntMedLoginPage(driver);
		login.openPage();
		login.fillEmail("teste@gmail.com");
		login.fillPassword("testesenha");
		login.clickLogin();
		
		//driver.get("http://med-profile.apps.intmed.com.br/perfil/editar");
		driver.manage().window().maximize(); 
	}
	
	public void fillNome(String nome) {
		By locator = By.id("user_name");
		WebElement field = driver.findElement(locator);
		field.sendKeys(nome);
	}
	
	public void fillEmail(String email) {
		By locator = By.id("user_email");
		WebElement field = driver.findElement(locator);
		field.sendKeys(email);
	}
	
	public void fillNaturalidade(String naturalidade) {
		By locator = By.id("user_birthplace");
		WebElement field = driver.findElement(locator);
		field.sendKeys(naturalidade);
	}
	
	public void fillTelefone(String telefone) {
		By locator = By.id("user_phone");
		WebElement field = driver.findElement(locator);
		field.sendKeys(telefone);
	}
	
	public void fillCRM(String CRM) {
		By locator = By.id("user_crm");
		WebElement field = driver.findElement(locator);
		field.sendKeys(CRM);
	}
	
	public void fillEstadoCRM(String estadoCRM) {
		By locator = By.id("user_crm_location");
		WebElement field = driver.findElement(locator);
		field.sendKeys(estadoCRM);
	}
	
	public void fillCPF(String cpf) {
		By locator = By.id("user_cpf");
		WebElement field = driver.findElement(locator);
		field.sendKeys(cpf);
	}
	
	public void fillDataNascimento(String dataNascimento) {
		By locator = By.id("user_birthday");
		WebElement field = driver.findElement(locator);
		field.sendKeys(dataNascimento);
	}
	
	public void fillCEP(String cep) {
		By locator = By.id("user_address_attributes_cep");
		WebElement field = driver.findElement(locator);
		field.sendKeys(cep);
	}
	
	public void fillLogradouro(String logradouro) {
		By locator = By.id("user_address_attributes_street");
		WebElement field = driver.findElement(locator);
		field.sendKeys(logradouro);
	}
	
	public void fillNumero(String numero) {
		By locator = By.id("user_address_attributes_number");
		WebElement field = driver.findElement(locator);
		field.sendKeys(numero);
	}
	
	public void fillComplemento(String complemento) {
		By locator = By.id("user_address_attributes_complement");
		WebElement field = driver.findElement(locator);
		field.sendKeys(complemento);
	}
	
	public void clickSalvar() {
		By locator = By.cssSelector("#edit_user_445 > div.box-footer > button");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickVoltar() {
		By locator = By.cssSelector("#edit_user_445 > div.box-footer > a");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickNewFormacao() {
		By locator = By.cssSelector("#formations > div.box-header.with-border > div > a");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickNewTitulo() {
		By locator = By.cssSelector("#titulations > div.box-header.with-border > div > a");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickNewCursos() {
		By locator = By.cssSelector("#qualifications > div.box-header.with-border > div > a");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickNewExperiencia() {
		By locator = By.cssSelector("#experiences > div.box-header.with-border > div > a");
		WebElement button = driver.findElement(locator);
		button.click();
	}
	
	public void clickNewCargo() {
		By locator = By.cssSelector("#posts > div.box-header.with-border > div > a");
		WebElement button = driver.findElement(locator);
		button.click();
	}
}
