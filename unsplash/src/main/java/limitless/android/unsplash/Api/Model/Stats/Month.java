package limitless.android.unsplash.Api.Model.Stats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Month implements Parcelable {

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
    @SerializedName("new_photos")
    private int newPhotos;

    @Expose
    @SerializedName("new_photographers")
    private int newPhotographers;

    @Expose
    @SerializedName("new_pixels")
    private int newPixels;

    @Expose
    @SerializedName("new_developers")
    private int newDevelopers;

    @Expose
    @SerializedName("new_applications")
    private int newApplications;

    @Expose
    @SerializedName("new_requests")
    private int newRequests;

    public Month() {

    }

    public Month(int downloads, int views, int likes, int newPhotos, int newPhotographers, int newPixels, int newDevelopers, int newApplications, int newRequests) {
        this.downloads = downloads;
        this.views = views;
        this.likes = likes;
        this.newPhotos = newPhotos;
        this.newPhotographers = newPhotographers;
        this.newPixels = newPixels;
        this.newDevelopers = newDevelopers;
        this.newApplications = newApplications;
        this.newRequests = newRequests;
    }

    protected Month(Parcel in) {
        downloads = in.readInt();
        views = in.readInt();
        likes = in.readInt();
        newPhotos = in.readInt();
        newPhotographers = in.readInt();
        newPixels = in.readInt();
        newDevelopers = in.readInt();
        newApplications = in.readInt();
        newRequests = in.readInt();
    }

    public static final Creator<Month> CREATOR = new Creator<Month>() {
        @Override
        public Month createFromParcel(Parcel in) {
            return new Month(in);
        }

        @Override
        public Month[] newArray(int size) {
            return new Month[size];
        }
    };

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

    public int getNewPhotos() {
        return newPhotos;
    }

    public void setNewPhotos(int newPhotos) {
        this.newPhotos = newPhotos;
    }

    public int getNewPhotographers() {
        return newPhotographers;
    }

    public void setNewPhotographers(int newPhotographers) {
        this.newPhotographers = newPhotographers;
    }

    public int getNewPixels() {
        return newPixels;
    }

    public void setNewPixels(int newPixels) {
        this.newPixels = newPixels;
    }

    public int getNewDevelopers() {
        return newDevelopers;
    }

    public void setNewDevelopers(int newDevelopers) {
        this.newDevelopers = newDevelopers;
    }

    public int getNewApplications() {
        return newApplications;
    }

    public void setNewApplications(int newApplications) {
        this.newApplications = newApplications;
    }

    public int getNewRequests() {
        return newRequests;
    }

    public void setNewRequests(int newRequests) {
        this.newRequests = newRequests;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(downloads);
        dest.writeInt(views);
        dest.writeInt(likes);
        dest.writeInt(newPhotos);
        dest.writeInt(newPhotographers);
        dest.writeInt(newPixels);
        dest.writeInt(newDevelopers);
        dest.writeInt(newApplications);
        dest.writeInt(newRequests);
    }
}
