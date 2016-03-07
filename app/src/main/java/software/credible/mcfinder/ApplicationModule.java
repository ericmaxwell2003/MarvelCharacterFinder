package software.credible.mcfinder;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import software.credible.mcfinder.remote.MarvelRemoteApi;
import software.credible.mcfinder.remote.ServiceGenerator;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    public MarvelRemoteApi marvelServiceProvider() {
        try {
            return ServiceGenerator.createService(MarvelRemoteApi.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
