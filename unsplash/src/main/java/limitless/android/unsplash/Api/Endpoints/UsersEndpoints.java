package limitless.android.unsplash.Api.Endpoints;

import java.util.List;

import limitless.android.unsplash.Api.Model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UsersEndpoints {

    @GET("users/")
    Call<User> getUser(
            @Query("username") String userName
    );

    @GET("users/{username}/portfolio")
    Call<Download> getPortfolio(
            @Path("username") String userName
    );

    @GET("users/{username}/photos")
    Call<List<Photo>> getUserPhotos(
            @Path("username") String userName,
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("order_by") int orderBy,
            @Query("stats") boolean stats,
            @Query("resolution") String resolution,
            @Query("quantity") String quantity,
            @Query("orientation") String orientation
    );

    @GET("users/{username}/likes")
    Call<List<Photo>> getLikesPhotos(
            @Path("username") String username,
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("order_by") String orderBy,
            @Query("orientation") String orientation
    );

    @GET("users/{username}/collections")
    Call<List<Collection>> getUserCollections(
            @Path("username") String username,
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    @GET("users/{username}/statistics")
    Call<Statistics> getUserStatistics(
            @Path("username") String username,
            @Query("resolution") String resolution,
            @Query("quantity") String quantity
    );

}
