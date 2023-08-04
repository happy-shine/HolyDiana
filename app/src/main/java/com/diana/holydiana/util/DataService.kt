package com.diana.holydiana.util

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.diana.holydiana.model.AbroadData
import com.diana.holydiana.model.ChinaData
import com.diana.holydiana.model.MoreData
import com.google.gson.Gson

class DataService(private val context: Context) {
    private val queue = Volley.newRequestQueue(context)

    fun getChinaData(callback: (ChinaData) -> Unit) {
        val url = "https://api.tianapi.com/ncov/index?key=a33282e5f68a2ca38fa22dde03b07111"
        val stringRequest = StringRequest(Request.Method.GET, url,
            {
                val chinaData: ChinaData = Gson().fromJson(it, ChinaData::class.java)
                Log.d(TAG, "getChinaData $chinaData")
                callback(chinaData)
            }, {
                Log.d(TAG, "getChinaData $it")
            })
        queue.add(stringRequest)

    }

    fun getAbroadData(callback: (AbroadData) -> Unit) {
        val url = "https://api.tianapi.com/ncovabroad/index?key=a33282e5f68a2ca38fa22dde03b07111"
        val stringRequest = StringRequest(Request.Method.GET, url,
            {
                val abroadData = Gson().fromJson(it, AbroadData::class.java)
                Log.d(TAG, "getAbroadData $abroadData")
                callback(abroadData)
            }, {
                Log.d(TAG, "getAbroadData $it")
            })
        queue.add(stringRequest)
    }

    fun getMoreData(callback: (MoreData) -> Unit) {
        val url = "https://ncovdata.market.alicloudapi.com/ncov/cityDiseaseInfoWithTrend"
        val stringRequest = object : StringRequest(Request.Method.GET, url,
            {
                val moreData = Gson().fromJson(it, MoreData::class.java)
                Log.d(TAG, "getMoreData $moreData")
                callback(moreData)
            }, {
                Log.d("More", "getMoreData $it")
            }) {
            override fun getHeaders(): Map<String, String> {
                return mapOf("Authorization" to "APPCODE e9d8741fd7d54c7aadb5fff284f8a8c9")
            }
        }
        queue.add(stringRequest)

    }


    companion object {
        const val TAG = "DataService"

        fun setTextColor(a: Int, b: Int, type: String, textView: TextView) {
            val aa = a.toString()
            val bb = b.toString()
            val ss = SpannableString("较昨日${a}\n${b}\n${type}")
            ss.setSpan(
                ForegroundColorSpan(Color.parseColor("#00FF00")),
                3,
                3 + aa.length,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
            )
            ss.setSpan(
                ForegroundColorSpan(Color.parseColor("#FF0000")),
                3 + aa.length,
                4 + aa.length + bb.length,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
            )
            textView.text = ss
        }

        fun setTextColor(a: Int, type: String, textView: TextView) {
            val aa = a.toString()
            val ss = SpannableString("${a}\n${type}")
            ss.setSpan(
                ForegroundColorSpan(Color.parseColor("#FF0000")),
                0,
                aa.length,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
            )
            textView.text = ss
        }
    }
}
