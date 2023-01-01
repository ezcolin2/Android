package com.example.alarmmanagerforposting

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.alarmmanagerforposting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE)
            getSystemService(AlarmManager::class.java).setExact(
                AlarmManager.RTC_WAKEUP,
                SystemClock.elapsedRealtime()+5*1000,// 현재 시각으로부터 5초 뒤
                pendingIntent
            )
//            AndroidManifest.xml의 application 밖에서
//            <uses- Manifest.permission android:name="android.permission.SCHEDULE_EXACT_ALARM"/>
        }
    }
}
