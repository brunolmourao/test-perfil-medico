import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClasseTest {
	private WebDriver drive;
	private String baseurl;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		drive = new ChromeDriver();
		baseurl = ("http://med-profile.apps.intmed.com.br/login");
		//drive.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@After
	public void tearDown(){
		try{  
		    Thread.sleep(2000);  
		}catch(Exception e){} 
		drive.close();
		drive.quit();
		System.out.println("Terminando o selenium web driver");
	}
	@Test
	public void testBU_002(){
		By locator = By.id("user_email");
		By locator1 = By.id("user_password");
		By locator2 = By.name("commit");
		drive.get(baseurl);
		assertEquals("Perfil Médico",drive.getTitle());
		WebElement login = drive.findElement(locator);
		login.sendKeys("teste@gmail.com");
		WebElement password = drive.findElement(locator1);
		password.sendKeys("invalid");
		WebElement button = drive.findElement(locator2);
		button.click();
		assertEquals("Perfil Médico",drive.getTitle());
		
	}
}	
