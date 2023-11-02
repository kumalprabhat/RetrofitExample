package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

        GlobalScope.launch {
            val result = quotesApi.getQuotes(1)
            if (result != null){

                val quoteList = result.body()
                if (quoteList != null){
                    quoteList?.results?.forEach {
                        Log.d("dataLog", it.content)
                    }
                }
            }
        }
    }
}