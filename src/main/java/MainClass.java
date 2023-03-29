import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://onliner.by");
        driver.findElement(By.cssSelector(".b-main-navigation__link")).click();
        boolean element = driver.findElement(By.xpath(String.format("//span[@class='catalog-navigation-classifier__item-title-wrapper' and text()='%s']", "Электроника"))).isDisplayed();
        if (element) {
            System.out.println("Категоря присутствует");
        }
        driver.quit();
    }
}

