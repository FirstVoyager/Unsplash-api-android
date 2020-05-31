package limitless.android.unsplashapiandroid.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable {

    @SerializedName("self")
    @Expose
    private String self;

    @SerializedName("html")
    @Expose
    private String html;

    @SerializedName("photos")
    @Expose
    private String photos;

    @SerializedName("likes")
    @Expose
    private String likes;

    @SerializedName("portfolio")
    @Expose
    private String portfolio;

    @SerializedName("download")
    @Expose
    private String download;

    @SerializedName("download_location")
    @Expose
    private String downloadLocation;

    public Links() {

    }

    public Links(String self, String html, String photos, String likes, String portfolio, String download, String downloadLocation) {
        this.self = self;
        this.html = html;
        this.photos = photos;
        this.likes = likes;
        this.portfolio = portfolio;
        this.download = download;
        this.downloadLocation = downloadLocation;
    }

    protected Links(Parcel in) {
        self = in.readString();
        html = in.readString();
        photos = in.readString();
        likes = in.readString();
        portfolio = in.readString();
        download = in.readString();
        downloadLocation = in.readString();
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(self);
        dest.writeString(html);
        dest.writeString(photos);
        dest.writeString(likes);
        dest.writeString(portfolio);
        dest.writeString(download);
        dest.writeString(downloadLocation);
    }
}