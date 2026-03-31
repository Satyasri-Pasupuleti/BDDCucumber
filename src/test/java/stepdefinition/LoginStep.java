package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep 
{
	WebDriver driver;
	
	//webdriver class
	@Given("User is on login page")
	public void user_is_on_login_page()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@When("User Login with valid credentials")
	public void user_login_with_valid_credentials() 
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Then("User should be on inventory page")
	public void user_should_be_on_inventory_page() 
	{
		String actualURL=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expected);
	}



}
