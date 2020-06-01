package limitless.android.unsplash.Api.Endpoints;

import java.util.List;

import limitless.android.unsplash.Api.Enum.ContentFilter;
import limitless.android.unsplash.Api.Enum.Order;
import limitless.android.unsplash.Api.Enum.Orientation;
import limitless.android.unsplash.Api.Enum.Scope;
import limitless.android.unsplash.Api.Model.ActionLike;
import limitless.android.unsplash.Api.Model.Download;
import limitless.android.unsplash.Api.Model.Photo;
import limitless.android.unsplash.Api.Model.Statistics;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PhotosEndpoints {

    /**
     * Get a single page from the list of all photos
     * @param page Page number to retrieve. (Optional; default: 1)
     * @param perPage Number of items per page. (Optional; default: 10)
     * @param orderBy How to sort the photos. Optional. {@link Order}
     * @return The photo objects returned here are abbreviated. For full details use {@link #getPhoto(String)}
     */
    @GET("photos")
    Call<List<Photo>> getPhotos(
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("order_by") String orderBy
    );

    /**
     * Retrieve a single photo.
     * @param id The photo’s ID. Required.
     * @return A photo {@link Photo}
     */
    @GET("photos/{id}")
    Call<Photo> getPhoto(
            @Path("id") String id
    );

    /**
     * Retrieve a single random photo, given optional filters.
     * Note: You can’t use the {@code collections} and {@code query} parameters in the same request
     * Note: When supplying a count parameter - and only then - the response will be an array of photos, even if the value of {@code count} is 1.
     * @param collections Public collection ID(‘s) to filter selection. If multiple, comma-separated
     * @param featured Limit selection to featured photos.
     * @param username Limit selection to featured photos.
     * @param query Limit selection to photos matching a search term.
     * @param orientation Filter by photo orientation. {@link Orientation}
     * @param contentFilter Limit results by content safety. Default: low. {@link ContentFilter}
     * @param count The number of photos to return. (Default: 1; max: 30)
     * @return With {@code count} parameter --> A list of photos, without {@code count} single photo. {@link Photo}
     */
    @GET("photos/random")
    Call<List<Photo>> getRandomPhotos(
            @Query("collections") String collections,
            @Query("featured") boolean featured,
            @Query("username") String username,
            @Query("query") String query,
            @Query("orientation") String orientation,
            @Query("content_filter") String contentFilter,
            @Query("count") int count
    );

    /**
     * Retrieve total number of downloads, views and likes of a single photo, as well as the historical breakdown of these stats in a specific timeframe (default is 30 days).
     * Currently, the only resolution param supported is “days”. The quantity param can be any number between 1 and 30.
     * @param id The public id of the photo. Required.
     * @param resolution The frequency of the stats. (Optional; default: “days”)
     * @param quantity The amount of for each stat. (Optional; default: 30)
     * @return {@link Statistics}
     */
    @GET("photos/{id}/statistics")
    Call<Statistics> getPhotoStatistics(
            @Path("id") String id,
            @Query("resolution") String resolution,
            @Query("quantity") int quantity
    );

    /**
     * To abide by the API guidelines, you need to trigger a GET request to this endpoint every time your application performs a download of a photo.
     * @param id The photo’s ID. Required.
     * @return Image download link. {@link Download}
     */
    @GET("photos/{id}/download")
    Call<Download> trackPhotoDownload(
            @Path("id") String id
    );

    /**
     * Update a photo on behalf of the logged-in user. This requires the write_photos scope. {@link Scope}
     * @param id The photo’s ID. Required.
     * @param description The photo’s description (Optional).
     * @param showOnProfile The photo’s visibility (Optional).
     * @param tags The photo’s tags (Optional).
     * @param latitude 	The photo location’s latitude rounded to 6 decimals. (Optional)
     * @param longitude The photo location’s longitude rounded to 6 decimals. (Optional)
     * @param photoLocationName	The photo’s full location string (including city and country) (Optional)
     * @param photoCity The photo location’s city (Optional)
     * @param photoCountry 	The photo location’s country (Optional)
     * @param cameraBrand Camera’s brand (Optional)
     * @param cameraModel Camera’s model (Optional)
     * @param cameraExposureTime Camera’s exposure time (Optional)
     * @param cameraApertureValue Camera’s aperture value (Optional)
     * @param cameraFocalLength Camera’s focal length (Optional)
     * @param cameraIsoSpeedRatings Camera’s iso (Optional)
     * @return Responds with the uploaded photo. {@link Photo}
     */
    @PUT("photos/{id}")
    Call<Photo> updatePhoto(
            @Path("id") String id,
            @Query("description") String description,
            @Query("show_on_profile") boolean showOnProfile,
            @Query("tags") String tags,
            @Query("location[latitude]") double latitude,
            @Query("location[longitude]") double longitude,
            @Query("location[name]") String photoLocationName,
            @Query("location[city]") String photoCity,
            @Query("location[country]") String photoCountry,
            @Query("exif[make]") String cameraBrand,
            @Query("exif[model]") String cameraModel,
            @Query("exif[exposure_time]") String cameraExposureTime,
            @Query("exif[aperture_value]") String cameraApertureValue,
            @Query("exif[focal_length]") String cameraFocalLength,
            @Query("exif[iso_speed_ratings]") int cameraIsoSpeedRatings
    );

    /**
     * Like a photo on behalf of the logged-in user. This requires the write_likes scope. {@link Scope}
     * @param id The photo’s ID. Required.
     * @return Responds with the abbreviated versions of the user and the liked photo. {@link ActionLike}
     */
    @POST("photos/{id}/like")
    Call<ActionLike> likePhoto(
            @Path("id") String id
    );

    /**
     * Remove a user’s like of a photo.
     * @param id The photo’s ID. Required.
     * @return Responds with a 204 status and an empty body.
     */
    @DELETE("photos/{id}/like")
    Call<ActionLike> unlikePhoto(
            @Path("id") String id
    );

}
