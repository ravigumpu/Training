package tests;
import Functions.*;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CallingFunctionsTest extends HotelApp_BusinessFunctions{
 // private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 // public Properties Prop;
  
  @Before
  public void setUp() throws Exception {
	  
	  Prop = new Properties();
	  Prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
    driver = new FirefoxDriver();
    baseUrl = "http://www.adactin.com/HotelApp";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMyfirstwebdriver() throws Exception {
	  driver.get(baseUrl);
	HA_BF_Login("sreelatharavula", "pinkeyes9");
	 // driver.findElement(By.id(Prop.getProperty("Txt_Login_Username"))).clear();
	 // driver.findElement(By.id(Prop.getProperty("Txt_Login_Username"))).sendKeys("sreelatharavula");
	  //driver.findElement(By.id(Prop.getProperty("Txt_Login_Password"))).clear();
	  //driver.findElement(By.id(Prop.getProperty("Txt_Login_Password"))).sendKeys("pinkeyes9");
	  //driver.findElement(By.id(Prop.getProperty("Txt_Login_Login"))).click();
    //driver.findElement(By.id("username")).sendKeys("sreelatharavula");
    //driver.findElement(By.id("password")).clear();
    //driver.findElement(By.id("password")).sendKeys("pinkeyes9");
    //driver.findElement(By.id("login")).click();
    assertTrue(isElementPresent(By.linkText("Logout")));
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
    new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Creek");
    new Select(driver.findElement(By.id("room_type"))).selectByVisibleText("Standard");
    new Select(driver.findElement(By.id("child_room"))).selectByVisibleText("1 - One");
    driver.findElement(By.id("Submit")).click();
    driver.findElement(By.id("radiobutton_0")).click();
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("first_name")).click();
    driver.findElement(By.id("first_name")).clear();
    driver.findElement(By.id("first_name")).sendKeys("vhjv");
    driver.findElement(By.id("last_name")).clear();
    driver.findElement(By.id("last_name")).sendKeys("jhbvhjbv");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("vhhjbvnm\nvhjvhj\nvhjvhjn");
    driver.findElement(By.id("cc_num")).clear();
    driver.findElement(By.id("cc_num")).sendKeys("1245454242412414");
    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("VISA");
    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("December");
    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2015");
    driver.findElement(By.id("cc_cvv")).clear();
    driver.findElement(By.id("cc_cvv")).sendKeys("456");
    driver.findElement(By.id("book_now")).click();
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Click here to login again")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

