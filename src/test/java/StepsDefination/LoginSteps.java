package StepsDefination;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User is opening Chrome browser")
	public void user_is_opening_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@And("User navigates to OrangeHRM login")
	public void user_navigates_to_orange_hrm_login() {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_admin_and_admin123(String username, String password) throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
	               .visibilityOfElementLocated(By.name("username")))
	               .sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@And("User clicks on login button in orange")
	public void user_clicks_on_login_button_in_orange() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("User should be logged in successfully to oranghrms")
	public void user_should_be_logged_in_successfully_to_oranghrms() {
		  // Write code here that turns the phrase above into concrete actions
		 try {
	            // ✅ Wait for Dashboard
	            WebElement dashboard = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//h6[text()='Dashboard']")
	                )
	            );

	            Assertions.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed");
	            System.out.println("Login successful");

	        } catch (TimeoutException e) {

	            // ❌ Login failed → capture error message
	            WebElement errorMsg = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//p[contains(@class,'alert-content-text')]")
	                )
	            );

	            Assertions.fail("Login failed. Error message: " + errorMsg.getText());

	        }				   
		  
	}
	@After
	public void tearDown() {
	    driver.quit();
	}

}
