package software.credible.mcfinder.software.credible.mcfinder.remote;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.google.inject.AbstractModule;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.After;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;

import roboguice.RoboGuice;
import roboguice.util.Ln;
import software.credible.mcfinder.R;
import software.credible.mcfinder.guice.AppProperties;
import software.credible.mcfinder.guice.MarvelRemoteApiProvider;
import software.credible.mcfinder.remote.MarvelRemoteApi;
import software.credible.mcfinder.remote.dto.MarvelResultWrapper;

public class MarvelRemoteApiTest extends ApplicationTestCase<Application> {

    @Inject
    private MarvelRemoteApi marvelRemoteApi;

    private AppProperties testAppProperties;
    private MockWebServer mockWebServer;

    public MarvelRemoteApiTest() {
        super(Application.class);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();

        createApplication();

        mockWebServer = new MockWebServer();
        mockWebServer.start();

        testAppProperties = new AppProperties();
        testAppProperties.marvelApiReferrer = "test-referrer";
        testAppProperties.marvelApiKey = "test-api-key";
        testAppProperties.marvelApiEndpoint = mockWebServer.getUrl("/").toString();

        RoboGuice.overrideApplicationInjector(getApplication(), new TestModule()).injectMembers(this);
    }

    @After
    @Override
    public void tearDown() throws Exception {
        RoboGuice.Util.reset();
        super.terminateApplication();
        super.tearDown();
    }

    public void testAuthenticationResponseParsesCorrectly() throws Exception {

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(loadJsonTestData(R.raw.fetch_all_characters_test_response)));

        MarvelResultWrapper resultWrapper = marvelRemoteApi.fetchAllCharacters();

        fail("Finish expectations");

        shutdownMockWebServer();
    }


    public void testAuthenticationRequirementsPresent() throws Exception {

        mockWebServer.enqueue(new MockResponse().setResponseCode(200));

        marvelRemoteApi.fetchAllCharacters();

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals(testAppProperties.marvelApiReferrer, request.getHeader("Referer"));
        assertUrlParameterValue(request.getRequestLine(), "apikey", testAppProperties.marvelApiKey);

        shutdownMockWebServer();
    }

    private String loadJsonTestData(int resourceId) {

        StringBuilder testData = new StringBuilder();

        try {
            InputStream is =getApplication().getResources().openRawResource(resourceId);
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = r.readLine()) != null) {
                testData.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData.toString();
    }

    private void assertUrlParameterValue(String requestLine, String paramName, String paramValue) {
        String lookForString = String.format("%s=%s", paramName, paramValue);
        assertTrue(requestLine.contains(lookForString));
    }

    private void shutdownMockWebServer() {
        try {
            if (mockWebServer != null) {
                mockWebServer.shutdown();
                mockWebServer = null;
            }
        } catch (IOException e) {
            Ln.e(e, e.getMessage());
        }
    }

    private class TestModule extends AbstractModule {
        @Override
        protected void configure() {


            MarvelRemoteApiProvider testMarvelRemoteApiProvider = new MarvelRemoteApiProvider();
            testMarvelRemoteApiProvider.appProperties = testAppProperties;

            bind(MarvelRemoteApi.class).toInstance(testMarvelRemoteApiProvider.get());
        }
    }


}
