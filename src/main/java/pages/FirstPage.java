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

    @FindBy(xpath = ".//i[@class='fa fa-lock']")
    private WebElement zamokClosed;

    @FindBy(xpath = ".//i[@class='fa fa-unlock']")
    private WebElement zamokOpen;

    @FindBy(xpath = ".//a[@class='logo']")
    private WebElement logo;

    @FindBy(xpath = ".//*[@class='fa fa-times']")
    private WebElement logOut;

    @FindBy(xpath = ".//div[@id='modal-login' and @style='display: block; padding-right: 17px;' and @class='modal fade in']")
    private WebElement modalWindowAuthOpened;

    @FindBy(xpath = ".//button[@type='button' and @class='close']")
    private WebElement closeButtonModalWindowAuth;

    @FindBy(xpath = ".//input[@id='login_name']")
    private WebElement inputLogin;

    @FindBy(xpath = ".//input[@id='login_password']")
    private WebElement inputPass;

    @FindBy(xpath = "//*[@id=\"modal-login\"]/div/div/div[2]/div/form/div[1]/button")
    private WebElement button;

    @FindBy(xpath = "//*[@id=\"modal-login\"]/div/div/div[2]/div[1]/a/img")
    private WebElement avatar;

    @Step
    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    @Step
    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);
    }

    @Step
    public void clickOnButtonSubmit() {
        actionsWithOurElements.clickOnElement(button);
    }

    @Step
    public boolean isLogoPresent() {
        return actionsWithOurElements.isElementPresent(logo);
    }

    @Step
    public boolean isModalWindowPresent() {
        return actionsWithOurElements.isElementPresent(modalWindowAuthOpened);
    }

    @Step
    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(avatar);
    }

    @Step
    public void openFirstPage() {
        try {
            webDriver.get("https://zarulim.com.ua");
            logger.info("First page to site 'Zarulim' was opened");
        } catch (Exception e) {
            logger.info("Can't open first page to site Zarulim " + e);
            Assert.fail("Can't open first page to site Zarulim " + e);
        }
    }

    @Step
    public void openModalWindowAuth() {
        if (!zamokClosed.isDisplayed()) {
            try {
                logout();
            } catch (Exception e) {
                logger.info("Smth happened when trying logout " + e);
                Assert.fail("Smth happened when trying logout " + e);
            }
        } else if (zamokClosed.isDisplayed()) {
            try {
                zamokClosed.click();
                logger.info("'Login/Register' was clicked");
            } catch (Exception e) {
                logger.info("Smth happened when you click 'Login/Register' " + e);
                Assert.fail("Smth happened when you click 'Login/Register' " + e);
            }
        } else {
            logger.error("Smth happened. Can't open the modal window 'Auth' or 'My profile'");
            Assert.fail("Smth happened. Can't open the modal window 'Auth' or 'My profile'");
        }
    }

    @Step
    public void closeModalWindowAuth() {
        try {
            closeButtonModalWindowAuth.click();
            logger.info("Button 'X' was clicked");
        } catch (Exception e) {
            logger.info("Smth happened when you click 'X' to modal window Auth " + e);
            Assert.fail("Smth happened when you click 'X' to modal window Auth " + e);
        }
    }

    @Step
    public void logout() {
        try {
            logOut.click();
            logger.info("Button 'Logout' was clicked");
        } catch (Exception e) {
            logger.info("Smth happened when you click 'Logout' " + e);
            Assert.fail("Smth happened when you click 'Logout' " + e);
        }
    }

    @Step
    public void login(String login_name, String password) {
        openFirstPage();
        openModalWindowAuth();
        enterTextInToInputLogin(login_name);
        enterTextInToInputPass(password);
        clickOnButtonSubmit();
    }
}


