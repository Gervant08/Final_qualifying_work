package com.gervant08.finalqualifyingwork.model.tools

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.gervant08.finalqualifyingwork.R

class OrderNotification() {
    companion object {
        const val NOTIFICATION_ID = 1
        const val CHANNEL_ID = "channelID"
    }

    fun createNotification(context: Context, contentTitle: String, contentText: String){
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_basket)
            .setContentTitle(contentTitle)
            .setContentText(contentText)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            notify(NOTIFICATION_ID, builder.build()) // посылаем уведомление
        }
    }
}