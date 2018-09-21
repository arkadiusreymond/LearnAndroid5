package com.learnandroid5.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.learnandroid5.R
import com.learnandroid5.adapter.PopularsTitleAdapter
import com.learnandroid5.model.PopularResponse
import com.learnandroid5.model.Popular
import com.learnandroid5.service.ApiClient
import com.learnandroid5.service.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popular_section.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG : String = MainActivity::class.java.canonicalName
    private lateinit var populars : ArrayList<Popular>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPopularsTitle.layoutManager = LinearLayoutManager(this)
        val apiInterface : ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        getPopularMovies(apiInterface)
    }

    fun getPopularMovies(apiInterface: ApiInterface) {
        val call : Call<PopularResponse> = apiInterface.getPopularTitle()
        call.enqueue(object : Callback<PopularResponse> {
            override fun onFailure(call: Call<PopularResponse>?, t: Throwable?) {
                Log.d("$TAG", "Gagal Fetch Popular Popular")
            }

            override fun onResponse(call: Call<PopularResponse>?, response: Response<PopularResponse>?) {
                populars = response!!.body()!!.populars
                Log.d("$TAG", "Popular size ${populars.size}")
                rvPopularsTitle.adapter = PopularsTitleAdapter(populars, this@MainActivity)
            }

        })
    }

}
