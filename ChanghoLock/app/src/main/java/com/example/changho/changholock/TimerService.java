package com.example.changho.changholock;

/**
 * Created by changho on 2016-03-27.
 */
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class TimerService extends Service {
    //variables for timer
    private Handler mHandler;
    private Runnable mRunnable;

    public TimerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service start", Toast.LENGTH_LONG).show();
        //

        mRunnable = new Runnable() {
            Intent intent = new Intent(getApplicationContext(), TimeOut.class);
            @Override
            public void run() {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
               // Log.i("detect","detect");
            }
        };

        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 10000);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
        mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }

    //me: onStratCommand에 주 수행 작업을 코딩하는 듯
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        return START_REDELIVER_INTENT;
    }
}

