package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends ParentPage {

    public FirstPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@class='fa fa-lock']")
    private WebElement lockAuth;

    @FindBy(xpath = ".//*[@class='fa fa-unlock']")
    private WebElement unLockAuth;

    @Step
    public void openFirstPage() {
        try {
            webDriver.get("https://zarulim.com.ua");
            logger.info("First page to site Zarulim was open");
        } catch (Exception e) {
            logger.info("Can not open first page to site Zarulim " + e);
            Assert.fail("Can not open first page to site Zarulim " + e);
        }
    }

    @Step
    public boolean isLockAuthPresent() {
        return actionsWithOurElements.isElementPresent(lockAuth);
    }

    @Step
    public boolean isUnLockAuthPresent() {
        return actionsWithOurElements.isElementPresent(unLockAuth);
    }

    @Step
    public void clickToEnterOrReg(String login) {
        actionsWithOurElements.clickOnElement(lockAuth);
    }

    @Step
    public void clickToMyProfile(String login) {
        actionsWithOurElements.clickOnElement(unLockAuth);
    }


}


