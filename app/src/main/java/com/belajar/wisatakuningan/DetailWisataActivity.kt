package com.belajar.wisatakuningan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailWisataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        val bar = supportActionBar
        bar?.title = "Detail Wisata Kuningan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nameWisata: TextView = findViewById(R.id.tv_item_name)
        val descriptionWisata: TextView = findViewById(R.id.tv_item_description)
        val photoWisata: ImageView = findViewById(R.id.img_item_photo)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESC)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        nameWisata.text = name
        descriptionWisata.text = description
        photoWisata.setImageResource(photo)

        val shareButton = findViewById<Button>(R.id.btn_bagikan)

        shareButton.setOnClickListener {
            val shareText = "Nama Tempat:\n$name\n\nDeskripsi:\n$description"

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)

            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}