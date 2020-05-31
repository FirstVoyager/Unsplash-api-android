package limitless.android.unsplashapiandroid.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileImage implements Parcelable{

    @Expose
    @SerializedName("small")
    private String small;

    @Expose
    @SerializedName("medium")
    private String medium;

    @Expose
    @SerializedName("large")
    private String large;

    public ProfileImage() {

    }

    public ProfileImage(String small, String medium, String large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    protected ProfileImage(Parcel in) {
        small = in.readString();
        medium = in.readString();
        large = in.readString();
    }

    public static final Creator<ProfileImage> CREATOR = new Creator<ProfileImage>() {
        @Override
        public ProfileImage createFromParcel(Parcel in) {
            return new ProfileImage(in);
        }

        @Override
        public ProfileImage[] newArray(int size) {
            return new ProfileImage[size];
        }
    };

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(small);
        dest.writeString(medium);
        dest.writeString(large);
    }
}