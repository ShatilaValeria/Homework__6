package onliner.selenium.pages;

import onliner.selenium.elements.TopMenu;

public abstract class BasePage {

    public abstract void openPage();

    protected TopMenu topMenu = new TopMenu();
}
