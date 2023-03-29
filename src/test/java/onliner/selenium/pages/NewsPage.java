package onliner.selenium.pages;

import onliner.selenium.enums.TopMenuItems;
import onliner.selenium.utils.WebDriverRunner;
import org.openqa.selenium.By;

public class NewsPage extends BasePage{


    private By newsTitle = By.xpath("//a[@class='b-tile-main']/h3/span");

    private By newsSection = By.xpath("//a[@class='b-tile-section']");

    public boolean isNewsItemPresent() {
        return topMenu.isItemExists(TopMenuItems.NEWS.getValue());
    }

    public void openPage() {
        topMenu.clickOnItem(TopMenuItems.NEWS);
    }

    public String getNewsTitle() {
        return WebDriverRunner.getDriver().findElements(newsTitle)
                .get(0)
                .getText();
    }

    public String getNewsSection() {
        return WebDriverRunner.getDriver().findElement(newsSection)
                .getText();
    }
}
