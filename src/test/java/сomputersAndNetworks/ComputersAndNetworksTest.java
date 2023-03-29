package сomputersAndNetworks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ComputersAndNetworksTest {
    private static ChromeDriver driver;
    private static final String PRODUCT_NAME_PATTERN = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and text()='%s']";
    private static final String PRODUCT_NAME_ELEMENT = "//*[contains(text(), '%s')]";

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://onliner.by");
        driver.findElement(By.cssSelector(".b-main-navigation__link")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(String.format(PRODUCT_NAME_PATTERN, "Компьютеры и\u00A0сети"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testCheckComputersAndNetworks() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ELEMENT, "Ноутбуки, компьютеры, мониторы"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckAccessories() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ELEMENT, "Комплектующие"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckDataStorage() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ELEMENT, "Хранение данных"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckNetworkEquipment() {
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ELEMENT, "Сетевое оборудование"))).isDisplayed();
        Assertions.assertTrue(expected);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
