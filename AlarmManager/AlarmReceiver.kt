package com.example.alarmmanagerforposting

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
const val ALARM_NOTI_ID = 1
//receiver를 만들고 나면 manifest application 안에 receiver를 등록해야한다.
//<receiver android:name=".AlarmReceiver"/>
class AlarmReceiver : BroadcastReceiver(){


    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let{
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                context, //context
                0, //request code
                intent, //flag
                PendingIntent.FLAG_IMMUTABLE //flag

            )
            val notiBuilder = NotificationCompat.Builder(context,App.ALARM_CHANNEL_ID)
                .setContentTitle("alarm manager")
                .setContentText("alarm complete")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)

            context.getSystemService(NotificationManager::class.java)
                .notify(ALARM_NOTI_ID, notiBuilder.build())
        }
    }

}
