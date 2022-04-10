package io.dojah.dojahsampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.dojah.dojahandroid.DojahFinancialData
import io.dojah.dojahsampleandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            startDojahFinancials()
        }
    }

    private fun startDojahFinancials() {
        val pages = arrayOf(
            mutableMapOf(
                "page" to "government-data",
                "config" to mutableMapOf(
                    "bvn" to false,
                    "nin" to false,
                    "dl" to false,
                    "mobile" to true,
                    "otp" to false,
                    "selfie" to true
                ),
            ),
            mutableMapOf(
                "page" to "id", "config" to mutableMapOf(
                    "passport" to true,
                    "dl" to true
                )
            )
        )
        DojahFinancialData(
            appId = "62403ccda1b9520034603389",
            publicKey = "prod_pk_WWbNFJeLFr9lA0gkSrlmd1A0F",
            type = "custom",
           config =  mutableMapOf(
                "debug" to false,
                "aml" to false,
                "review_process" to "Automatic",
                "pages" to pages
            ), onError = {
                // Do on error
            }, onSuccess = {
            // Do on success
        }).open(this)
    }
}
