import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 */
public class ApplicationTest {


    private FakePlayApplication fakePlayApplication;

    @Before
    public void setUp() throws Exception {
        fakePlayApplication = new FakePlayApplication();
    }

    @Test
    public void adding_a_user_to_the_database() {
        System.out.println("Hello world!");
    }

    @After
    public void tearDown() throws Exception {
        fakePlayApplication.close();
    }


}
