package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {

    private static final String loc_CheckOutBtn ="a[href='#/checkout']";

    @FindBy(xpath = "//tr[@ng-repeat='item in cart.items()']")
    private List<WebElement> selectItemsRows;

    @FindBy(css=loc_CheckOutBtn)
    private WebElement checkOutBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCheckOutBtnDisplay(){
        if(driver.findElements(By.cssSelector(loc_CheckOutBtn)).size()!=0){
            waitForPageComponentLoadFluentWait(checkOutBtn);
            return checkOutBtn.isDisplayed();
        }
        else{
            return false;
        }
    }

    public Product getProductDetails(String productname) {
            Product product=new Product();
            for (WebElement row : selectItemsRows) {
            String rowText = getText(row, "Get Whole Row Text for chosen product items row");
            if (rowText.contains(productname)){
                String[] itemResultRow = rowText.split(" ");
                product.setProductname(itemResultRow[0] +" "+ itemResultRow[1]);
                product.setProductsingleprice(itemResultRow[2]);
                product.setProducttotalprice(itemResultRow[3]);
                return product;
            }
            }

        throw new NotFoundException("Product "+productname+" is not found in the Cart" );

    }
}
