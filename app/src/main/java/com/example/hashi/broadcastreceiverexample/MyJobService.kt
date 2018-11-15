package com.example.hashi.broadcastreceiverexample

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.widget.Toast


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MyJobService : JobService() {
    val TAG : String = "MyJobService"

    override fun onStopJob(p0: JobParameters?): Boolean {
        return false
    }

    override fun onStartJob(jobParameters: JobParameters?): Boolean {
        Log.d(TAG, "onStartService")

        val bundle = jobParameters?.extras
        val message = bundle?.getString("data")
        val intent = Intent(applicationContext, MyIntentService::class.java)
        intent.putExtra("data", message)

        Toast.makeText(this, "you have Clicked Start Message: ", Toast.LENGTH_SHORT).show()

        applicationContext.startService(intent)


        return false
        //return true
    }
}