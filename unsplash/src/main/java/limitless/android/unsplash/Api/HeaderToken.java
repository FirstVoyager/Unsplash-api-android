package limitless.android.unsplash.Api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderToken implements Interceptor {

    public String token;

    public HeaderToken(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request
                .newBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(request);
    }

}
