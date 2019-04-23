package suiteCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pageSite.OpenFirstPage;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                OpenFirstPage.class,
        }
)

public class LoginSuiteCase {
}
