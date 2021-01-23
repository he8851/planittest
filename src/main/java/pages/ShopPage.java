package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage{

    private final static String loc_CartTxt="a[href='#/cart']";
    private String buyBtnByProduct(String productName){
        String buyBtnByProductTxt="//*[.='"+productName+"']/../p/a";
        return  buyBtnByProductTxt;
    }

    @FindBy(css =loc_CartTxt)
    private WebElement cartTxt;

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public ShopPage clickBuyBtnByProduct(String productName){
        WebElement buyProductBtn=driver.findElement(By.xpath(buyBtnByProduct(productName)));
        buyProductBtn.click();
        return new ShopPage(driver);
    }

    public CheckoutPage clickCartTxt(){
        cartTxt.click();
        return new CheckoutPage(driver);
    }

}
