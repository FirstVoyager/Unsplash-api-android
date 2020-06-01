package limitless.android.unsplash.Api.Model.Stats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Total implements Parcelable {

    @Expose
    @SerializedName("photos")
    private int photos;

    @Expose
    @SerializedName("downloads")
    private int downloads;

    @Expose
    @SerializedName("views")
    private int views;

    @Expose
    @SerializedName("likes")
    private int likes;

    @Expose
    @SerializedName("photographers")
    private int photographers;

    @Expose
    @SerializedName("pixels")
    private int pixels;

    @Expose
    @SerializedName("downloads_per_second")
    private int downloadPerSeconds;

    @Expose
    @SerializedName("views_per_second")
    private int viewsPerSeconds;

    @Expose
    @SerializedName("developers")
    private int developers;

    @Expose
    @SerializedName("applications")
    private int applications;

    @Expose
    @SerializedName("requests")
    private int requests;

    public Total() {

    }

    public Total(int photos, int downloads, int views, int likes, int photographers, int pixels, int downloadPerSeconds, int viewsPerSeconds, int developers, int applications, int requests) {
        this.photos = photos;
        this.downloads = downloads;
        this.views = views;
        this.likes = likes;
        this.photographers = photographers;
        this.pixels = pixels;
        this.downloadPerSeconds = downloadPerSeconds;
        this.viewsPerSeconds = viewsPerSeconds;
        this.developers = developers;
        this.applications = applications;
        this.requests = requests;
    }

    protected Total(Parcel in) {
        photos = in.readInt();
        downloads = in.readInt();
        views = in.readInt();
        likes = in.readInt();
        photographers = in.readInt();
        pixels = in.readInt();
        downloadPerSeconds = in.readInt();
        viewsPerSeconds = in.readInt();
        developers = in.readInt();
        applications = in.readInt();
        requests = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photos);
        dest.writeInt(downloads);
        dest.writeInt(views);
        dest.writeInt(likes);
        dest.writeInt(photographers);
        dest.writeInt(pixels);
        dest.writeInt(downloadPerSeconds);
        dest.writeInt(viewsPerSeconds);
        dest.writeInt(developers);
        dest.writeInt(applications);
        dest.writeInt(requests);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Total> CREATOR = new Creator<Total>() {
        @Override
        public Total createFromParcel(Parcel in) {
            return new Total(in);
        }

        @Override
        public Total[] newArray(int size) {
            return new Total[size];
        }
    };

    public int getPhotos() {
        return photos;
    }

    public void setPhotos(int photos) {
        this.photos = photos;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPhotographers() {
        return photographers;
    }

    public void setPhotographers(int photographers) {
        this.photographers = photographers;
    }

    public int getPixels() {
        return pixels;
    }

    public void setPixels(int pixels) {
        this.pixels = pixels;
    }

    public int getDownloadPerSeconds() {
        return downloadPerSeconds;
    }

    public void setDownloadPerSeconds(int downloadPerSeconds) {
        this.downloadPerSeconds = downloadPerSeconds;
    }

    public int getViewsPerSeconds() {
        return viewsPerSeconds;
    }

    public void setViewsPerSeconds(int viewsPerSeconds) {
        this.viewsPerSeconds = viewsPerSeconds;
    }

    public int getDevelopers() {
        return developers;
    }

    public void setDevelopers(int developers) {
        this.developers = developers;
    }

    public int getApplications() {
        return applications;
    }

    public void setApplications(int applications) {
        this.applications = applications;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }
}

