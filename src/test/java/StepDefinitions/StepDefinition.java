package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefinition
{
    WebDriver driver = null;
    public static final String twit_username ="//input[@name='session[username_or_email]' and @class='js-username-field email-input js-initial-focus']";
    public static final String twit_password="//input[@class='js-password-field']";
    public static final String twit_BtnLogin="//button[@class='submit EdgeButton EdgeButton--primary EdgeButtom--medium']";
    public static final String twit_HomeLink="//*[@id='react-root']//div/span[contains(text(),'Home')]";


    @Given("^User (?:.*is on login page|navigates|launches.*) URL (.*)")
    public void NavigateToURL(String URL) throws Throwable
    {
       // Write code here that turns the phrase above into concrete actions
        System.out.println("User is on Twitter login page");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\SeleniumDriverExe\\Chromedriver\\chromedriver.exe");
        if (driver == null)
        {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(URL);
        }
    }
    @When("^User enter (?:.*invalid|valid) username (.*) and password (.*)$")
    public void user_enter_valid_username_and_password(String username,String pwd) throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User enter valid username and password");
/*      WebElement Username =  driver.findElement(By.name("userName"));
        WebElement password =  driver.findElement(By.name("password"));
        WebElement btnLogin =  driver.findElement(By.name("login"));
        Username.sendKeys(username);
        password.sendKeys(pwd);
        btnLogin.click();*/
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement Username =  driver.findElement(By.xpath(twit_username));
        WebElement password =  driver.findElement(By.xpath(twit_password));
        WebElement btnLogin =  driver.findElement(By.xpath(twit_BtnLogin));
        Username.sendKeys(username);
        password.sendKeys(pwd);
        btnLogin.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

    }
    @Then("^User is able to login successfully$")
    public void user_is_able_to_login_successfully() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is able to login successfully");
        WebElement HomeLink = null;
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            HomeLink = driver.findElement(By.xpath(twit_HomeLink));

            driver.close();
            driver = null;
        } catch (Exception exp)
        {
            Assert.assertNotNull("Home Link NOT Present",HomeLink);
            throw exp;
        }

    }
    @After
   // @And("^Close the browser$")
    public void closeTheBrowser()
    {
        if (driver != null)
        {
            driver.close();
        }
        System.out.println("Browser closed - [StepDefinition]");
    }

   // @Given("^User is on login page URL https://twitter\\.com/$")
    public void userIsOnLoginPageURLHttpsTwitterCom() {
    }

    @And("^Clicks on Login Button$")
    public void clicksOnLoginButton()
    {
        driver.findElement(By.xpath("//a[@class='js-nav EdgeButton EdgeButton--medium EdgeButton--secondary StaticLoggedOutHomePage-buttonLogin']")).click();
    }


    // driver.close();

}
