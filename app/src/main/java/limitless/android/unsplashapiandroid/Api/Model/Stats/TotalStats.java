package limitless.android.unsplashapiandroid.Api.Model.Stats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TotalStats implements Parcelable {

    @SerializedName("total_stats")
    private Total total;

    public TotalStats() {

    }

    public TotalStats(Total total) {
        this.total = total;
    }

    protected TotalStats(Parcel in) {
        total = in.readParcelable(Total.class.getClassLoader());
    }

    public static final Creator<TotalStats> CREATOR = new Creator<TotalStats>() {
        @Override
        public TotalStats createFromParcel(Parcel in) {
            return new TotalStats(in);
        }

        @Override
        public TotalStats[] newArray(int size) {
            return new TotalStats[size];
        }
    };

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(total, flags);
    }
}