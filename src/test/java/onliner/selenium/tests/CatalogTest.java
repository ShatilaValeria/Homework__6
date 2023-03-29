package onliner.selenium.tests;

import onliner.selenium.pages.CatalogPage;
import org.junit.jupiter.api.Test;

public class CatalogTest {

    @Test
    public void test() {
        new CatalogPage().openPage();
    }
}
