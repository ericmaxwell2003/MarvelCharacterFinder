package software.credible.mcfinder.guice;

import com.google.inject.AbstractModule;

import javax.inject.Singleton;

import software.credible.mcfinder.remote.MarvelRemoteApi;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MarvelRemoteApi.class).toProvider(MarvelRemoteApiProvider.class).in(Singleton.class);
    }

}
