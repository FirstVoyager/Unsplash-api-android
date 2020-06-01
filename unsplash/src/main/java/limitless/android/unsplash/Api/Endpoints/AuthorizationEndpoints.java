package limitless.android.unsplash.Api.Endpoints;

import limitless.android.unsplash.Api.Model.Token;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthorizationEndpoints {

    @GET("authorize")
    Call<String> authorize(
            @Query("client_id") String clientID,
            @Query("redirect_uri") String callback,
            @Query("response_type") String responseType,
            @Query("scope") String scope);

    @POST("token")
    Call<Token> token(
            @Query("client_id") String clientID,
            @Query("client_secret") String clientSecret,
            @Query("redirect_uri") String callback,
            @Query("code") String code,
            @Query("grant_type") String grantType // def authorization_code
    );

}
