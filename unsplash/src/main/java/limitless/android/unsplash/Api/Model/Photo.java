package limitless.android.unsplash.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Photo implements Parcelable {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("created_at")
    private String createdAt;

    @Expose
    @SerializedName("updated_at")
    private String updatedAt;

    @Expose
    @SerializedName("width")
    private Integer width;

    @Expose
    @SerializedName("height")
    private Integer height;

    @Expose
    @SerializedName("color")
    private String color;

    @Expose
    @SerializedName("downloads")
    private Integer downloads;

    @Expose
    @SerializedName("likes")
    private Integer likes;

    @Expose
    @SerializedName("liked_by_user")
    private Boolean likedByUser;

    @Expose
    @SerializedName("exif")
    private Exif exif;

    @Expose
    @SerializedName("location")
    private Location location;

    @Expose
    @SerializedName("current_user_collections")
    private List<Collection> currentUserCollections = new ArrayList<>();

    @Expose
    @SerializedName("urls")
    private Urls urls;

    @Expose
    @SerializedName("categories")
    private List<Category> categories = new ArrayList<>();

    @Expose
    @SerializedName("links")
    private Links links;

    @Expose
    @SerializedName("user")
    private User user;

    public Photo() {

    }

    public Photo(String id, String createdAt, String updatedAt, Integer width, Integer height, String color, Integer downloads, Integer likes, Boolean likedByUser, Exif exif, Location location, List<Collection> currentUserCollections, Urls urls, List<Category> categories, Links links, User user) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.downloads = downloads;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.exif = exif;
        this.location = location;
        this.currentUserCollections = currentUserCollections;
        this.urls = urls;
        this.categories = categories;
        this.links = links;
        this.user = user;
    }

    protected Photo(Parcel in) {
        id = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        if (in.readByte() == 0) {
            width = null;
        } else {
            width = in.readInt();
        }
        if (in.readByte() == 0) {
            height = null;
        } else {
            height = in.readInt();
        }
        color = in.readString();
        if (in.readByte() == 0) {
            downloads = null;
        } else {
            downloads = in.readInt();
        }
        if (in.readByte() == 0) {
            likes = null;
        } else {
            likes = in.readInt();
        }
        byte tmpLikedByUser = in.readByte();
        likedByUser = tmpLikedByUser == 0 ? null : tmpLikedByUser == 1;
        exif = in.readParcelable(Exif.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        currentUserCollections = in.createTypedArrayList(Collection.CREATOR);
        urls = in.readParcelable(Urls.class.getClassLoader());
        categories = in.createTypedArrayList(Category.CREATOR);
        links = in.readParcelable(Links.class.getClassLoader());
        user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public Exif getExif() {
        return exif;
    }

    public void setExif(Exif exif) {
        this.exif = exif;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Collection> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Collection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        if (width == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(width);
        }
        if (height == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(height);
        }
        dest.writeString(color);
        if (downloads == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(downloads);
        }
        if (likes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(likes);
        }
        dest.writeByte((byte) (likedByUser == null ? 0 : likedByUser ? 1 : 2));
        dest.writeParcelable(exif, flags);
        dest.writeParcelable(location, flags);
        dest.writeTypedList(currentUserCollections);
        dest.writeParcelable(urls, flags);
        dest.writeTypedList(categories);
        dest.writeParcelable(links, flags);
        dest.writeParcelable(user, flags);
    }

}
