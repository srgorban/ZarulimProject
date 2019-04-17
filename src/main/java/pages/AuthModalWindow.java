package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthModalWindow extends ParentPage {

    public AuthModalWindow(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@class='fa fa-lock']")
    private WebElement authLockClosed;

    @FindBy(xpath = ".//*[@class='fa fa-unlock']")
    private WebElement authLockOpen;

    @Step
    public boolean isAuthLockClosedPresent() {
        return actionsWithOurElements.isElementPresent(authLockClosed);
    }

//    @Step
//    public void goToThisWindow() {
//        FirstPage firstPage = new FirstPage(webDriver);
//
//        firstPage.login("Student", "909090");
//        Assert.assertEquals("Avatar is not present"
//                , true, isAuthLockClosedPresent()
//        );
//    }
//
//    @Step
//    public void clickOnButtonSubmit() {
//        actionsWithOurElements.clickOnElement(button);
//    }
//
//    @Step
//    public void login(String invalidLogin, String password) {
//        openFirstPage();
//        enterTextInToInputLogin(invalidLogin);
//        enterTextInToInputPass(password);
//        clickOnButtonSubmit();
//    }
//
//    @Step
//    public void clickOnMenuDictionary() {
//        actionsWithOurElements.clickOnElement(menuDictionary);
//    }
//
//    @Step
//    public void clickOnsubMenuSpare() {
//        actionsWithOurElements.clickOnElement(subMenuSpare);
//    }

}