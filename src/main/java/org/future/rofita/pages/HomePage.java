package org.future.rofita.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By signInButton = By.xpath("//div[@class='ipc-button__text' and text()='Sign In']");
    By watchlistButton = By.xpath("//div[@class='ipc-button__text' and text()='Watchlist']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void clickWatchlist() {
        driver.findElement(watchlistButton).click();
    }
}
