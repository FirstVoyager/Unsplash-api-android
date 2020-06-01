package limitless.android.unsplash.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Exif implements Parcelable {

    @Expose
    @SerializedName("make")
    private String make;

    @Expose
    @SerializedName("model")
    private String model;

    @Expose
    @SerializedName("exposure_time")
    private String exposureTime;

    @Expose
    @SerializedName("aperture")
    private String aperture;

    @Expose
    @SerializedName("focal_length")
    private String focalLength;

    @Expose
    @SerializedName("iso")
    private int iso;

    public Exif() {

    }

    public Exif(String make, String model, String exposureTime, String aperture, String focalLength, int iso) {
        super();
        this.make = make;
        this.model = model;
        this.exposureTime = exposureTime;
        this.aperture = aperture;
        this.focalLength = focalLength;
        this.iso = iso;
    }

    protected Exif(Parcel in) {
        make = in.readString();
        model = in.readString();
        exposureTime = in.readString();
        aperture = in.readString();
        focalLength = in.readString();
        iso = in.readInt();
    }

    public static final Creator<Exif> CREATOR = new Creator<Exif>() {
        @Override
        public Exif createFromParcel(Parcel in) {
            return new Exif(in);
        }

        @Override
        public Exif[] newArray(int size) {
            return new Exif[size];
        }
    };

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public int getIso() {
        return iso;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(exposureTime);
        dest.writeString(aperture);
        dest.writeString(focalLength);
        dest.writeInt(iso);
    }
}
