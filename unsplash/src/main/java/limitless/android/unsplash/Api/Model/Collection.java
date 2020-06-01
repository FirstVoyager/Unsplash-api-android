package limitless.android.unsplash.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection implements Parcelable {

    @Expose
    @SerializedName("id")
    private Integer id;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("description")
    private String description;

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
    @SerializedName("total_photos")
    private Integer totalPhotos;

    @Expose
    @SerializedName("private")
    private Boolean _private;

    @Expose
    @SerializedName("share_key")
    private String shareKey;

    @Expose
    @SerializedName("cover_photo")
    private CoverPhoto coverPhoto;

    @Expose
    @SerializedName("user")
    private User user;

    @Expose
    @SerializedName("links")
    private Links links;

    public Collection() {

    }

    public Collection(Integer id, String title, String description, String publishedAt, String updatedAt, Boolean curated, Integer totalPhotos, Boolean _private, String shareKey, CoverPhoto coverPhoto, User user, Links links) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.curated = curated;
        this.totalPhotos = totalPhotos;
        this._private = _private;
        this.shareKey = shareKey;
        this.coverPhoto = coverPhoto;
        this.user = user;
        this.links = links;
    }


    protected Collection(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        description = in.readString();
        publishedAt = in.readString();
        updatedAt = in.readString();
        byte tmpCurated = in.readByte();
        curated = tmpCurated == 0 ? null : tmpCurated == 1;
        if (in.readByte() == 0) {
            totalPhotos = null;
        } else {
            totalPhotos = in.readInt();
        }
        byte tmp_private = in.readByte();
        _private = tmp_private == 0 ? null : tmp_private == 1;
        shareKey = in.readString();
        coverPhoto = in.readParcelable(CoverPhoto.class.getClassLoader());
        user = in.readParcelable(User.class.getClassLoader());
        links = in.readParcelable(Links.class.getClassLoader());
    }

    public static final Creator<Collection> CREATOR = new Creator<Collection>() {
        @Override
        public Collection createFromParcel(Parcel in) {
            return new Collection(in);
        }

        @Override
        public Collection[] newArray(int size) {
            return new Collection[size];
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Boolean get_private() {
        return _private;
    }

    public void set_private(Boolean _private) {
        this._private = _private;
    }

    public String getShareKey() {
        return shareKey;
    }

    public void setShareKey(String shareKey) {
        this.shareKey = shareKey;
    }

    public CoverPhoto getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(CoverPhoto coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
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
        dest.writeString(description);
        dest.writeString(publishedAt);
        dest.writeString(updatedAt);
        dest.writeByte((byte) (curated == null ? 0 : curated ? 1 : 2));
        if (totalPhotos == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalPhotos);
        }
        dest.writeByte((byte) (_private == null ? 0 : _private ? 1 : 2));
        dest.writeString(shareKey);
        dest.writeParcelable(coverPhoto, flags);
        dest.writeParcelable(user, flags);
        dest.writeParcelable(links, flags);
    }
}
