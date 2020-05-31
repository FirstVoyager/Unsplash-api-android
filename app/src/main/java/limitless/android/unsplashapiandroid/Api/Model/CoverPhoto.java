package limitless.android.unsplashapiandroid.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CoverPhoto implements Parcelable{

    @Expose
    @SerializedName("id")
    private String id;

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
    @SerializedName("likes")
    private Integer likes;

    @Expose
    @SerializedName("liked_by_user")
    private Boolean likedByUser;

    @Expose
    @SerializedName("user")
    private User user;

    @Expose
    @SerializedName("urls")
    private Urls urls;

    @Expose
    @SerializedName("categories")
    private List<Category> categories = new ArrayList<>();

    @Expose
    @SerializedName("links")
    private Links links;

    public CoverPhoto() {

    }

    public CoverPhoto(String id, Integer width, Integer height, String color, Integer likes, Boolean likedByUser, User user, Urls urls, List<Category> categories, Links links) {
        super();
        this.id = id;
        this.width = width;
        this.height = height;
        this.color = color;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.user = user;
        this.urls = urls;
        this.categories = categories;
        this.links = links;
    }


    protected CoverPhoto(Parcel in) {
        id = in.readString();
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
            likes = null;
        } else {
            likes = in.readInt();
        }
        byte tmpLikedByUser = in.readByte();
        likedByUser = tmpLikedByUser == 0 ? null : tmpLikedByUser == 1;
        user = in.readParcelable(User.class.getClassLoader());
        urls = in.readParcelable(Urls.class.getClassLoader());
        categories = in.createTypedArrayList(Category.CREATOR);
        links = in.readParcelable(Links.class.getClassLoader());
    }

    public static final Creator<CoverPhoto> CREATOR = new Creator<CoverPhoto>() {
        @Override
        public CoverPhoto createFromParcel(Parcel in) {
            return new CoverPhoto(in);
        }

        @Override
        public CoverPhoto[] newArray(int size) {
            return new CoverPhoto[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(id);
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
        if (likes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(likes);
        }
        dest.writeByte((byte) (likedByUser == null ? 0 : likedByUser ? 1 : 2));
        dest.writeParcelable(user, flags);
        dest.writeParcelable(urls, flags);
        dest.writeTypedList(categories);
        dest.writeParcelable(links, flags);
    }

}
