package software.credible.mcfinder.remote;

import android.app.DownloadManager;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import software.credible.mcfinder.BuildConfig;

public class ServiceGenerator {

    public static <S> S createService(Class<S> serviceClass, String url, RequestInterceptor requestInterceptor) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(url)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(new OkHttpClient()))
                .setRequestInterceptor(requestInterceptor)
                .build();
        return adapter.create(serviceClass);
    }

}