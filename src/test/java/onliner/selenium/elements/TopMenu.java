package onliner.selenium.elements;

import onliner.selenium.enums.TopMenuItems;
import onliner.selenium.utils.WebDriverRunner;
import org.openqa.selenium.By;

public class TopMenu {

    private static final String ITEM_PATTERN = "//span[contains(@class,'main-navigation') and contains(text(), '%s')]";

    public boolean isItemExists(String name) {
        return WebDriverRunner.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, name))).isDisplayed();
    }

    public void clickOnItem(TopMenuItems item) {
        WebDriverRunner.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, item.getValue()))).click();
    }
}
