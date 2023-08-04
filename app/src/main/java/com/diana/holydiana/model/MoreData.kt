package com.diana.holydiana.model

data class MoreData(
    val country: Country,
    val dataSourceUpdateTime: DataSourceUpdateTime,
    val provinceArray: List<ProvinceArray>,
    val trend: List<Trend>
) {
    data class Country(
        val childStatistic: String,
        val incDoubtful: Int,
        val time: String,
        val totalConfirmed: Int,
        val totalCured: Int,
        val totalDeath: Int,
        val totalDoubtful: Int,
        val totalIncrease: Int
    )

    data class DataSourceUpdateTime(
        val dataSource: String,
        val updateTime: String
    )

    data class ProvinceArray(
        val childStatistic: String,
        val cityArray: List<CityArray>,
        val totalConfirmed: Int,
        val totalCured: Int,
        val totalDeath: Int,
        val totalDoubtful: Int,
        val totalIncrease: Int
    ) {
        data class CityArray(
            val childStatistic: String,
            val totalConfirmed: Int,
            val totalCured: Int,
            val totalDeath: Int,
            val totalDoubtful: Int,
            val totalIncrease: Int
        )
    }

    data class Trend(
        val cure_cnt: Int,
        val day: String,
        val die_cnt: Int,
        val doubt_cnt: Int,
        val fullDay: Int,
        val sure_cnt: Int
    )
}