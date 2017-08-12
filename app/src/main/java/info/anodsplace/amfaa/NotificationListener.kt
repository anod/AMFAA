package info.anodsplace.amfaa

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log


/**
 *  @author alex
 *  @date 8/12/2017
 */
class NotificationListener: NotificationListenerService() {

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {

        Log.i("NotificationListener", "**********  onNotificationPosted")
        Log.i("NotificationListener", "ID :" + sbn.id + "\t" + sbn.notification.tickerText + "\t" + sbn.packageName)
        val i = Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE")
        i.putExtra("notification_event", "onNotificationPosted :" + sbn.packageName + "\n")
        sendBroadcast(i)

    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        Log.i("NotificationListener", "********** onNOtificationRemoved")
        Log.i("NotificationListener", "ID :" + sbn.id + "\t" + sbn.notification.tickerText + "\t" + sbn.packageName)
        val i = Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE")
        i.putExtra("notification_event", "onNotificationRemoved :" + sbn.packageName + "\n")

        sendBroadcast(i)
    }
}