package org.future.rofita;

import org.future.rofita.pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AppTest {
    private static WebDriver driver;

    private static HomePage homePage;
    private static SignInOptionsPage signInOptionsPage;
    private static SignInPage signInPage;
    private static WatchlistPage watchlistPage;
    private static EditWatchlistPage editWatchlistPage;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver","E:\\instalasi\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
        signIn();
    }

    @Before
    public void before() {
        driver.get("https://www.imdb.com/");
        homePage.clickWatchlist();
    }

//    @Test
    public void addOneMovie() throws InterruptedException {

        String movieTitle;
        List<WebElement> watchlistTitles;
        List<WebElement> tempListTitles;

        watchlistPage = new WatchlistPage(driver);
        watchlistPage.clickEdit();

        //Add Movie Scenario
        editWatchlistPage = new EditWatchlistPage(driver);
        movieTitle = editWatchlistPage.addMovie("scoo");
        System.out.println(movieTitle);
        Thread.sleep(3000);
        tempListTitles = editWatchlistPage.getTempListTitles();

        //Check added movie's title is exist in temporary list
        Thread.sleep(2000);
        for (WebElement tempListTitle : tempListTitles) {
            System.out.println(tempListTitle.getText());
        }
        boolean tempListCheck = tempListTitles.stream()
                .map(WebElement::getText)
                .anyMatch(text -> movieTitle.equals(text));
        Assert.assertEquals("failed to add movies to the temporary list", true, tempListCheck);

        //Check added movie's title is exist in watchlist
        editWatchlistPage.clickDone();
        watchlistTitles = editWatchlistPage.getWatchlistTitles();
        for (WebElement watchlistTitle : watchlistTitles) {
            System.out.println(watchlistTitle.getText());
        }
        boolean watchlistCheck = watchlistTitles.stream()
                .map(WebElement::getText)
                .anyMatch(text -> movieTitle.equals(text));
        Assert.assertEquals("failed to add movies to Watchlist", true,watchlistCheck);
    }

    @Test
    public void doubleMovieTempList() throws InterruptedException {

        String movieTitle;
        List<WebElement> tempListTitles;

        watchlistPage = new WatchlistPage(driver);
        watchlistPage.clickEdit();

        editWatchlistPage = new EditWatchlistPage(driver);
        movieTitle = editWatchlistPage.addMovie("scoo");
        editWatchlistPage.addMovie("scoo");
        System.out.println(movieTitle);
        Thread.sleep(3000);
        tempListTitles = editWatchlistPage.getTempListTitles();
        int tempListCount = tempListTitles.size();
        Assert.assertEquals("add the same film to the temporary list is not handled", 1, tempListCount);
    }

    @Test
    public void doubleMovieWatchlist() throws InterruptedException {

        String movieTitle;
        List<WebElement> watchlistTitles;

        watchlistPage = new WatchlistPage(driver);
        watchlistPage.clickEdit();

        editWatchlistPage = new EditWatchlistPage(driver);
        movieTitle = editWatchlistPage.addMovie("scoo");
        editWatchlistPage.addMovie("scoo");
        System.out.println(movieTitle);
        Thread.sleep(3000);
        editWatchlistPage.clickDone();
        watchlistTitles = editWatchlistPage.getWatchlistTitles();
        int watchlistCount = watchlistTitles.size();

        Assert.assertEquals("add the same film to the watchlist is not handled", 1, watchlistCount);
    }


    @After
    public void  after() throws InterruptedException {
        Thread.sleep(6000);
//        driver.quit();
    }

    private static void signIn() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();

        signInOptionsPage = new SignInOptionsPage(driver);
        signInOptionsPage.useImdbAccount();

        signInPage = new SignInPage(driver);
        signInPage.signIn();
    }

}

