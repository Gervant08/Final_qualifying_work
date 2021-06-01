package com.gervant08.finalqualifyingwork.model.tools

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.gervant08.finalqualifyingwork.R

class OrderNotificationReceiver : BroadcastReceiver(){

    companion object{
        const val NOTIFICATION_TITLE = "Ваш заказ скоро будет готов"
        const val NOTIFICATION_TEXT = "Через 30 минут ваш заказ будет готов. Приходите, мы вас ждем"
        const val CHANNEL_ID = "channelID"
    }
    override fun onReceive(context: Context, intent: Intent) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_basket)
            .setContentTitle(NOTIFICATION_TITLE)
            .setContentText(NOTIFICATION_TEXT)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(200, builder.build())
    }
}