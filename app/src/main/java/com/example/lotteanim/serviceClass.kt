import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlphaVantageService {
    @GET("query")
    fun getStockData(
        @Query("function") function: String = "TIME_SERIES_INTRADAY",
        @Query("symbol") symbol: String,
        @Query("interval") interval: String = "1min",
        @Query("apikey") apiKey: String
    ): Call<StockResponse>
}
