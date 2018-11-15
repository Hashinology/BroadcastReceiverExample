package com.example.hashi.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var myBroadcastReceiver: MyBroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSendBroadcast.setOnClickListener {
            val intent = Intent()
            intent.action = MY_BROADCAST
            intent.putExtra("data", "This is my message")
            sendBroadcast(intent)
        }

        myBroadcastReceiver = MyBroadcastReceiver()

    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter()
        intentFilter.addAction(MY_BROADCAST)
        registerReceiver(myBroadcastReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(myBroadcastReceiver)
    }
}
