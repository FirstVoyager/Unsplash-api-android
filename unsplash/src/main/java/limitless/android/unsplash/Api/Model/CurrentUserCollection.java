package limitless.android.unsplash.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentUserCollection implements Parcelable {

    @Expose
    @SerializedName("id")
    private Integer id;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("published_at")
    private String publishedAt;

    @Expose
    @SerializedName("updated_at")
    private String updatedAt;

    @Expose
    @SerializedName("curated")
    private Boolean curated;

    @Expose
    @SerializedName("cover_photo")
    private Object coverPhoto;

    @Expose
    @SerializedName("user")
    private Object user;

    public CurrentUserCollection() {

    }

    public CurrentUserCollection(Integer id, String title, String publishedAt, String updatedAt, Boolean curated, Object coverPhoto, Object user) {
        this.id = id;
        this.title = title;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.curated = curated;
        this.coverPhoto = coverPhoto;
        this.user = user;
    }

    protected CurrentUserCollection(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        publishedAt = in.readString();
        updatedAt = in.readString();
        byte tmpCurated = in.readByte();
        curated = tmpCurated == 0 ? null : tmpCurated == 1;
    }

    public static final Creator<CurrentUserCollection> CREATOR = new Creator<CurrentUserCollection>() {
        @Override
        public CurrentUserCollection createFromParcel(Parcel in) {
            return new CurrentUserCollection(in);
        }

        @Override
        public CurrentUserCollection[] newArray(int size) {
            return new CurrentUserCollection[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getCurated() {
        return curated;
    }

    public void setCurated(Boolean curated) {
        this.curated = curated;
    }

    public Object getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Object coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
        dest.writeString(publishedAt);
        dest.writeString(updatedAt);
        dest.writeByte((byte) (curated == null ? 0 : curated ? 1 : 2));
    }
}
