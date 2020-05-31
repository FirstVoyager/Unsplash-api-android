package limitless.android.unsplashapiandroid.Api.Model.Stats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MonthStats implements Parcelable {

    @SerializedName("month_stats")
    private Month month;

    public MonthStats() {

    }

    public MonthStats(Month month) {
        this.month = month;
    }

    protected MonthStats(Parcel in) {
        month = in.readParcelable(Month.class.getClassLoader());
    }

    public static final Creator<MonthStats> CREATOR = new Creator<MonthStats>() {
        @Override
        public MonthStats createFromParcel(Parcel in) {
            return new MonthStats(in);
        }

        @Override
        public MonthStats[] newArray(int size) {
            return new MonthStats[size];
        }
    };

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(month, flags);
    }
}
