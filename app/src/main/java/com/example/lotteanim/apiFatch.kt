import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun fetchStockData(symbol: String) {
    // Call the API method
    val call = RetrofitInstance.api.getStockData(symbol = symbol, apiKey = "5KWFGVOV4IJD8UYE")

    // Handle the response asynchronously
    call.enqueue(object : Callback<StockResponse> {
        override fun onResponse(call: Call<StockResponse>, response: Response<StockResponse>) {
            if (response.isSuccessful) {
                val stockResponse = response.body()
                // Handle the successful response
                stockResponse?.let {
                    // Process the stock data, e.g., update UI or log it
                    println("Stock data: $it")
                }
            } else {
                // Handle error response
                println("Error: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<StockResponse>, t: Throwable) {
            // Handle failure, e.g., network error
            println("Failed to fetch stock data: ${t.message}")
        }
    })
}
