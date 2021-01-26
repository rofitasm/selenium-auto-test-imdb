package org.future.rofita;

import org.future.rofita.pages.HomePage;
import org.future.rofita.pages.SignInOptionsPage;
import org.future.rofita.pages.SignInPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    WebDriver driver;

    HomePage homePage;
    SignInOptionsPage signInOptionsPage;
    SignInPage signInPage;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver","E:\\instalasi\\chromedriver_win32\\chromedriver.exe");
    }

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
    }

    @Test
    public void test() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();

        signInOptionsPage = new SignInOptionsPage(driver);
        signInOptionsPage.useImdbAccount();

        signInPage = new SignInPage(driver);
        signInPage.signIn();

        homePage.clickWatchlist();
    }

    @After
    public void  after() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}

