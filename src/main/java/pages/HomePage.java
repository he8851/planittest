package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final String loc_ContactTxt ="a[href='#/contact']";
    private static final String loc_ShopTxt ="a[href='#/shop'] i";

    @FindBy(css=loc_ContactTxt)
    private WebElement contactTxt;

    @FindBy(css=loc_ShopTxt)
    private WebElement shopTxt;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ContactPage clickContactTxt(){
        contactTxt.click();
        return new ContactPage(driver);

    }
    public ShopPage clickShopTxt(){
        shopTxt.click();
        return new ShopPage(driver);

    }


}
