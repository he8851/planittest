package tests;

import models.Product;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ShopPage;

public class CheckoutPageTest extends TestBase{
    HomePage homePage;
    ShopPage shopPage;
    CheckoutPage checkoutPage;

    public CheckoutPageTest(){ super(); }

    @DataProvider(name = "selectedproduct")
    public Object[][] productlist() {
        return new String[][]{
                {"Funny Cow","Fluffy Bunny"}
        };
    }

    @Test(priority = 4, description = "Test Case 4", dataProvider = "selectedproduct")
    public void verifyCart(String product1, String product2) {
        homePage = new HomePage(driver);
        Product productmodel1;
        Product productmodel2;

        shopPage = homePage.clickShopTxt()
                           .clickBuyBtnByProduct(product1)
                           .clickBuyBtnByProduct(product1)
                           .clickBuyBtnByProduct(product2);

        checkoutPage=shopPage.clickCartTxt();

        if(checkoutPage.verifyCheckOutBtnDisplay()) {
            productmodel1 = checkoutPage.getProductDetails(product1);
            productmodel2 = checkoutPage.getProductDetails(product2);
            Assert.assertEquals(productmodel1.getProductname(), product1, "Verify that the Product 1 has been added into the cart correctly");
            Assert.assertEquals(productmodel2.getProductname(), product2, "Verify that the Product 2 has been added into the cart correctly");

            double product1SinglePrice = Double.valueOf(productmodel1.getProductsingleprice().replaceAll("\\$", ""));
            double product1Subtotal = product1SinglePrice * 2;
            Assert.assertEquals(productmodel1.getProducttotalprice().replaceAll("\\$", ""), String.valueOf(product1Subtotal), "verify that the subtotal for product 1 is correct");

            double product2SinglePrice = Double.valueOf(productmodel2.getProductsingleprice().replaceAll("\\$", ""));
            double product2Subtotal = product2SinglePrice;
            Assert.assertEquals(productmodel2.getProducttotalprice().replaceAll("\\$", ""), String.valueOf(product2Subtotal), "verify that the subtotal for product 2 is correct");
        }
    }
}
