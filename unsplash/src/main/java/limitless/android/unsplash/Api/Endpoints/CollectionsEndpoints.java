package limitless.android.unsplash.Api.Endpoints;

import java.util.List;

import limitless.android.unsplash.Api.Enum.Orientation;
import limitless.android.unsplash.Api.Enum.Scope;
import limitless.android.unsplash.Api.Model.Collection;
import limitless.android.unsplash.Api.Model.Photo;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Collections endpoints
 */
public interface CollectionsEndpoints {

    /**
     * Get a single page from the list of all collections
     * @param page Page number to retrieve. (Optional; default: 1)
     * @param perPage Number of items per page. (Optional; default: 10)
     * @return a list of {@link Collection}
     */
    @GET("collections")
    Call<List<Collection>> getCollections(
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    /**
     * Get a single page from the list of featured collections
     * @param page Page number to retrieve. (Optional; default: 1)
     * @param perPage Number of items per page. (Optional; default: 10)
     * @return A list of {@link Collection}
     */
    @GET("collections/featured")
    Call<List<Collection>> getFeaturedCollections(
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    /**
     * Retrieve a single collection. To view a user’s private collections, the read_collections {@link Scope} is required
     * @param id The collections’s ID. Required.
     * @return A single {@link Collection}
     */
    @GET("collections/{id}")
    Call<Collection> getCollection(
            @Path("id") Integer id
    );

    /**
     * Retrieve a collection’s photos
     * @param id The collection’s ID. Required.
     * @param page Page number to retrieve. (Optional; default: 1)
     * @param perPage Number of items per page. (Optional; default: 10)
     * @param orientation Filter by photo orientation. Optional. {@link Orientation}
     * @return A list of {@link Photo}
     */
    @GET("collections/{id}/photos")
    Call<List<Photo>> getCollectionPhotos(
            @Path("id") Integer id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("orientation") String orientation
    );

    /**
     * Retrieve a list of collections related to this one
     * @param id The collection’s ID. Required
     * @return A list of {@link Collection}
     */
    @GET("collections/{id}/related")
    Call<List<Collection>> getRelatedCollections(
            @Path("id") Integer id
    );

    /**
     * Create a new collection. This requires the write_collections {@link Scope}
     * @param title The title of the collection. (Required.)
     * @param description The collection’s description. (Optional.)
     * @param isPrivate Whether to make this collection private. (Optional; default false).
     * @return A created {@link Collection}
     */
    @POST("collections")
    Call<Collection> createNewCollection(
            @Query("title") String title,
            @Query("description") String description,
            @Query("private") boolean isPrivate
    );

    /**
     * Update an existing collection belonging to the logged-in user. This requires the write_collections scope. {@link Scope}
     * @param id The collection’s ID. Required
     * @param title The title of the collection. (Optional.)
     * @param description The collection’s description. (Optional.)
     * @param isPrivate Whether to make this collection private. (Optional.)
     * @return Responds with the updated collection {@link Collection}
     */
    @PUT("collections/{id}")
    Call<Collection> updateCollection(
            @Path("id") String id,
            @Query("title") String title,
            @Query("description") String description,
            @Query("private") boolean isPrivate
    );

    /**
     * Delete a collection belonging to the logged-in user. This requires the write_collections scope. {@link Scope}
     * @param id The collection’s ID. Required.
     * @return Responds with a 204 status and an empty body.
     */
    @DELETE("collections/{id}")
    Call<Void> deleteCollection(
            @Path("id") String id
    );

    /**
     * Add a photo to one of the logged-in user’s collections. Requires the write_collections scope. {@link Scope}
     * Note: If the photo is already in the collection, this acion has no effect.
     * @param collectionId The collection’s ID. Required.
     * @param photoId The photo’s ID. Required.
     * @return A added photo. {@link Photo}
     */
    @POST("collections/{collection_id}/add")
    Call<Photo> addPhotoToCollection(
            @Path("collection_id") String collectionId,
            @Query("photo_id") String photoId
    );

    /**
     * Remove a photo from one of the logged-in user’s collections. Requires the write_collections scope. {@link Scope}
     * @param collectionId The collection’s ID. Required.
     * @param photoId The photo’s ID. Required.
     * @return A removed photo. {@link Photo}
     */
    @DELETE("collections/{collection_id}/remove")
    Call<Photo> removePhotoFromCollection(
            @Path("collection_id") String collectionId,
            @Query("photo_id") String photoId
    );

}
