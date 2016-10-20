package com.example.changho.changholock;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Changho on 2016-10-09.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("fcm message data ",remoteMessage.getData().toString());
        Map<String, String> params = remoteMessage.getData();
        //Map<String, Object> params = remoteMessage.getData();
        ArrayList<String> arrayList = new ArrayList<String>();

        try {
            JSONObject json = new JSONObject(params);
            JSONArray jsonArray = new JSONArray(json.getString("applist"));
            //Log.d("app1 ",(String)jsonArray.get(0));
            //Log.d("app2 ",(String)jsonArray.get(1));
            arrayList.add((String)jsonArray.get(0));
            arrayList.add((String)jsonArray.get(1));

            // sharedPreferce update
            SharedPreference.setStringArrayPref(this, "urls",arrayList);
        }catch (Exception e){e.printStackTrace();}
    }
}

