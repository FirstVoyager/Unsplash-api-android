package limitless.android.unsplashapiandroid.Api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderPublic implements Interceptor {

    private String apiKey;

    public HeaderPublic(String apiKey){
        this.apiKey = apiKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request
                .newBuilder()
                .addHeader("Authorization", "Client-ID " + apiKey)
                .build();
        return chain.proceed(request);
    }

}
