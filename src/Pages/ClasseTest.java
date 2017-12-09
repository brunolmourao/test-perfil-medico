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
