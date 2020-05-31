package limitless.android.unsplashapiandroid.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Historical implements Parcelable {

    @SerializedName("change")
    @Expose
    private int change;

    @SerializedName("average")
    @Expose
    private int average;

    @SerializedName("resolution")
    @Expose
    private String resolution;

    @SerializedName("quantity")
    @Expose
    private int quantity;

    @SerializedName("values")
    @Expose
    private List<Value> values;

    public Historical() {

    }

    public Historical(int change, int average, String resolution, int quantity, List<Value> values) {
        this.change = change;
        this.average = average;
        this.resolution = resolution;
        this.quantity = quantity;
        this.values = values;
    }

    protected Historical(Parcel in) {
        change = in.readInt();
        average = in.readInt();
        resolution = in.readString();
        quantity = in.readInt();
        values = in.createTypedArrayList(Value.CREATOR);
    }

    public static final Creator<Historical> CREATOR = new Creator<Historical>() {
        @Override
        public Historical createFromParcel(Parcel in) {
            return new Historical(in);
        }

        @Override
        public Historical[] newArray(int size) {
            return new Historical[size];
        }
    };

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(change);
        dest.writeInt(average);
        dest.writeString(resolution);
        dest.writeInt(quantity);
        dest.writeTypedList(values);
    }
}
