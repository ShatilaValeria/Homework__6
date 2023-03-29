package onliner.selenium.tests;

import onliner.selenium.pages.NewsPage;
import onliner.selenium.utils.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewsTest {

    private static WebDriver driver;
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private NewsPage newsPage;

    @BeforeAll
    public static void init() {

    }

    @BeforeEach
    public void openOnliner() {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
        driver = WebDriverRunner.getDriver();
        driver.get("https://onliner.by");
        newsPage = new NewsPage();

    }

    @Test
    public void testNewsItemPresent() {
        Assertions.assertTrue(newsPage.isNewsItemPresent());
    }

    @Test
    public void testOpenNewsBlock() {
        newsPage.openPage();
        Assertions.assertAll(
                () -> Assertions.assertFalse(newsPage.getNewsTitle().isEmpty()),
                () -> Assertions.assertFalse(newsPage.getNewsSection().isEmpty())
        );
    }

    @Test
    public void testOpenFirstLink() {

    }


    @AfterEach
    public void cleanUp() {
        WebDriverRunner.getDriver().quit();
    }
}

