package info.anodsplace.amfaa

import android.content.Intent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import android.support.v4.content.LocalBroadcastManager

/**
 *  @author alex
 *  @date 8/12/2017
 */
class NotificationStatusListener : NotificationListenerService() {

    companion object {
        const val action = "info.anodsplace.amfaa.action.notification"
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {

        val pack = sbn.packageName
        val extras = sbn.notification.extras
        val title = extras.getString("android.title")
        val text = extras.getCharSequence("android.text")!!.toString()

        Log.i("Package", pack)
        Log.i("Title", title)
        Log.i("Text", text)

        val msgrcv = Intent(action)
        msgrcv.putExtra("package", pack)
        msgrcv.putExtra("title", title)
        msgrcv.putExtra("text", text)

        Log.i("NotificationStatusListener","Notification: $msgrcv")

        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(msgrcv)

    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        Log.i("NotificationStatusListener","Notification Removed")
    }
}