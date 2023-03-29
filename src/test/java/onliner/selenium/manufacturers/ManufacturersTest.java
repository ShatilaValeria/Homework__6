package onliner.selenium.manufacturers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManufacturersTest {

    private static ChromeDriver driver;
    private static final By PRODUCT_NAME_PATTERN = By.xpath("//span[text()='Фены']");
    private static final String NAME_MANUFACTURERS_PATTERN = "//input[@value='%s']/following-sibling::span";
    private static final String PRODUCT_NAME_ACTUAL_PATTERN = "//input[@value='%s']";


    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://onliner.by");
        driver.findElement(PRODUCT_NAME_PATTERN).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
    }

    @Test
    public void testCheckDyson() {
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "dyson"))).click();
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "dyson"))).isSelected();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckRowenta() {
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "rowenta"))).click();
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "rowenta"))).isSelected();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckBaByliss() {
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "babyliss"))).click();
        boolean expected = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "babyliss"))).isSelected();
        Assertions.assertTrue(expected);
    }

    @Test
    public void testCheckDysonAndRowentaAnd() {
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "dyson"))).click();
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "rowenta"))).click();

        boolean expectedFirstManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "dyson"))).isSelected();
        boolean expectedSecondManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "rowenta"))).isSelected();

        Assertions.assertTrue(expectedFirstManufacturers);
        Assertions.assertTrue(expectedSecondManufacturers);
    }

    @Test
    public void testCheckBaBylissAndRowentaAndDyson() {
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "dyson"))).click();
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "rowenta"))).click();
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "babyliss"))).click();

        boolean expectedFirstManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "dyson"))).isSelected();
        boolean expectedSecondManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "rowenta"))).isSelected();
        boolean expectedThirdManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "babyliss"))).isSelected();

        Assertions.assertTrue(expectedFirstManufacturers);
        Assertions.assertTrue(expectedSecondManufacturers);
        Assertions.assertTrue(expectedThirdManufacturers);
    }

    @Test
    public void test() {
        driver.findElement(By.cssSelector(".schema-filter-control__item")).click();

        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "tefal"))).click();
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "first"))).click();
        driver.findElement(By.xpath(String.format(NAME_MANUFACTURERS_PATTERN, "babyliss"))).click();

        boolean expectedFirstManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "tefal"))).isSelected();
        boolean expectedSecondManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "first"))).isSelected();
        boolean expectedThirdManufacturers = driver.findElement(By.xpath(String.format(PRODUCT_NAME_ACTUAL_PATTERN, "babyliss"))).isSelected();

        Assertions.assertTrue(expectedFirstManufacturers);
        Assertions.assertTrue(expectedSecondManufacturers);
        Assertions.assertTrue(expectedThirdManufacturers);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
