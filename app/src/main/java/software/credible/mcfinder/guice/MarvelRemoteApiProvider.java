package software.credible.mcfinder.guice;

import javax.inject.Inject;
import javax.inject.Provider;

import retrofit.RequestInterceptor;
import software.credible.mcfinder.remote.MarvelRemoteApi;
import software.credible.mcfinder.remote.ServiceGenerator;

public class MarvelRemoteApiProvider implements Provider<MarvelRemoteApi> {

    @Inject
    public AppProperties appProperties;

    @Override
    public MarvelRemoteApi get() {
        try {
            return ServiceGenerator.createService(MarvelRemoteApi.class, appProperties.marvelApiEndpoint, marvelRequestInterceptor(appProperties));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected RequestInterceptor marvelRequestInterceptor(final AppProperties appProperties) {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {
                request.addQueryParam("apikey", appProperties.marvelApiKey);
                request.addHeader("Referer", appProperties.marvelApiReferrer);
            }
        };
    }

}
