package com.example.apiconsume.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.apiconsume.databinding.ActivityMainBinding
import com.example.apiconsume.model.DogsProvider
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model: DogsProvider = DogsProvider()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model.getImage().observe(this) { dog ->
            for (img in dog.images) {

                val viewPhoto = ImageView(this)
                viewPhoto.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                binding.albun.addView(viewPhoto)
                Picasso.get().load(img).into(viewPhoto)
            }
        }
    }
}