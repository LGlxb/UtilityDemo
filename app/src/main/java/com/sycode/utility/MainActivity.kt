package com.sycode.utility

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.sycode.indicatorview.indicators.BallClipRotateMultipleIndicator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img_photo.load("https://images.unsplash.com/photo-1577643816920-65b43ba99fba?ixlib=rb-1.2.1&auto=format&fit=crop&w=3300&q=80") {
            crossfade(true)
        }
        load_view.indicator = BallClipRotateMultipleIndicator()
        //  load_view.show()
             load_view.smoothToShow()
    }
}
