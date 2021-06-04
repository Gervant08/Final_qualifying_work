package com.gervant08.finalqualifyingwork.model.tools

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.gervant08.finalqualifyingwork.R

class OrderNotification(private val context: Context) {

    companion object{
        const val NOTIFICATION_TITLE = "Заказ был создан"
        const val NOTIFICATION_TEXT = "Пожалуйста, приходите к выбранному времени"
        const val CHANNEL_ID = "channelID"
    }

    fun createNotification(notificationTime: String){
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_basket)
            .setContentTitle(NOTIFICATION_TITLE)
            .setContentText("$NOTIFICATION_TEXT $notificationTime")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(200, builder.build())
    }
}