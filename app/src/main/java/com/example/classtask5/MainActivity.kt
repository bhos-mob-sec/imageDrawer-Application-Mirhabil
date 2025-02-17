package com.example.canvas

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classtask5.CustomView
import com.example.classtask5.CustomView.Companion.brushColor
import com.example.classtask5.R
import com.example.classtask5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent(),
        fun(it: Uri?) {
            val galleryUri = it
            try {
                binding.imageView.setImageURI(galleryUri)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        galleryLauncher.launch("image/*")

        binding.color1.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.redselected)
            brushColor = ContextCompat.getColor(this, R.color.red)

        }

        binding.color2.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.orangeselected)
            brushColor = ContextCompat.getColor(this, R.color.orange)
        }

        binding.color3.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.yellowselected)
            brushColor = ContextCompat.getColor(this, R.color.yellow)
        }

        binding.color4.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.lightgreenselected)
            brushColor = ContextCompat.getColor(this, R.color.lightgreen)
        }

        binding.color5.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.lightblueselected)
            brushColor = ContextCompat.getColor(this, R.color.lightblue)
        }

        binding.color6.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.blueselected)
            brushColor = ContextCompat.getColor(this, R.color.blue)
        }

        binding.color7.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.purpleselected)
            brushColor = ContextCompat.getColor(this, R.color.purple)
        }

        binding.color8.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.blackselected)
            brushColor = ContextCompat.getColor(this, R.color.black)
        }

        binding.color9.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.whiteselected)
            brushColor = ContextCompat.getColor(this, R.color.white)
        }

        binding.color10.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.blue2selected)
            brushColor = ContextCompat.getColor(this, R.color.blue2)
        }

        binding.color11.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.lightblue2selected)
            brushColor = ContextCompat.getColor(this, R.color.lightblue2)
        }

        binding.color12.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.greenselected)
            brushColor = ContextCompat.getColor(this, R.color.green)
        }

        binding.color13.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.lightorangeselected)
            brushColor = ContextCompat.getColor(this, R.color.lightorange)
        }

        binding.color14.setOnClickListener {
            resetSelection()
            it.setBackgroundResource(R.drawable.orange2selected)
            brushColor = ContextCompat.getColor(this, R.color.orange2)
        }
        binding.slider.addOnChangeListener { _, value, _ ->
            CustomView.brushRadius = value*6
        }



    }
    private fun resetSelection() {
        binding.color1.setBackgroundResource(R.drawable.red)
        binding.color2.setBackgroundResource(R.drawable.orange)
        binding.color3.setBackgroundResource(R.drawable.yellow)
        binding.color4.setBackgroundResource(R.drawable.lightgreen)
        binding.color5.setBackgroundResource(R.drawable.lightblue)
        binding.color6.setBackgroundResource(R.drawable.blue)
        binding.color7.setBackgroundResource(R.drawable.purple)
        binding.color8.setBackgroundResource(R.drawable.black)
        binding.color9.setBackgroundResource(R.drawable.white)
        binding.color10.setBackgroundResource(R.drawable.blue2)
        binding.color11.setBackgroundResource(R.drawable.lightblue2)
        binding.color12.setBackgroundResource(R.drawable.green)
        binding.color13.setBackgroundResource(R.drawable.lightorange)
        binding.color14.setBackgroundResource(R.drawable.orange2)
    }
}

