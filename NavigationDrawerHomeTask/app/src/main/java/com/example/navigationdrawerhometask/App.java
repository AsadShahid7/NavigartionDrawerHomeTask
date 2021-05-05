package com.example.navigationdrawerhometask;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends android.app.Application{

    public static final String CHANNEL_1_ID="channel1";
    public static final String CHANNEL_2_ID="channel2";
    public static final String CHANNEL_3_ID="channel3";
    //create onCreate for having channels

    @Override
    public void onCreate() {
        super.onCreate();

        //now create function
        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            //first channel

            NotificationChannel channel1=new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("IMPORTANT! Channel 1");

            //second channel

            NotificationChannel channel2=new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("IMPORTANT! Channel 2");

            //manage

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);


        }
    }
}
