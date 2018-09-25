package com.learnandroid5.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import com.learnandroid5.R
import com.learnandroid5.adapter.PopularSectionAdapter
import com.learnandroid5.adapter.PromoBannerAdapter
import com.learnandroid5.model.BaseResponse
import com.learnandroid5.model.Popular
import com.learnandroid5.model.PromoBanner
import com.learnandroid5.service.ApiClient
import com.learnandroid5.service.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG : String = MainActivity::class.java.canonicalName
    private lateinit var populars : ArrayList<Popular>
    private lateinit var promoBanner : ArrayList<PromoBanner>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPromoBanner.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        rvPopularsSection.layoutManager = LinearLayoutManager(this)
        val apiInterface : ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        getPopularSection(apiInterface)
        getPromoBanner(apiInterface)
    }

    fun getPopularSection(apiInterface: ApiInterface) {
        val call : Call<BaseResponse> = apiInterface.getPopular()
        call.enqueue(object : Callback<BaseResponse> {
            override fun onFailure(call: Call<BaseResponse>?, t: Throwable?) {
                Log.d("$TAG", "Gagal Fetch Popular Popular")
            }

            override fun onResponse(call: Call<BaseResponse>?, response: Response<BaseResponse>?) {
                populars = response!!.body()!!.populars
                Log.d("$TAG", "Popular size ${populars.size}")
                rvPopularsSection.adapter = PopularSectionAdapter(populars, this@MainActivity)
            }

        })
    }

    fun getPromoBanner(apiInterface: ApiInterface) {
        val call : Call<BaseResponse> = apiInterface.getPromoBanner()
        call.enqueue(object : Callback<BaseResponse> {
            override fun onFailure(call: Call<BaseResponse>?, t: Throwable?) {
                Log.d("$TAG", "Gagal Fetch Popular Popular")
            }

            override fun onResponse(call: Call<BaseResponse>?, response: Response<BaseResponse>?) {
                promoBanner = response!!.body()!!.promoBanners
                Log.d("ccc", "Popular size ${promoBanner.size}")
                rvPromoBanner.adapter = PromoBannerAdapter(promoBanner, this@MainActivity)
            }

        })
    }

}
