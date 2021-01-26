package org.future.rofita.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInOptionsPage {
    WebDriver driver;

    By ImdbOption = By.xpath("//span[@class='auth-provider-text' and text()='Sign in with IMDb']");

    public SignInOptionsPage (WebDriver driver) {
        this.driver = driver;
    }

    public void useImdbAccount() {
        driver.findElement(ImdbOption).click();
    }

}
