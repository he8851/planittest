package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    private static final String loc_ForenameErr ="#forename-err";
    private static final String loc_EmailErr="#email-err";
    private static final String loc_MessageErr="#message-err";
    private static final String loc_ForenameTxt="input#forename";
    private static final String loc_EmailTxt="input#email";
    private static final String loc_MessageTxt="textarea#message";
    private static final String loc_SuccessTxt="strong.ng-binding";
    private static final String loc_SubmitSuccessTxt=".alert";
    private static final String loc_SubmitBtn ="//*[.='Submit']";

    @FindBy(css=loc_ForenameErr)
    private WebElement forenameErr;

    @FindBy(css =loc_EmailErr)
    private WebElement emailErr;

    @FindBy(css=loc_MessageErr)
    private WebElement messageErr;

    @FindBy(css=loc_ForenameTxt)
    private WebElement forenameTxt;

    @FindBy(css =loc_EmailTxt)
    private WebElement emailTxt;

    @FindBy(css=loc_MessageTxt)
    private WebElement messageTxt;

    @FindBy(css=loc_SuccessTxt)
    private WebElement successTxt;

    @FindBy(css=loc_SubmitSuccessTxt)
    private WebElement submitSuccessTxt;

    @FindBy(xpath=loc_SubmitBtn)
    private WebElement submitBtn;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailErr(){
        return emailErr.getText();
    }

    public String getForenameMessage(){
        return forenameErr.getText();
    }

    public String getMessageErr(){
        return messageErr.getText();
    }

    public String getSubmitSuccessTxt() {
        waitForPageComponentLoadFluentWait(successTxt);
        return submitSuccessTxt.getText();
    }

    public boolean verifyForenameErrDisplay(){
        if(driver.findElements(By.cssSelector(loc_ForenameErr)).size()!=0){
            return forenameErr.isDisplayed();
        }
        else{
            return false;
        }
    }

    public boolean verifyEmailErrDisplay(){
        if(driver.findElements(By.cssSelector(loc_EmailErr)).size()!=0){
            return emailErr.isDisplayed();
        }
        else{
            return false;
        }
    }

    public boolean verifyMessageErrDisplay(){
        if(driver.findElements(By.cssSelector(loc_MessageErr)).size()!=0){
            return messageErr.isDisplayed();
        }
        else{
            return false;
        }
    }

    public ContactPage inputForename(String forename){
        forenameTxt.clear();
        forenameTxt.sendKeys(forename);
        return this;
    }

    public ContactPage inputEmailTxt(String email){
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public ContactPage inputMessageTxt(String message){
        messageTxt.clear();
        messageTxt.sendKeys(message);
        return this;
    }

    public ContactPage clickOnSubmitBtn(){
        submitBtn.click();
        return this;
    }

}
