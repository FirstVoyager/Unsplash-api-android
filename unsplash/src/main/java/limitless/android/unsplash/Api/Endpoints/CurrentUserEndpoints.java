package limitless.android.unsplash.Api.Endpoints;

import limitless.android.unsplash.Api.Model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface CurrentUserEndpoints {

    @GET("me")
    Call<User> getMe();

    @PUT("me")
    Call<User> updateMe(
            @Query("username") String userName,
            @Query("first_name") String firstName,
            @Query("last_name") String lastName,
            @Query("email") String email,
            @Query("url") String url,
            @Query("location") String location,
            @Query("bio") String bio,
            @Query("instagram_username") String instaId
    );

}
