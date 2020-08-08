package com.evanandroid.apps.onbidproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.progressbar.*
import kotlin.concurrent.thread

class ProgressBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progressbar)

        thread(start=true) {
            Thread.sleep(1000)
            runOnUiThread {
                showProgress(false)
            }

            val intent = Intent(baseContext, MainActivity_Hyuk::class.java)
            startActivity(intent)
        }
    }

    fun showProgress(show : Boolean) {
        if (show) {
            progressLayout.visibility = View.VISIBLE
        } else {
            progressLayout.visibility = View.GONE
        }
    }
}

