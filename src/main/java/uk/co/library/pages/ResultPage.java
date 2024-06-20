package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {

    /*
    Locators - resultText
  Method - verifyTheResults(String expected)

     */
    @CacheLookup
    @FindBy(css = ".search-header__title")
    WebElement resultText;

    public String verifyResult() {
        return getTextFromElement(resultText);
    }

    //cookies
    @CacheLookup
    @FindBy(xpath = "//button[@id='save']/span/div/span[text()='Accept All']")
    WebElement acceptCookies;

    public void accpetCookies() {
        driver.switchTo().frame("gdpr-consent-notice");
        clickOnElement(acceptCookies);
        driver.switchTo().defaultContent();
    }
}