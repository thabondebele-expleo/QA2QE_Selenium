package StepDefinitions;

import PageObjects.ProductPageObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SelectProductstepdefinition {


    WebDriver driver;
    ProductPageObjects ProductsPage;
    private By SelectProductLocator = By.linkText("Push It Messenger Bag");

    @Given("I have selected a product")

    public void i_have_selected_a_product() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tee\\Desktop\\java-executable-examples\\TestAutomation\\Jar_files\\geckodriver.exe");
        driver = new FirefoxDriver();
        //to view the product, a certain website has to be opened
        driver.navigate().to("https://magento.abox.co.za/");

        //Negative test of opening the wrong webpage

        //driver.get("http://www.naukri.com/");
       // driver.findElement(By.id("p0submit")).click();
        // This will capture error message
        //Assert.assertEquals(actual_msg, expect);
    }

    @When("I have viewed the product description")
    public void i_have_viewed_the_product_description() {
        WebElement body = driver.findElement(By.tagName("body"));
//The product to be opened is under the category "Hot Sellers"
        String bodyText = body.getText();
        Assert.assertTrue("Available products ", bodyText.contains("Hot Sellers"));
        driver.findElement(By.linkText("Push It Messenger Bag")).click();

        body = driver.findElement(By.tagName("body"));
        bodyText = body.getText();
        //Check if the page opened is the correct page
        Assert.assertTrue("You are now viewing the product you select ", bodyText.contains("Push It Messenger Bag"));
        ProductPageObjects SelectProduct = PageFactory.initElements(driver, ProductPageObjects.class);

    }

    @Then("I can abandon page")
    // Closing the Website page after viewing the product
    public void i_can_abandon_page() {
      //After the webpage has opened, it must pause for a few seconds before being closed
        WebDriverWait wait = new WebDriverWait(driver, 100);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProductstepdefinition));
        //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.close();

    }

 //   public void OpenWrongPage()
   // {

       // FirefoxDriver driver=new FirefoxDriver();
       // driver.manage().window().maximize();

   // }
}

