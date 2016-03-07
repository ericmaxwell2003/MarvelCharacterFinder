package software.credible.mcfinder.remote;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import software.credible.mcfinder.BuildConfig;

public class ServiceGenerator {

    public static <S> S createService(Class<S> serviceClass) {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BuildConfig.MARVEL_API_ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL);

        builder.setClient(new OkClient(new OkHttpClient()));
        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addQueryParam("apikey", BuildConfig.MARVEL_API_KEY);
                request.addHeader("Referer", BuildConfig.MARVEL_API_REFERRER);
            }
        });
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

}