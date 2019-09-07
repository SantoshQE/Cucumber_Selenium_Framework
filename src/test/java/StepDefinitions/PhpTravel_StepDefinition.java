package StepDefinitions;

import Configuration.Config;
import ObjectRepository.Phptravels_OR;
import Pages.phpTravelsHomePage;
import Pages.phpTravelsLoginPage;
import Utils.Utilities;
//import com.sun.deploy.security.SelectableSecurityManager;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class PhpTravel_StepDefinition
{
    public static WebDriver driver=null;
    static phpTravelsLoginPage phpLoginPg;
    static phpTravelsHomePage phpHomePg;
    static Config conf;

    @Before
    public void launchWebBrowser()  throws Throwable
    {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\SeleniumDriverExe\\Chromedriver\\chromedriver.exe");
        if (driver == null)
        {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            phpLoginPg = new phpTravelsLoginPage(driver);
            phpHomePg = new phpTravelsHomePage(driver);
        }
    }
    @Given("^User navigates to URL (.*)$")
    public void navigateToPhptravelsDemoSite(String URL)  throws Throwable
    {
        System.out.println("User is on PhpTravel site login page " +URL);
        driver.get(URL);
    }
    @And("^User clicks on Login Button$")
    public void userClicksOnLoginButton()  throws Throwable
    {
        phpLoginPg.phpTravels_btnLogin.click();
    }
    @When("^phptravels User enter valid (.*) username (.*) and password (.*)$")
    public void phptravelsUserLogin(String UserRole,String userName, String Pwd)  throws Throwable
    {
        if(UserRole.equalsIgnoreCase("admin"))
        {
            phpLoginPg.phpTravelsAdminLogin(userName,Pwd);
            System.out.println("admin role login step");
        }
        else
        {
            phpLoginPg.phpTravelsLogin(userName,Pwd);
            System.out.println("Non-admin role login step");
        }
    }
    @Then("^phptravels User (.*) is able to login successfully$")
    public void checkPhpTravelsLoginSuccess(String UserRole)  throws Throwable
    {
        if(UserRole.equalsIgnoreCase("admin"))
        {
            phpLoginPg.phpTravelsAdminLoginSucessCheck();
            System.out.println("admin role login check done");
        }
        else
        {
            phpLoginPg.phpTravelsLoginSuccessCheck();
            System.out.println("Non-admin role login check done");
        }
    }

    @When("^User navigates to Add Customer page$")
    public void userNavigatesToAddCustomerPage()
    {
        phpHomePg.navigateToCustomers();
        phpHomePg.phpTravels_btnAddCustomer.click();
    }

    @And("^Submits the new customer details as below$")
    public void submitsTheNewCustomerDetailsAsBelow(DataTable dt) throws InterruptedException {
        phpHomePg.addNewCustomer(dt);
    }
  @After
    public void closeTheBrowser()
    {
        if (driver != null)
        {
            driver.close();
        }
        System.out.println("Browser closed-[PHPStepDefinition]");
    }

}
