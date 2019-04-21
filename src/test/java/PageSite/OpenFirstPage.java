package PageSite;


import org.junit.Test;
import parentTest.ParentTest;

public class OpenFirstPage extends ParentTest {

    @Test
    public void openSite() {
        firstPage.openFirstPage();
        checkExpectedResult(
                "Site is present",
                firstPage.isLogoPresent()
        );
    }

    @Test
    public void modalWindowAuthIsOpened() {
        firstPage.openFirstPage();
        firstPage.openModalWindowAuth();
        checkExpectedResult(
                "Modal window is present after opening",
                firstPage.isModalWindowPresent()
        );
    }

    @Test
    public void modalWindowAuthIsClosed() {
        firstPage.openFirstPage();
        firstPage.openModalWindowAuth();
        firstPage.closeModalWindowAuth();
        checkExpectedResult(
                "Modal window is not present after closing",
                !firstPage.isModalWindowPresent()
        );
    }

    @Test
    public void validLogin() {
        firstPage.openFirstPage();
        firstPage.openModalWindowAuth();
        checkExpectedResult(
                "Modal window is present after opening",
                firstPage.isModalWindowPresent()
        );
    }

}