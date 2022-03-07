package com.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.Keys.ENTER;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class SearchStepDef {

    WebDriver driver;

    @Given("user is in login page")
    public void user_is_in_google_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\manny.montealto\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.demoqa.com/my-account/");


    }

    @When("user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {

        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys(username);
        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys(password);
        WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        login.sendKeys(ENTER);
        System.out.println("Enter username: " + username + " and password " + password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user is navigated to account page")
    public void i_will_successfully_search_a_word() {

        WebElement logout = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Logout']")));
        String te = logout.getText();
        String lo = "logout";

        driver.close();
        if (te.equalsIgnoreCase(lo)) {
            System.out.println("Acceptance Testing Successfully");
        } else {
            System.out.println("Acceptance Testing failed");
        }

    }

    @Then("user received error message")
    public void user_received_error_message() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='ERROR']")));
        String text = driver.findElement(By.xpath("//strong[normalize-space()='ERROR']")).getText();
        String error = "error";

        driver.close();
        if (text.equalsIgnoreCase(error)) {
            System.out.println("Acceptance Testing Successfully");
        } else {
            System.out.println("Acceptance Testing failed");
        }
    }
}