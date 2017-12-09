package Pages;
import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Forms.IntMedNewTituloForm;

public class ClasseTest {
	private WebDriver driver;
	
	@Before
	public void setUp(){
		if(System.getProperty("os.name").startsWith("Windows"))
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		else
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new ChromeDriver();
		//drive.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//Test Case 1
	@Test
	public void testIntMedValidLogin() throws Exception{
		IntMedLoginPage loginPage = new IntMedLoginPage(driver);
		loginPage.openPage();
		loginPage.fillEmail("teste@gmail.com");
		loginPage.fillPassword("testesenha");
		loginPage.clickLogin();
		loginPage.waitLoading();
		
		By locator = By.xpath("/html/body/div/div[2]/section/div/div/div[2]/div/h3");
		assertEquals("Editar Usuario", driver.findElement(locator).getText());
	}
	@Test
	public void testInsertTitle() throws Exception{
		IntMedLoginPage loginPage = new IntMedLoginPage(driver);
		loginPage.openPage();
		loginPage.fillEmail("teste@gmail.com");
		loginPage.fillPassword("testesenha");
		loginPage.clickLogin();
		loginPage.waitLoading();
		IntMedNewTituloForm tituloPage = new IntMedNewTituloForm(driver);
		tituloPage.openPage();
		tituloPage.fillTipo("titulo");
		tituloPage.fillInstituicao("UFC");
		tituloPage.fillDescricao("T�tulo");
		tituloPage.fillMesAnoInicial("04", "2010");
		tituloPage.fillMesAnoFinal("09", "2010");
		tituloPage.checkConcluido();
		tituloPage.clickSalvar();
		assertNotNull(driver.findElement(By.xpath("/html/body/div/div[2]/section/div/div/div[4]/div[2]/table/tbody/tr/td[9]/div/a[2]")));
		
	}
	
	//Test Case 2
	@Test
	public void testIntMedInvalidPassword() throws Exception{
		IntMedLoginPage loginPage = new IntMedLoginPage(driver);
		loginPage.openPage();
		loginPage.fillEmail("teste@gmail.com");
		loginPage.fillPassword("testesssssenha");
		loginPage.clickLogin();
		loginPage.waitLoading();
		
		By locator = By.xpath("/html/body/div/div[2]/div/h4");
		assertEquals("Atenção!", driver.findElement(locator).getText());
	}
	
	//Test Case 3
	@Test 
	public void testIntMedInvalidLogin() throws Exception{
		IntMedLoginPage loginPage = new IntMedLoginPage(driver);
		loginPage.openPage();
		loginPage.fillEmail("testssse@gmail.com");
		loginPage.fillPassword("testesenha");
		loginPage.clickLogin();
		loginPage.waitLoading();
		
		By locator = By.xpath("/html/body/div/div[2]/div/h4");
		assertEquals("Atenção!", driver.findElement(locator).getText());
	}

	//Test Case 4
	@Test
	public void testRegister() throws Exception {
		IntMedCadastroPage cadastroPage = new IntMedCadastroPage(driver);
		cadastroPage.openPage();
		cadastroPage.fillNome("João");
		cadastroPage.fillCPF("111.111.111-11");
		cadastroPage.fillTelefone("(11)1 1111.1111");
		cadastroPage.fillEmail("testejoao@teste.com");
		cadastroPage.fillSenha("testesenhajoao");
		cadastroPage.clickRegistrar();
		
		By locator = By.xpath("/html/body/div/div[2]/section/div/div/div[2]/div/h3");
		assertEquals("Editar Usuario", driver.findElement(locator).getText());
	}
	
	@Test
	public void testPerfil() throws Exception{
		IntMedPerfilEditarPage perfilpage = new IntMedPerfilEditarPage(driver);
		perfilpage.openPage();
		perfilpage.fillNome("assafasdjhfsajd");
		
		By locator = By.xpath("/html/body/div/div[2]/section/div/div/div[2]/div/h3");
		assertEquals("Editar Usuario", driver.findElement(locator).getText());
	}
	
	@After
	public void tearDown(){
		try{  
		    Thread.sleep(2000);  
		}catch(Exception e){} 
		driver.close();
		driver.quit();
		System.out.println("Terminando o selenium web driver");
	}
}	
