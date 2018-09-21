package com.learnandroid5.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.learnandroid5.R
import com.learnandroid5.adapter.PopularsTitleAdapter
import com.learnandroid5.model.Populars
import com.learnandroid5.model.PopularsV2
import com.learnandroid5.service.ApiClient
import com.learnandroid5.service.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG : String = MainActivity::class.java.canonicalName
    private lateinit var populars : ArrayList<Populars>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPopularsTitle.layoutManager = LinearLayoutManager(applicationContext)
        val apiInterface : ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        getPopularMovies(apiInterface)
    }

    fun getPopularMovies(apiInterface: ApiInterface) {
        val call : Call<PopularsV2> = apiInterface.getPopularTitle()
        call.enqueue(object : Callback<PopularsV2> {
            override fun onFailure(call: Call<PopularsV2>?, t: Throwable?) {
                Log.d("$TAG", "Gagal Fetch Popular Populars")
            }

            override fun onResponse(call: Call<PopularsV2>?, response: Response<PopularsV2>?) {
                populars = response!!.body()!!.populars
                Log.d("$TAG", "Populars size ${populars.size}")
                rvPopularsTitle.adapter = PopularsTitleAdapter(populars)
            }

        })
    }
}
