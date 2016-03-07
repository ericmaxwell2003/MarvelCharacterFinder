package software.credible.mcfinder.software.credible.mcfinder.remote;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.junit.After;
import org.junit.Before;

import software.credible.mcfinder.remote.MarvelRemoteApi;
import software.credible.mcfinder.remote.ServiceGenerator;
import software.credible.mcfinder.remote.dto.MarvelResultWrapper;

public class MarvelRemoteApiTest  extends ApplicationTestCase<Application> {

    private MarvelRemoteApi marvelRemoteApi;

    public MarvelRemoteApiTest() {
        super(Application.class);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        createApplication();
        super.setUp();
        marvelRemoteApi = ServiceGenerator.createService(MarvelRemoteApi.class);
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.terminateApplication();
        super.tearDown();
    }

    public void testCanRetrieve20ResultsUsingDefaultParameters() {
        MarvelResultWrapper marvelResultWrapper = marvelRemoteApi.fetchAllCharacters();
        assertNotNull(marvelResultWrapper);
        assertNotNull(marvelResultWrapper.getData());
        assertEquals(Integer.valueOf(20), marvelResultWrapper.getData().getCount());
    }

}
