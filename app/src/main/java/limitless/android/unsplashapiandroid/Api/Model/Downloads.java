package limitless.android.unsplashapiandroid.Api.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Downloads implements Parcelable {

    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("historical")
    private Historical historical;

    public Downloads() {

    }

    public Downloads(int total, Historical historical) {
        this.total = total;
        this.historical = historical;
    }

    protected Downloads(Parcel in) {
        total = in.readInt();
        historical = in.readParcelable(Historical.class.getClassLoader());
    }

    public static final Creator<Downloads> CREATOR = new Creator<Downloads>() {
        @Override
        public Downloads createFromParcel(Parcel in) {
            return new Downloads(in);
        }

        @Override
        public Downloads[] newArray(int size) {
            return new Downloads[size];
        }
    };

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Historical getHistorical() {
        return historical;
    }

    public void setHistorical(Historical historical) {
        this.historical = historical;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(total);
        dest.writeParcelable(historical, flags);
    }
}
