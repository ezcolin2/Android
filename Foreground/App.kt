package com.example.foreserviceposting

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application(){
    companion object {
        const val FORE_CHANNEL_ID = "forenotification"
    }
    override fun onCreate(){
        super.onCreate()
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            getSystemService(NotificationManager::class.java).run{
                val foreChannel = NotificationChannel(
                    FORE_CHANNEL_ID, //아이디
                    "Foreground", //이름
                    NotificationManager.IMPORTANCE_LOW //중요도. 높을수록 사용자에게 알리는 강도가 높아짐

                )
                createNotificationChannel(foreChannel)
            }
        }
    }
}
