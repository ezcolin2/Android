package com.example.foreserviceposting

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val SERVICE_ID = 1
class ForeService : Service(){
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, //context
            0, //request code
            intent, //flag
            PendingIntent.FLAG_IMMUTABLE //flag

        )
        val notiBuilder = NotificationCompat.Builder(this,App.FORE_CHANNEL_ID)
            .setContentTitle("foreground")
            .setContentText("진행 상황 : 0")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)

        startForeground(SERVICE_ID,notiBuilder.build())

        GlobalScope.launch{
            val manager = getSystemService(NotificationManager::class.java)
            for(i in 1..100){
                notiBuilder.setContentText("진행 상황 $i")
                delay(100)
                manager.notify(SERVICE_ID, notiBuilder.build()) //변화를 알려줌
            }
            stopForeground(true)
            stopSelf()
        }


        return START_NOT_STICKY
    }

}
