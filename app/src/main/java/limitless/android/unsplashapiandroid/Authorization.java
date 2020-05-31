package limitless.android.unsplashapiandroid;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import first.voyger.unsplash.Api.Endpoints.AuthorizationEndpoints;
import first.voyger.unsplash.Api.Model.Token;
import first.voyger.unsplash.Api.Enum.Scope;
import first.voyger.unsplash.Listeners.UnsplashListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Authorization {

    private String baseUrl = "https://unsplash.com/oauth/";
    private String authorizeUrl = "https://unsplash.com/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=%s&scope=%s";

    private String accessKey;
    private String secretKey;
    private String callback;

    private AuthorizationEndpoints authService;

    /**
     * Load from res folder
     * @param context
     * @param accessId res id for access key
     * @param secretId res id for secret key
     * @param callbackId res id for callback
     */
    public Authorization(@NonNull Context context, @StringRes int accessId, @StringRes int secretId, @StringRes int callbackId){
        this(context.getString(accessId), context.getString(secretId), context.getString(callbackId));
    }

    /**
     * @param accessKey
     * @param secretKey
     * @param callback
     */
    public Authorization(@NonNull String accessKey, @NonNull String secretKey, @NonNull String callback){
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.callback = callback;
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authService = retrofit.create(AuthorizationEndpoints.class);
    }

    public String loginUrl(@Nullable String responseType, @NonNull Scope[] scopes){
        StringBuilder s = new StringBuilder();
        for (Scope scope : scopes) {
            s.append(scope.getScope()).append("+");
        }
        s.deleteCharAt(s.lastIndexOf("+"));
        if (responseType == null)
            responseType = "code";
        return String.format(authorizeUrl, accessKey, callback, responseType, s.toString());
    }

    public void getToken(@NonNull String code, @NonNull final UnsplashListener<Token> tokenListener){
        authService.token(accessKey, secretKey, callback, code, "authorization_code").enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                tokenListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                tokenListener.error(t.getMessage());
            }
        });
    }

}
