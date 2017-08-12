package info.anodsplace.amfaa

import android.app.Activity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openButton.setOnClickListener {
            val launchIntent = packageManager.getLaunchIntentForPackage(AppleMusic.packageName)
            Log.d("AMFAA", launchIntent.toString())
            startActivity(launchIntent)
        }

    }
}
