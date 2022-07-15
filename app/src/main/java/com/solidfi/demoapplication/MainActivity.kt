package com.solidfi.demoapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.solidfi.mylibrary.LibInit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        libResult.launch("ejroifndsij cisdhiusdhfsj sidhfpsodhhpoi")
    }

    // Custom activity result contract
    private val libResult =
        registerForActivityResult(LibInit()) { result ->
            // parseResult will return this as string?
            if (result != null) {
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Error!!", Toast.LENGTH_LONG).show()
            }
        }

}