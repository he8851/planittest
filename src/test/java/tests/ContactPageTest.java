package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactPageTest extends TestBase{
    HomePage homePage;
    ContactPage contactPage;

    public ContactPageTest(){ super(); }

    @DataProvider(name = "valid_user")
    public Object[][] userData() {
        return new String[][]{
                {"Joseph", "joseph@abc.com", "Planit Test"}
        };
    }

    @DataProvider(name = "invalid_user")
    public Object[][] invalidUserData() {
        return new String[][]{
                {"abc"}
        };
    }

    @Test (priority = 1, description = "Test Case 1", dataProvider = "valid_user")
     public void verifyErrorMessage(String forename, String email, String message){
        homePage = new HomePage(driver);
        contactPage= homePage.clickContactTxt().clickOnSubmitBtn();
        Assert.assertEquals("Forename is required", contactPage.getForenameMessage());
        Assert.assertEquals("Email is required",contactPage.getEmailErr());
        Assert.assertEquals("Message is required",contactPage.getMessageErr());

        contactPage.inputForename(forename);
        Assert.assertFalse(contactPage.verifyForenameErrDisplay());

        contactPage.inputEmailTxt(email);
        Assert.assertFalse(contactPage.verifyEmailErrDisplay());

        contactPage.inputMessageTxt(message);
        Assert.assertFalse(contactPage.verifyMessageErrDisplay());


    }

    @Test (priority = 2, description = "Test Case 2", dataProvider = "valid_user")
    public void verifySubmitMessage(String forename, String email, String message){
        homePage = new HomePage(driver);
        contactPage= homePage.clickContactTxt()
                .inputForename(forename)
                .inputEmailTxt(email)
                .inputMessageTxt(message)
                .clickOnSubmitBtn();

        Assert.assertEquals("Thanks "+forename+", we appreciate your feedback.", contactPage.getSubmitSuccessTxt(),"Verify that the feedback is successfully submitted");
    }

    @Test (priority = 3, description = "Test Case 3", dataProvider = "invalid_user")
    public void verifyInvalidEmail(String invalidemail){
        homePage = new HomePage(driver);
        contactPage= homePage.clickContactTxt()
                .inputEmailTxt(invalidemail);

        Assert.assertEquals("Please enter a valid email", contactPage.getEmailErr(),"Verify that the invalid message is displayed");
    }
}
