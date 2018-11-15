package com.example.hashi.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyManInfestDeclareReceiver: BroadcastReceiver()
{
    private val TAG = "MyMainfestReceiver"
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive")
        val message = intent?.getStringExtra("data")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}