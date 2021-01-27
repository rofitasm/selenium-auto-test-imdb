package org.future.rofita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EditWatchlistPage {

    WebDriver driver;

    By addMovieSearchField = By.id("add-to-list-search");
    By firstSearchResult = By.xpath("//div[@id='add-to-list-search-results']/child::a[1]");
    By titleFirstResult = By.xpath("//div[@id='add-to-list-search-results']/descendant::span[1]");
    By watchlistTitle = By.xpath("//h3[@class='lister-item-header']/a");
    By tempListTitle = By.xpath("//div[@class='lister-item-title']/a");
    By doneButton = By.xpath("//button[text()='Done']");

    public EditWatchlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public String addMovie(String searchKey) throws InterruptedException {
        String movieTitle;

        driver.findElement(addMovieSearchField).sendKeys(searchKey);
        Thread.sleep(3000);
        movieTitle = driver.findElement(titleFirstResult).getText();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(elementToBeClickable(firstSearchResult)).click();

        return movieTitle;
    }

    public void clickDone() {
        driver.findElement(doneButton).click();
    }

    public List<WebElement> getWatchlistTitles() {
        List<WebElement> watchlistTitles = driver.findElements(watchlistTitle);
        return watchlistTitles;
    }

    public List<WebElement> getTempListTitles() {
        List<WebElement> tempListTitles = driver.findElements(tempListTitle);
        return tempListTitles;
    }

}
