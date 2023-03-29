package catalog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CatalogTest {
    private static ChromeDriver driver;
    private static final String PRODUCT_NAME_PATTERN = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and text()='%s']";


    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://onliner.by");
        driver.findElement(By.cssSelector(".b-main-navigation__link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testCheckElectronics() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Электроника"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckComputersAndNetworks() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Компьютеры и\u00A0сети"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckAppliances() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Бытовая техника"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckConstructionAndRepair() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Стройка и\u00A0ремонт"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckHouseAndGarden() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Дом и\u00A0сад"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckAutoAndMoto() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Авто и\u00A0мото"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckBeautyAndSports() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Красота и\u00A0спорт"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckForChildrenAndMothers() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Детям и\u00A0мамам"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckWorkAndOffice() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Работа и\u00A0офис"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckFood() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Еда"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
