package limitless.android.unsplash.Api.Endpoints;

import limitless.android.unsplash.Api.Enum.Color;
import limitless.android.unsplash.Api.Enum.ContentFilter;
import limitless.android.unsplash.Api.Enum.Orientation;
import limitless.android.unsplash.Api.Enum.SearchOrder;
import limitless.android.unsplash.Api.Model.Collection;
import limitless.android.unsplash.Api.Model.Photo;
import limitless.android.unsplash.Api.Model.SearchResults;
import limitless.android.unsplash.Api.Model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchEndpoints {

    /**
     * Get a single page of photo results for a query.
     * @param query Search terms.
     * @param page 	Page number to retrieve. (Optional; default: 1
     * @param perPage Number of items per page. (Optional; default: 10)
     * @param orderBy How to sort the photos. (Optional; default: relevant). {@link SearchOrder}
     * @param collections How to sort the photos. (Optional; default: relevant). Valid values are latest and relevant.
     * @param contentFilter Limit results by content safety. (Optional; default: low). {@link ContentFilter}
     * @param color Filter results by color. Optional. {@link Color}
     * @param orientation Filter by photo orientation. Optional. {@link Orientation}
     * @return The photo objects returned here are abbreviated. For full details use {@link PhotosEndpoints#getPhoto(String)}
     */
    @GET("search/photos")
    Call<SearchResults<Photo>> searchPhotos(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("order_by") String orderBy,
            @Query("collections") String collections,
            @Query("content_filter") String contentFilter,
            @Query("color") String color,
            @Query("orientation") String orientation
    );

    /**
     * Get a single page of collection results for a query.
     * @param query Search terms.
     * @param page Page number to retrieve. (Optional; default: 1)
     * @param perPage Number of items per page. (Optional; default: 10)
     * @return A list collections. {@link Collection}
     */
    @GET("search/collections")
    Call<SearchResults<Collection>> searchCollections(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    /**
     * Get a single page of user results for a query.
     * @param query Search terms.
     * @param page Page number to retrieve. (Optional; default: 1)
     * @param perPage Number of items per page. (Optional; default: 10)
     * @return A list of users. {@link User}
     */
    @GET("search/users")
    Call<SearchResults<User>> searchUsers(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int perPage
    );

}
