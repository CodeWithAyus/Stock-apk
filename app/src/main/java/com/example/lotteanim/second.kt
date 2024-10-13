package com.example.lotteanim

import StockResponse
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class second : AppCompatActivity() {
    private var timeTaken: Long = 0
    private val finalTime: Long = 2000
    private lateinit var stockTextView: TextView
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        stockTextView = findViewById(R.id.stockTextView) // Make sure to have this TextView in your layout
        submitBtn = findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {
            fetchStockData("AAPL") // Example stock symbol
        }
    }

    private fun fetchStockData(symbol: String) {
        val call = RetrofitInstance.api.getStockData(symbol = symbol, apiKey = "5KWFGVOV4IJD8UYE")

        call.enqueue(object : Callback<StockResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<StockResponse>, response: Response<StockResponse>) {
                if (response.isSuccessful) {
                    val stockResponse = response.body()
                    stockResponse?.let {
                        // Update UI with stock data
                        stockTextView.text = "Stock Data: $it"
                    }
                } else {
                    stockTextView.text = "Error: ${response.errorBody()?.string()}"
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<StockResponse>, t: Throwable) {
                stockTextView.text = "Failed to fetch stock data: ${t.message}"
            }
        })
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - timeTaken < finalTime) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(this, "Double tap to exit", Toast.LENGTH_SHORT).show()
            timeTaken = currentTime
        }
    }
}
