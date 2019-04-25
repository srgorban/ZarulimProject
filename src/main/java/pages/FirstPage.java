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

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/a/span/i")
    private WebElement zamokOpen;

    @FindBy(xpath = ".//a[@class='logo']")
    private WebElement logo;

    @FindBy(xpath = "//*[@id=\"modal-login\"]/div/div/div[3]/ul[2]/li[3]/a")
    private WebElement actionLogout;

    @FindBy(xpath = ".//div[@id='modal-login' and @style='display: block; padding-right: 17px;' and @class='modal fade in']")
    private WebElement modalWindowAuthOpened;

    @FindBy(xpath = ".//button[@type='button' and @class='close']")
    private WebElement closeButtonModalWindowAuth;

    @FindBy(xpath = ".//input[@id='login_name']")
    private WebElement inputLogin;

    @FindBy(xpath = ".//input[@id='login_password']")
    private WebElement inputPass;

    @FindBy(xpath = "//*[@id=\"modal-login\"]/div/div/div[2]/div/form/div[1]/button/span")
    private WebElement button;

    @Step
    public boolean isLogoPresent() {
        return actionsWithOurElements.isElementPresent(logo);
    }

    @Step
    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    @Step
    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);
    }

    @Step
    public void clickButtonLoginSubmit() {
        actionsWithOurElements.clickOnElement(button);
    }

    @Step
    public void clickActionLogout() {
        actionsWithOurElements.clickOnElement(actionLogout);
    }

    @Step
    public void clickCloseModalWindowAuth() {
        actionsWithOurElements.clickOnElement(closeButtonModalWindowAuth);
    }

    @Step
    public void clickMyProfile() {
        actionsWithOurElements.clickOnElement(zamokOpen);
    }

    @Step
    public void clickLoginRegister() {
        actionsWithOurElements.clickOnElement(zamokClosed);
    }

    @Step
    public boolean isModalWindowPresent() {
        return actionsWithOurElements.isElementPresent(modalWindowAuthOpened);
    }

    @Step
    public boolean isZamokOpenPresent() {
        return actionsWithOurElements.isElementPresent(zamokOpen);
    }

    @Step
    public boolean isZamokClosedPresent() {
        return actionsWithOurElements.isElementPresent(zamokClosed);
    }

    @Step
    public void openFirstPage() {
        try {
            webDriver.get("https://zarulim.com.ua");
            logger.info("First page to site 'Zarulim' was opened");
        } catch (Exception e) {
            logger.info("Can't open first page to site 'Zarulim' " + e);
            Assert.fail("Can't open first page to site 'Zarulim' " + e);
        }
    }

    @Step
    public void openModalWindowAuth() {
        if (!zamokClosed.isDisplayed()) {
            try {
                logout();
                logger.info("Was logout account");
            } catch (Exception e) {
                logger.info("Smth happened when trying logout " + e);
                Assert.fail("Smth happened when trying logout " + e);
            }
        } else if (zamokClosed.isDisplayed()) {
            try {
                clickLoginRegister();
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
    public void openModalWindowMyProfile() {
        if (!zamokOpen.isDisplayed()) {
            try {
                login("superadmin", "666666");
                logger.info("Was login account");
            } catch (Exception e) {
                logger.info("Smth happened when trying login " + e);
                Assert.fail("Smth happened when trying login " + e);
            }
        } else if (zamokOpen.isDisplayed()) {
            try {
                clickMyProfile();
                logger.info("'My Profile' was clicked");
            } catch (Exception e) {
                logger.info("Smth happened when you click 'My Profile' " + e);
                Assert.fail("Smth happened when you click 'My Profile' " + e);
            }
        } else {
            logger.error("Smth happened. Can't open the modal window 'Auth' or 'My profile'");
            Assert.fail("Smth happened. Can't open the modal window 'Auth' or 'My profile'");
        }
    }

    @Step
    public void closeModalWindowAuth() {
        try {
            clickCloseModalWindowAuth();
            logger.info("Was click 'X' in modal window 'Auth'");
        } catch (Exception e) {
            logger.info("Smth happened when you click 'X' in modal window 'Auth' " + e);
            Assert.fail("Smth happened when you click 'X' in modal window 'Auth' " + e);
        }
    }

    @Step
    public void logout() {
        openModalWindowMyProfile();
        logger.info("Was opened the modal window 'My profile'");
        try {
            clickActionLogout();
            logger.info("'Logout' was clicked in modal window 'My Profile'");
        } catch (Exception e) {
            logger.info("Smth happened when you click 'Logout' in modal window 'My Profile' " + e);
            Assert.fail("Smth happened when you click 'Logout' in modal window 'My Profile' " + e);
        }
    }

    @Step
    public void login(String login_name, String password) {
        openFirstPage();
        openModalWindowAuth();
        enterTextInToInputLogin(login_name);
        enterTextInToInputPass(password);
        clickButtonLoginSubmit();
        logger.info("'Login' was clicked in modal window 'Auth'");
    }
}

