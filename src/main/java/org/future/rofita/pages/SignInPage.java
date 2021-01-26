package org.future.rofita.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;

    String email = "samilerlr.solo@gmail.com";
    String password = "inipasswordimdb";

    By emailField = By.id("ap_email");
    By passwordField = By.id("ap_password");
    By submitButton = By.id("signInSubmit");

    public SignInPage (WebDriver driver) {
        this.driver = driver;
    }

    public void signIn () {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}
