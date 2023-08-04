package com.diana.holydiana.model

data class AbroadData(
    val code: Int,
    val msg: String,
    val newslist: List<Newslist>
) {
    data class Newslist(
        val cityName: String,
        val confirmedCount: Int,
        val confirmedCountRank: Int,
        val continents: String,
        val countryFullName: String,
        val countryShortCode: String,
        val countryType: Int,
        val curedCount: Int,
        val currentConfirmedCount: Int,
        val deadCount: Int,
        val deadCountRank: Int,
        val deadRate: String,
        val deadRateRank: Int,
        val highDanger: String,
        val highInDesc: String,
        val incrVo: IncrVo,
        val locationId: Int,
        val lowInDesc: String,
        val midDanger: String,
        val modifyTime: Long,
        val outDesc: String,
        val provinceId: String,
        val provinceName: String,
        val provinceShortName: String,
        val showRank: Boolean,
        val statisticsData: String,
        val suspectedCount: Int,
        val yesterdayConfirmedCount: Int,
        val yesterdayLocalConfirmedCount: Int,
        val yesterdayOtherConfirmedCount: Int
    ) {
        data class IncrVo(
            val confirmedIncr: Int,
            val curedIncr: Int,
            val currentConfirmedIncr: Int,
            val deadIncr: Int
        )
    }
}