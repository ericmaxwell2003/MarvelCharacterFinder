package software.credible.mcfinder.guice;

import javax.inject.Provider;

import software.credible.mcfinder.BuildConfig;

public class AppPropertiesProvider implements Provider<AppProperties> {

    @Override
    public AppProperties get() {
        AppProperties appProperties = new AppProperties();
        appProperties.marvelApiEndpoint = BuildConfig.MARVEL_API_ENDPOINT;
        appProperties.marvelApiKey = BuildConfig.MARVEL_API_KEY;
        appProperties.marvelApiReferrer = BuildConfig.MARVEL_API_REFERRER;
        return appProperties;
    }

}
