package com.example.uber.Services;

import static com.example.uber.Common.NT_CONTENT;

import com.bumptech.glide.util.Util;
import com.example.uber.Common;
import com.example.uber.Utils.UserUtils;
import com.firebase.geofire.core.GeoHashQuery;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;


public class MessagingServices extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
            UserUtils.updateToken(this,s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String>dataRecv = remoteMessage.getData();
        if(dataRecv!=null){
            Common.showNotification(this, new Random().nextInt(),
                    dataRecv.get(Common.NT_TITLE),
                    dataRecv.get(NT_CONTENT),null);
        }
    }
}
