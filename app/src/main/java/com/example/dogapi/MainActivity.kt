package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.dogapi.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPesquisar.setOnClickListener { getImage() }
    }

    private fun getImage() {
        val url = "https://dog.ceo/"
        val retrofitClient = retrofitInstance(url)
        val endpoint = retrofitClient.create()

//        val urlImage = "https://media.istockphoto.com/photos/canadian-flag-with-nice-satin-texture-picture-id171263903?k=20&m=171263903&s=170667a&w=0&h=ounPYNo_TU_Vg5dLT39PzcX0uxf2BB0DvoXZF4P_dPI="
//        Picasso.get().load(urlImage).into(binding.imageDog)
    }

    private fun retrofitInstance(url: String): Retrofit {
        return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
    }
}