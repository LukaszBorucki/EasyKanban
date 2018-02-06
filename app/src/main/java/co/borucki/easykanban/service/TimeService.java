package co.borucki.easykanban.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import co.borucki.easykanban.asyncTask.AppConfigurationAsyncTask;
import co.borucki.easykanban.asyncTask.IncomingMessageAsyncTask;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.statics.InternetAccess;

public class TimeService extends Service {
    private final UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    public static final long NOTIFY_INTERVAL = 1000 * 60 * 20;
    private Handler mHandler = new Handler();
    private Timer mTimer = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        if (mTimer != null) {
            mTimer.cancel();
        } else {
            mTimer = new Timer();
        }
        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
    }

    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    if (InternetAccess.isOnLine(getApplicationContext())) {
                        if (mUserRepo.getAllUsers().size() > 0) {
                            new IncomingMessageAsyncTask(getApplicationContext(), null, null).execute();
                            new AppConfigurationAsyncTask().execute();
                        }
                    }
                }

            });
        }

    }
}
