package com.diana.holydiana.model

data class ChinaData(
    val code: Int,
    val msg: String,
    val newslist: List<Newslist>
) {
    data class Newslist(
        val desc: Desc,
        val news: List<New>,
        val riskarea: Riskarea
    ) {
        data class Desc(
            val confirmedCount: Int,
            val confirmedIncr: Int,
            val createTime: Long,
            val curedCount: Int,
            val curedIncr: Int,
            var currentConfirmedCount: Int,
            var currentConfirmedIncr: Int,
            val deadCount: Int,
            val deadIncr: Int,
            val foreignStatistics: ForeignStatistics,
            val globalStatistics: GlobalStatistics,
            val highDangerCount: Int,
            val id: Int,
            val midDangerCount: Int,
            val modifyTime: Long,
            val note1: String,
            val note2: String,
            val note3: String,
            val remark1: String,
            val remark2: String,
            val remark3: String,
            val seriousCount: Int,
            val seriousIncr: Int,
            val suspectedCount: Int,
            val suspectedIncr: Int,
            val yesterdayConfirmedCountIncr: Int,
            val yesterdaySuspectedCountIncr: Int
        ) {
            data class ForeignStatistics(
                val confirmedCount: Int,
                val confirmedIncr: Int,
                val curedCount: Int,
                val curedIncr: Int,
                val currentConfirmedCount: Int,
                val currentConfirmedIncr: Int,
                val deadCount: Int,
                val deadIncr: Int,
                val suspectedCount: Int,
                val suspectedIncr: Int
            )

            data class GlobalStatistics(
                val confirmedCount: Int,
                val confirmedIncr: Int,
                val curedCount: Int,
                val curedIncr: Int,
                val currentConfirmedCount: Int,
                val currentConfirmedIncr: Int,
                val deadCount: Int,
                val deadIncr: Int,
                val yesterdayConfirmedCountIncr: Int
            )
        }

        data class New(
            val id: Int,
            val infoSource: String,
            val pubDate: Long,
            val pubDateStr: String,
            val sourceUrl: String,
            val summary: String,
            val title: String
        )

        data class Riskarea(
            val high: List<String>,
            val mid: List<String>
        )
    }
}