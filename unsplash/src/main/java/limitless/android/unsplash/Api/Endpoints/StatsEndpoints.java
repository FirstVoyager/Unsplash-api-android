package limitless.android.unsplash.Api.Endpoints;

import limitless.android.unsplash.Api.Model.Stats.MonthStats;
import limitless.android.unsplash.Api.Model.Stats.TotalStats;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Stats for Unsplash
 * Read more --> https://unsplash.com/documentation#stats
 */
public interface StatsEndpoints {

    /**
     * Get a list of counts for all of Unsplash
     */
    @GET("stats/total")
    Call<TotalStats> getTotalStats();

    /**
     * Get the overall Unsplash stats for the past 30 days
     */
    @GET("stats/month")
    Call<MonthStats> getMonthStats();

}
