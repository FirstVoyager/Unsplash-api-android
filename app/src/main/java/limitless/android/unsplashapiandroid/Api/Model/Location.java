package limitless.android.unsplashapiandroid.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable{

    @Expose
    @SerializedName("city")
    private String city;

    @Expose
    @SerializedName("country")
    private String country;

    @Expose
    @SerializedName("position")
    private Position position;

    public Location() {

    }

    public Location(String city, String country, Position position) {
        super();
        this.city = city;
        this.country = country;
        this.position = position;
    }


    protected Location(Parcel in) {
        city = in.readString();
        country = in.readString();
        position = in.readParcelable(Position.class.getClassLoader());
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(country);
        dest.writeParcelable(position, flags);
    }


}
