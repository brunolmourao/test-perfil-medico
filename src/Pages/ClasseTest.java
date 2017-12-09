package Pages;
import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClasseTest {
	private WebDriver driver;
	
	@Before
	public void setUp(){
		if(System.getProperty("os.name").startsWith("Windows"))
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver");
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
		cadastroPage.fillEmail("teste11232joao@teste.com");
		cadastroPage.fillSenha("testesenhajoao");
		cadastroPage.clickRegistrar();
		
		By locator = By.xpath("/html/body/div/div[2]/section/div/div/div[2]/div/h3");
		assertEquals("Editar Usuario", driver.findElement(locator).getText());
	}
	
	//Test Case 5
		@Test
		public void testRegisterMissingName() throws Exception {
			IntMedCadastroPage cadastroPage = new IntMedCadastroPage(driver);
			cadastroPage.openPage();
			cadastroPage.fillCPF("111.111.111-11");
			cadastroPage.fillTelefone("(11)1 1111.1111");
			cadastroPage.fillEmail("teste23joao@teste.com");
			cadastroPage.fillSenha("testesenhajoao");
			cadastroPage.clickRegistrar();
			
			By locator = By.xpath("/html/body/div/div[2]/form/div[1]/span[2]");
			assertEquals("não pode ficar em branco", driver.findElement(locator).getText());
		}
		
	//Test Case 6
	@Test
	public void testPerfil() throws Exception{
		IntMedPerfilEditarPage perfilpage = new IntMedPerfilEditarPage(driver);
		perfilpage.openPage();
		perfilpage.fillNaturalidade("Brasileiro");
		perfilpage.fillCRM("10");
		perfilpage.fillCEP("60-000-000");
		perfilpage.fillLogradouro("Rua");
		perfilpage.fillCidade("Fortaleza");
		perfilpage.fillEstado("Ceara");
		assertNull(By.cssSelector("#edit_user_445 > div.box-body > div:nth-child(6) > div:nth-child(2) > div > span"));
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
