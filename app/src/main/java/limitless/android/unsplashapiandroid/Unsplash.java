package limitless.android.unsplashapiandroid;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import limitless.android.unsplashapiandroid.Api.Endpoints.CollectionsEndpoints;
import limitless.android.unsplashapiandroid.Api.Endpoints.CurrentUserEndpoints;
import limitless.android.unsplashapiandroid.Api.Endpoints.PhotosEndpoints;
import limitless.android.unsplashapiandroid.Api.Endpoints.SearchEndpoints;
import limitless.android.unsplashapiandroid.Api.HeaderPublic;
import limitless.android.unsplashapiandroid.Api.HeaderToken;
import limitless.android.unsplashapiandroid.Api.Model.*;
import limitless.android.unsplashapiandroid.Listeners.UnsplashListener;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Unsplash {


    private String baseUrl = "https://api.unsplash.com/";

    private PhotosEndpoints photosService;
    private SearchEndpoints searchService;
    private CollectionsEndpoints collectionService;
    private CurrentUserEndpoints currentUserService;


    /**
     * @param key Access key for public, token for logged users
     * @param isLogged true --> For logged users use token, false --> For public usage
     */
    public Unsplash(@NonNull String key, boolean isLogged){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (isLogged)
            builder.addInterceptor(new HeaderToken(key));
        else
            builder.addInterceptor(new HeaderPublic(key));
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        currentUserService = retrofit.create(CurrentUserEndpoints.class);
        photosService = retrofit.create(PhotosEndpoints.class);
        searchService = retrofit.create(SearchEndpoints.class);
        collectionService = retrofit.create(CollectionsEndpoints.class);
    }

    public void getPhotos(
            int page,
            int perPage,
            @Nullable String order,
            @NonNull final UnsplashListener<List<Photo>> photosListener){
        photosService.getPhotos(page, perPage, order).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photosListener.data(response.body());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                photosListener.error(t.getMessage());
            }
        });
    }

    public void getPhoto(
            @NonNull String id,
            @NonNull final UnsplashListener<Photo> photoListener){
        photosService.getPhoto(id).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                photoListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                photoListener.error(t.getMessage());
            }
        });
    }

    public void getRandomPhoto(
            @Nullable String collections,
            boolean featured,
            @Nullable String username,
            @Nullable String query,
            @Nullable String orientation,
            @Nullable String contentFilter,
            int count,
            @NonNull final UnsplashListener<List<Photo>> photosListener){
        photosService.getRandomPhotos(collections, featured, username, query, orientation, contentFilter, count).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photosListener.data(response.body());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                photosListener.error(t.getMessage());
            }
        });
    }

    public void getPhotoStatistics(
            @NonNull String id,
            @Nullable String resolution,
            int quantity,
            @NonNull final UnsplashListener<Statistics> statisticsListener){
        photosService.getPhotoStatistics(id, resolution, quantity).enqueue(new Callback<Statistics>() {
            @Override
            public void onResponse(Call<Statistics> call, Response<Statistics> response) {
                statisticsListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Statistics> call, Throwable t) {
                statisticsListener.error(t.getMessage());
            }
        });
    }

    public void trackPhotoDownload(
            @NonNull String id,
            @NonNull final UnsplashListener<Download> urlListener){
        photosService.trackPhotoDownload(id).enqueue(new Callback<Download>() {
            @Override
            public void onResponse(Call<Download> call, Response<Download> response) {
                urlListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Download> call, Throwable t) {
                urlListener.error(t.getMessage());
            }
        });
    }

    public void updatePhoto(
            @NonNull String id,
            @Nullable String description,
            boolean showOnProfile,
            @Nullable String tags,
            double latitude,
            double longitude,
            @Nullable String photoLocationName,
            @Nullable String photoCity,
            @Nullable String photoCountry,
            @Nullable String cameraBrand,
            @Nullable String cameraModel,
            @Nullable String cameraExposureTime,
            @Nullable String cameraApertureValue,
            @Nullable String cameraFocalLength,
            int isoSpeedRating,
            @NonNull final UnsplashListener<Photo> photoListener){
        photosService.updatePhoto(
                id,
                description,
                showOnProfile,
                tags,
                latitude,
                longitude,
                photoLocationName,
                photoCity,
                photoCountry,
                cameraBrand,
                cameraModel,
                cameraExposureTime,
                cameraApertureValue,
                cameraFocalLength,
                isoSpeedRating).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                photoListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                photoListener.error(t.getMessage());
            }
        });
    }

    public void likePhoto(
            @NonNull String id,
            @NonNull final UnsplashListener<ActionLike> likeListener){
        photosService.likePhoto(id).enqueue(new Callback<ActionLike>() {
            @Override
            public void onResponse(Call<ActionLike> call, Response<ActionLike> response) {
                likeListener.data(response.body());
            }

            @Override
            public void onFailure(Call<ActionLike> call, Throwable t) {
                likeListener.error(t.getMessage());
            }
        });
    }

    public void unlikePhoto(
            @NonNull String id,
            @NonNull final UnsplashListener<ActionLike> unlikeListener){
        photosService.unlikePhoto(id).enqueue(new Callback<ActionLike>() {
            @Override
            public void onResponse(Call<ActionLike> call, Response<ActionLike> response) {
                unlikeListener.data(response.body());
            }

            @Override
            public void onFailure(Call<ActionLike> call, Throwable t) {
                unlikeListener.error(t.getMessage());
            }
        });
    }


    public void searchPhotos(
            @Nullable String query,
            int page,
            int perPage,
            @Nullable String orderBy,
            @Nullable String collections,
            @Nullable String contentFilter,
            @Nullable String color,
            @Nullable String orientation,
            @NonNull final UnsplashListener<SearchResults<Photo>> searchListener){
        searchService.searchPhotos(
                query,
                page,
                perPage,
                orderBy,
                collections,
                contentFilter,
                color,
                orientation).enqueue(new Callback<SearchResults<Photo>>() {
            @Override
            public void onResponse(Call<SearchResults<Photo>> call, Response<SearchResults<Photo>> response) {
                searchListener.data(response.body());
            }

            @Override
            public void onFailure(Call<SearchResults
                    <Photo>> call, Throwable t) {
                searchListener.error(t.getMessage());
            }
        });
    }

    public void searchCollections(
            @Nullable String query,
            int page,
            int perPage,
            @NonNull final UnsplashListener<SearchResults<Collection>> searchListener){
        searchService.searchCollections(query, page, perPage).enqueue(new Callback<SearchResults<Collection>>() {
            @Override
            public void onResponse(Call<SearchResults<Collection>> call, Response<SearchResults<Collection>> response) {
                searchListener.data(response.body());
            }

            @Override
            public void onFailure(Call<SearchResults<Collection>> call, Throwable t) {
                searchListener.error(t.getMessage());
            }
        });
    }

    public void searchUsers(
            @Nullable String query,
            int page,
            int perPage,
            @NonNull final UnsplashListener<SearchResults<User>> searchListener){
        searchService.searchUsers(query, page, perPage).enqueue(new Callback<SearchResults<User>>() {
            @Override
            public void onResponse(Call<SearchResults<User>> call, Response<SearchResults<User>> response) {
                searchListener.data(response.body());
            }

            @Override
            public void onFailure(Call<SearchResults<User>> call, Throwable t) {
                searchListener.error(t.getMessage());
            }
        });
    }

    public void getCollections(
            int page,
            int perPage,
            @NonNull final UnsplashListener<List<Collection>> collectionsListener){
        collectionService.getCollections(page, perPage).enqueue(new Callback<List<Collection>>() {
            @Override
            public void onResponse(Call<List<Collection>> call, Response<List<Collection>> response) {
                collectionsListener.data(response.body());
            }

            @Override
            public void onFailure(Call<List<Collection>> call, Throwable t) {
                collectionsListener.error(t.getMessage());
            }
        });
    }

    public void getFeaturedCollections(
            Integer page,
            Integer perPage,
            @NonNull final UnsplashListener<List<Collection>> collectionListener){
        collectionService.getFeaturedCollections(page, perPage).enqueue(new Callback<List<Collection>>() {
            @Override
            public void onResponse(Call<List<Collection>> call, Response<List<Collection>> response) {
                collectionListener.data(response.body());
            }

            @Override
            public void onFailure(Call<List<Collection>> call, Throwable t) {
                collectionListener.error(t.getMessage());
            }
        });
    }

    public void getCollection(
            @NonNull Integer id,
            @NonNull final UnsplashListener<Collection> collectionListener){
        collectionService.getCollection(id).enqueue(new Callback<Collection>() {
            @Override
            public void onResponse(Call<Collection> call, Response<Collection> response) {
                collectionListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Collection> call, Throwable t) {
                collectionListener.error(t.getMessage());
            }
        });
    };

    public void getCollectionPhotos(
            @NonNull Integer id,
            @Nullable Integer page,
            @Nullable Integer perPage,
            @Nullable String orientation,
            @NonNull final UnsplashListener<List<Photo>> photosListener){
        collectionService.getCollectionPhotos(id, page, perPage, orientation).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photosListener.data(response.body());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                photosListener.error(t.getMessage());
            }
        });
    }

    public void getRelatedCollections(
            @NonNull Integer id,
            @NonNull final UnsplashListener<List<Collection>> collectionsListener){
        collectionService.getRelatedCollections(id).enqueue(new Callback<List<Collection>>() {
            @Override
            public void onResponse(Call<List<Collection>> call, Response<List<Collection>> response) {
                collectionsListener.data(response.body());
            }

            @Override
            public void onFailure(Call<List<Collection>> call, Throwable t) {
                collectionsListener.error(t.getMessage());
            }
        });
    }

    public void createNewCollection(
            @NonNull String title,
            @Nullable String description,
            boolean isPrivate,
            @NonNull final UnsplashListener<Collection> collectionListener){
        collectionService.createNewCollection(title, description, isPrivate).enqueue(new Callback<Collection>() {
            @Override
            public void onResponse(Call<Collection> call, Response<Collection> response) {
                collectionListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Collection> call, Throwable t) {
                collectionListener.error(t.getMessage());
            }
        });
    }

    public void updateCollection(
            @NonNull String id,
            @Nullable String title,
            @Nullable String description,
            boolean isPrivate,
            @NonNull final UnsplashListener<Collection> collectionListener){
        collectionService.updateCollection(id, title, description, isPrivate).enqueue(new Callback<Collection>() {
            @Override
            public void onResponse(Call<Collection> call, Response<Collection> response) {
                collectionListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Collection> call, Throwable t) {
                collectionListener.error(t.getMessage());
            }
        });
    }

    public void deleteCollection(
            @NonNull String id,
            @NonNull final UnsplashListener<Void> voidListener){
        collectionService.deleteCollection(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                voidListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                voidListener.error(t.getMessage());
            }
        });
    }

    public void addPhotoToCollection(
            @NonNull String collectionId,
            @NonNull String photoId,
            @NonNull final UnsplashListener<Photo> photoListener){
        collectionService.addPhotoToCollection(collectionId, photoId).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                photoListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                photoListener.error(t.getMessage());
            }
        });
    }

    public void deletePhotoFromCollection(
            @NonNull String collectionId,
            @NonNull String photoId,
            @NonNull final UnsplashListener<Photo> photoListener) {
        collectionService.removePhotoFromCollection(collectionId, photoId).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                photoListener.data(response.body());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                photoListener.error(t.getMessage());
            }
        });
    }

}
