package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class BasePage {

    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForPageComponentLoadFluentWait(WebElement element) {

        FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, TimeoutException.class);

        for (int i = 0; i < 10; i++) {
            try {
                fWait.until(ExpectedConditions.visibilityOf(element));
                fWait.until(ExpectedConditions.elementToBeClickable(element));
            }
            catch (Exception e) {
                System.out.println("Element Not found trying again - " + element.toString());
                e.printStackTrace();
            }
        }
        return element;
    }

    public String getText(WebElement element, String comment) {
        String text = "";
        try {
            text = element.getText().trim();
        } catch (Exception e) {
            System.out.println("Element Not found trying again - " + element.toString());
            e.printStackTrace();
        }
        return text;
    }
}
