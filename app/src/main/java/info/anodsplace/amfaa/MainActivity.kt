package info.anodsplace.amfaa

import android.app.Activity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.support.v4.content.LocalBroadcastManager

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(notificationListener, IntentFilter(NotificationStatusListener.action))
        openButton.setOnClickListener {
            val launchIntent = packageManager.getLaunchIntentForPackage(AppleMusic.packageName)
            Log.d("AMFAA", launchIntent.toString())
            startActivity(launchIntent)
        }

        permissions.setOnClickListener {
            val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
            startActivity(intent)
        }
    }

    private val notificationListener = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d("AMFAA", intent.toString())
        }
    }
}
