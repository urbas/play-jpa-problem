import play.test.FakeApplication;
import play.test.Helpers;

import java.lang.AutoCloseable;import java.lang.Override;import java.lang.String;import java.util.HashMap;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.stop;

public class FakePlayApplication implements AutoCloseable {

    public static final String TEST_PERSISTENCE_UNIT = "testPersistenceUnit";
    public static final String APP_CONFIG_JPA_DEFAULT = "jpa.default";

    private final HashMap<String, String> applicationOptions = new HashMap<>();
    private final FakeApplication fakeApplication;

    public FakePlayApplication() {
        configureInMemoryTestDatabase();
        fakeApplication = fakeApplication(applicationOptions);
        Helpers.start(fakeApplication);
    }

    @Override
    public void close() {
        stop(fakeApplication);
    }

    private void configureInMemoryTestDatabase() {
        applicationOptions.putAll(inMemoryDatabase());
        applicationOptions.put(APP_CONFIG_JPA_DEFAULT, TEST_PERSISTENCE_UNIT);
    }
}
