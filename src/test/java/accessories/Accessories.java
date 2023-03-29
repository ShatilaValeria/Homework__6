package accessories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Accessories {
    private static ChromeDriver driver;
    private static final String PRODUCT_NAME_PATTERN = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and text()='%s']";
    private static final String PRODUCT_NAME_CATEGORY = "//*[contains(text(), '%s')]";
    private static final By PRODUCT_NAME = By.xpath("//div[text()=' Комплектующие ']/..//span[contains(@class, 'title')]");
    private static final By PRODUCT_COUNT = By.xpath("//div[text()=' Комплектующие ']/..//span[3]/text()[1]/..");
    private static final By PRODUCT_PRICE = By.xpath("//div[text()=' Комплектующие ']/..//span//following-sibling::text()[1]/..");

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://onliner.by");
        driver.findElement(By.cssSelector(".b-main-navigation__link")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Компьютеры и\u00A0сети"))).click();
        driver.findElement(By.xpath(String.format(PRODUCT_NAME_CATEGORY, "Комплектующие"))).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testCheckName() {
        boolean expected = driver.findElements(PRODUCT_NAME).stream().allMatch(WebElement::isDisplayed);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckCount() {
        boolean expected = driver.findElements(PRODUCT_COUNT).stream().allMatch(WebElement::isDisplayed);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckMinPrice() {
        boolean expected = driver.findElements(PRODUCT_PRICE).stream().allMatch(WebElement::isDisplayed);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(expected);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
