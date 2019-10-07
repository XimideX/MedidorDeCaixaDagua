package com.example.waterboxanalist.ReportsClasses;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.waterboxanalist.FunctionalClasses.WaterBox;
import com.example.waterboxanalist.R;

import java.util.Date;

import static androidx.core.content.ContextCompat.getSystemService;

public class Reports {

    public void CreateNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Channel")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Mensagem de aviso")
                .setContentText("o nível de agua está baixo")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        createNotificationChannel(context);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // notificationId is a unique int for each notification that you must define
        int notificationId = 1;
        notificationManager.notify(notificationId, builder.build());
        notificationId++;
    }

    public void createNotificationChannel(Context context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Meter channel"/*getString(R.string.channel_name)*/;
            String description = "Channel for messaging percent meter"/*getString(R.string.channel_description)*/;
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Channel"/*CHANNEL_ID*/, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(context, NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public WaterBoxHistory checkWaterBoxLevel(WaterBox waterBox) {
        WaterBoxHistory newWaterBoxHistory = new WaterBoxHistory();
        newWaterBoxHistory.setHeight(waterBox.getCurrentHeight());
        newWaterBoxHistory.setTimeOfCheck(new Date());
        return newWaterBoxHistory;
    }
}
