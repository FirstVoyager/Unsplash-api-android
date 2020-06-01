package limitless.android.unsplash.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActionLike implements Parcelable {

    @Expose
    @SerializedName("photo")
    private Photo photo;

    @Expose
    @SerializedName("user")
    private User user;

    public ActionLike() {

    }

    public ActionLike(Photo photo, User user) {
        this.photo = photo;
        this.user = user;
    }

    protected ActionLike(Parcel in) {
        photo = in.readParcelable(Photo.class.getClassLoader());
        user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<ActionLike> CREATOR = new Creator<ActionLike>() {
        @Override
        public ActionLike createFromParcel(Parcel in) {
            return new ActionLike(in);
        }

        @Override
        public ActionLike[] newArray(int size) {
            return new ActionLike[size];
        }
    };

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
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
        dest.writeParcelable(photo, flags);
        dest.writeParcelable(user, flags);
    }
}
