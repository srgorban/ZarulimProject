package OpenPage;

import org.junit.Test;
import parentTest.ParentTest;

public class OpenFirstPage extends ParentTest {

    @Test
    public void openFirstPage() {

        firstPage.openFirstPage();
        checkExpectedResult(
                "Page is not present",
                firstPage.isLockAuthPresent()
        );
    }
}
