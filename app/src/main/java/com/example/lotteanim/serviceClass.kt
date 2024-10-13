import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlphaVantageService {
    @GET("5KWFGVOV4IJD8UYE") // Ensure this matches the Alpha Vantage API endpoint
    fun getStockData(
        @Query("function") function: String = "TIME_SERIES_INTRA DAY",
        @Query("symbol") symbol: String,
        @Query("interval") interval: String = "1min",
        @Query("5KWFGVOV4IJD8UYE") apiKey: String
    ): Call<StockResponse>
}
