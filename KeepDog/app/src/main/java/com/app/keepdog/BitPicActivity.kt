package com.app.keepdog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView

class BitPicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bit_pic)
        val intent = intent
        val pic = intent.getIntExtra("pic", 0)
        val photoView = findViewById<PhotoView>(R.id.photoview)
        Glide.with(this).load(pic).into(photoView)
    }
}