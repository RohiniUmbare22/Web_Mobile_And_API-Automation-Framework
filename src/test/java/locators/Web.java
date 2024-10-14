package locators;

public class Web {
    public static class webLocator {
        public static final String LOGIN_USERNAME_TEXT_BOX = "//input[@placeholder='Username']~xpath";
        public static final String LOGIN_PASSWORD_TEXT_BOX = "//input[@placeholder='Password']~xpath";
        public static final String LOGIN_BUTTON = "//input[@type='submit']~xpath";
        public static final String PAGE_TITLE = "//div[@class='app_logo' and text()='Swag Labs']~xpath";
        public static final String ITEM= "//div[@class='inventory_item_name ' and text()='Sauce Labs Bike Light']~xpath";
        public static final String ADD_TO_CART= "//button[text()='Add to cart']~xpath";

    }

    public static class androidLocator {
        public static final String LOGIN= "//*[contains(@content-desc,'Login')]~xpath";
        public static final String LOGIN_BUTTON = "//*[contains(@content-desc,'Login') and contains(@class,'android.widget.Button')]~xpath";
        public static final String LOGIN_USERNAME_TEXT_BOX = "//*[contains(@hint,'email')]~xpath";
        public static final String LOGIN_PASSWORD_TEXT_BOX = "//*[contains(@hint,'password')]~xpath";
        public static final String MENU_BAR = "//*[contains(@content-desc,'Open navigation menu')]~xpath";

    }
}
