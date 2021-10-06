package com.byoscar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.byoscar.BuildConfig.DEBUG
import com.byoscar.model.CoctelCliente
import com.byoscar.model.CoctelesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        //testCorrutina()

        testRetrofit()

    }
//    fun testCorrutina(){
//        lifecycleScope.launch {
//
//            val coctelesByLeter = CoctelCliente.service.getCoctelesList('a')
//            val body = withContext(Dispatchers.IO){coctelesByLeter.execute().body()}
//            if (body != null) {
//                Log.d("body", ""+body.cocteles.size)
//            } else {
//                Log.d("body", "No se trajeron los cocteles")
//            }
//        }
//    }
    fun testRetrofit(){
        thread {
            val coctelesByLeter = CoctelCliente.service.getCoctelesList('a')
            val body: CoctelesResponse? = coctelesByLeter.execute().body()

            if (body != null) {
                val b = body.toString()
                Log.d("body", "body no es nulo" + b)
            } else {
                Log.d("body", "No se trajeron los cocteles")
            }
        }
    }
}