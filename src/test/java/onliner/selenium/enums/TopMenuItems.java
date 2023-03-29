package onliner.selenium.enums;

public enum TopMenuItems {
    CATALOG("Каталог"), NEWS("Новости"), AUTOSALES(""), FLATSALES(""), SERVICES(""), SALES(""), FORUM("");

    private String value;

    TopMenuItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
