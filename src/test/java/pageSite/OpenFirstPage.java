package pageSite;

import org.junit.Test;
import parentTest.ParentTest;

public class OpenFirstPage extends ParentTest {

    @Test
    public void openSite() {
        firstPage.openFirstPage();
        checkExpectedResult(
                "Site is not present",
                firstPage.isLogoPresent()
        );
    }

    @Test
    public void modalWindowAuthIsOpened() {
        firstPage.openFirstPage();
        firstPage.openModalWindowAuth();
        checkExpectedResult(
                "Modal window is not present after opening",
                firstPage.isModalWindowPresent()
        );
    }

    @Test
    public void modalWindowAuthIsClosed() {
        firstPage.openFirstPage();
        firstPage.openModalWindowAuth();
        firstPage.closeModalWindowAuth();
        checkExpectedResult(
                "Modal window is present after closing",
                !firstPage.isModalWindowPresent()
        );
    }

    @Test
    public void enterWithValidLogin() {
        firstPage.openFirstPage();
        firstPage.openModalWindowAuth();
        firstPage.enterTextInToInputLogin("superadmin");
        firstPage.enterTextInToInputPass("666666");
        firstPage.clickButtonLoginSubmit();
        checkExpectedResult(
                "Picture 'Open lock' is not present",
                firstPage.isZamokOpenPresent()
        );
    }

    @Test
    public void correctLogout() {
        firstPage.login("superadmin", "666666");
        firstPage.logout();
        checkExpectedResult(
                "Picture 'Closed lock' is not present",
                firstPage.isZamokClosedPresent()
        );
    }
}