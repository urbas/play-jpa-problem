import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import play.db.jpa.JPA;
import play.test.FakeApplication;
import play.test.Helpers;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.HashMap;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.stop;


/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 */
public class ApplicationTest {

    public static final String TEST_PERSISTENCE_UNIT = "testPersistenceUnit";
    public static final String APP_CONFIG_JPA_DEFAULT = "jpa.default";

    private final HashMap<String, String> applicationOptions = new HashMap<>();
    private FakeApplication fakeApplication;

    @After
    public void close() {
        stop(fakeApplication);
    }

    private void configureInMemoryTestDatabase() {
        applicationOptions.putAll(inMemoryDatabase());
        applicationOptions.put(APP_CONFIG_JPA_DEFAULT, TEST_PERSISTENCE_UNIT);
    }

    @Before
    public void setUp() {
        configureInMemoryTestDatabase();
        fakeApplication = fakeApplication(applicationOptions);
        Helpers.start(fakeApplication);
    }

    @Test
    public void the_meta_model_must_contain_the_message_entity() {
        EntityManager entityManager = JPA.em("default");
        Metamodel metamodel = entityManager.getMetamodel();
        boolean foundMessageEntity = false;
        for (EntityType<?> entityType : metamodel.getEntities()) {
            if (entityType.getName().equals("Message")) {
                foundMessageEntity = true;
            }
            System.out.println("Found entity: " + entityType.getName());
        }
        Assert.assertTrue("The meta model must contain the 'Message' entity.", foundMessageEntity);
    }


}
