data class MetaData(
    val information: String,
    val symbol: String,
    val lastRefreshed: String,
    val interval: String,
    val outputSize: String,
    val timeZone: String
)

data class TimeSeriesData(
    val open: String,
    val high: String,
    val low: String,
    val close: String,
    val volume: String
)

data class StockResponse(
    val metaData: MetaData,
    val timeSeries: Map<String, TimeSeriesData>
)
