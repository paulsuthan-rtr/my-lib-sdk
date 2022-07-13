package com.solidfi.mylibrary

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class LibInit : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, authToken: String): Intent {
        return Intent(context, ComposeActivity::class.java).putExtra("AUTH_TOKEN", authToken)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        val data = intent?.getStringExtra("RESULT")
        return if (resultCode == Activity.RESULT_OK && data != null) data
        else null
    }
}