package limitless.android.unsplash.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User implements Parcelable {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("updated_at")
    private String updatedAt;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("first_name")
    private String firstName;

    @Expose
    @SerializedName("last_name")
    private String lastName;

    @Expose
    @SerializedName("instagram_username")
    private String instagramUsername;

    @Expose
    @SerializedName("twitter_username")
    private String twitterUsername;

    @Expose
    @SerializedName("portfolio_url")
    private Object portfolioUrl;

    @Expose
    @SerializedName("bio")
    private String bio;

    @Expose
    @SerializedName("location")
    private String location;

    @Expose
    @SerializedName("total_likes")
    private Integer totalLikes;

    @Expose
    @SerializedName("total_photos")
    private Integer totalPhotos;

    @Expose
    @SerializedName("total_collections")
    private Integer totalCollections;

    @Expose
    @SerializedName("followed_by_user")
    private Boolean followedByUser;

    @Expose
    @SerializedName("followers_count")
    private Integer followersCount;

    @Expose
    @SerializedName("following_count")
    private Integer followingCount;

    @Expose
    @SerializedName("downloads")
    private Integer downloads;

    @Expose
    @SerializedName("profile_image")
    private ProfileImage profileImage;

    @Expose
    @SerializedName("badge")
    private Badge badge;

    @Expose
    @SerializedName("links")
    private Links links;

    @Expose
    @SerializedName("current_user_collections")
    private List<CurrentUserCollection> currentUserCollections = null;

    public User() {

    }

    public User(String id, String updatedAt, String username, String name, String firstName, String lastName, String instagramUsername, String twitterUsername, Object portfolioUrl, String bio, String location, Integer totalLikes, Integer totalPhotos, Integer totalCollections, Boolean followedByUser, Integer followersCount, Integer followingCount, Integer downloads, ProfileImage profileImage, Badge badge, Links links, List<CurrentUserCollection> currentUserCollections) {
        this.id = id;
        this.updatedAt = updatedAt;
        this.username = username;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instagramUsername = instagramUsername;
        this.twitterUsername = twitterUsername;
        this.portfolioUrl = portfolioUrl;
        this.bio = bio;
        this.location = location;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.totalCollections = totalCollections;
        this.followedByUser = followedByUser;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
        this.downloads = downloads;
        this.profileImage = profileImage;
        this.badge = badge;
        this.links = links;
        this.currentUserCollections = currentUserCollections;
    }

    protected User(Parcel in) {
        id = in.readString();
        updatedAt = in.readString();
        username = in.readString();
        name = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        instagramUsername = in.readString();
        twitterUsername = in.readString();
        bio = in.readString();
        location = in.readString();
        if (in.readByte() == 0) {
            totalLikes = null;
        } else {
            totalLikes = in.readInt();
        }
        if (in.readByte() == 0) {
            totalPhotos = null;
        } else {
            totalPhotos = in.readInt();
        }
        if (in.readByte() == 0) {
            totalCollections = null;
        } else {
            totalCollections = in.readInt();
        }
        byte tmpFollowedByUser = in.readByte();
        followedByUser = tmpFollowedByUser == 0 ? null : tmpFollowedByUser == 1;
        if (in.readByte() == 0) {
            followersCount = null;
        } else {
            followersCount = in.readInt();
        }
        if (in.readByte() == 0) {
            followingCount = null;
        } else {
            followingCount = in.readInt();
        }
        if (in.readByte() == 0) {
            downloads = null;
        } else {
            downloads = in.readInt();
        }
        profileImage = in.readParcelable(ProfileImage.class.getClassLoader());
        badge = in.readParcelable(Badge.class.getClassLoader());
        links = in.readParcelable(Links.class.getClassLoader());
        currentUserCollections = in.createTypedArrayList(CurrentUserCollection.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public Object getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(Object portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Integer getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(Integer totalCollections) {
        this.totalCollections = totalCollections;
    }

    public Boolean getFollowedByUser() {
        return followedByUser;
    }

    public void setFollowedByUser(Boolean followedByUser) {
        this.followedByUser = followedByUser;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<CurrentUserCollection> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<CurrentUserCollection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(updatedAt);
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(instagramUsername);
        dest.writeString(twitterUsername);
        dest.writeString(bio);
        dest.writeString(location);
        if (totalLikes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalLikes);
        }
        if (totalPhotos == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalPhotos);
        }
        if (totalCollections == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalCollections);
        }
        dest.writeByte((byte) (followedByUser == null ? 0 : followedByUser ? 1 : 2));
        if (followersCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(followersCount);
        }
        if (followingCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(followingCount);
        }
        if (downloads == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(downloads);
        }
        dest.writeParcelable(profileImage, flags);
        dest.writeParcelable(badge, flags);
        dest.writeParcelable(links, flags);
        dest.writeTypedList(currentUserCollections);
    }
}