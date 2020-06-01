package limitless.android.unsplash.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Badge implements Parcelable {

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("primary")
    private Boolean primary;

    @Expose
    @SerializedName("slug")
    private String slug;

    @Expose
    @SerializedName("link")
    private String link;

    public Badge() {

    }

    public Badge(String title, Boolean primary, String slug, String link) {
        this.title = title;
        this.primary = primary;
        this.slug = slug;
        this.link = link;
    }

    protected Badge(Parcel in) {
        title = in.readString();
        byte tmpPrimary = in.readByte();
        primary = tmpPrimary == 0 ? null : tmpPrimary == 1;
        slug = in.readString();
        link = in.readString();
    }

    public static final Creator<Badge> CREATOR = new Creator<Badge>() {
        @Override
        public Badge createFromParcel(Parcel in) {
            return new Badge(in);
        }

        @Override
        public Badge[] newArray(int size) {
            return new Badge[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeByte((byte) (primary == null ? 0 : primary ? 1 : 2));
        dest.writeString(slug);
        dest.writeString(link);
    }
}