package com.example.hashi.broadcastreceiverexample

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    private val TAG : String = "MyIntentService"

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent")

        val  newIntet = Intent()
        val message = intent?.getStringExtra("data")
        newIntet.putExtra("data", message)
        newIntet.action = MY_SERVICE_BROADCAST
        newIntet.`package` =  "com.example.hashi.broadcastreceiverexample"
        sendBroadcast(newIntet)
    }
}