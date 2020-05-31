package limitless.android.unsplashapiandroid.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics implements Parcelable {

    @Expose
    @SerializedName("username")
    private String userName;

    @Expose
    @SerializedName("downloads")
    private Downloads downloads;

    @Expose
    @SerializedName("views")
    private Views views;

    @Expose
    @SerializedName("likes")
    private Likes likes;

    public Statistics() {

    }

    public Statistics(String userName, Downloads downloads, Views views, Likes likes) {
        this.userName = userName;
        this.downloads = downloads;
        this.views = views;
        this.likes = likes;
    }

    protected Statistics(Parcel in) {
        userName = in.readString();
        downloads = in.readParcelable(Downloads.class.getClassLoader());
        views = in.readParcelable(Views.class.getClassLoader());
        likes = in.readParcelable(Likes.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeParcelable(downloads, flags);
        dest.writeParcelable(views, flags);
        dest.writeParcelable(likes, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Statistics> CREATOR = new Creator<Statistics>() {
        @Override
        public Statistics createFromParcel(Parcel in) {
            return new Statistics(in);
        }

        @Override
        public Statistics[] newArray(int size) {
            return new Statistics[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Downloads getDownloads() {
        return downloads;
    }

    public void setDownloads(Downloads downloads) {
        this.downloads = downloads;
    }

    public Views getViews() {
        return views;
    }

    public void setViews(Views views) {
        this.views = views;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }
}
