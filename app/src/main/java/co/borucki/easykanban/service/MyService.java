package co.borucki.easykanban.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import co.borucki.easykanban.R;
import co.borucki.easykanban.asyncTask.AppConfigurationAsyncTask;
import co.borucki.easykanban.asyncTask.IncomingMessageAsyncTask;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.statics.InternetAccess;

public class MyService extends IntentService {
    private final UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private boolean start = true;

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (InternetAccess.isOnLine(getApplicationContext())) {
            if (mUserRepo.getAllUsers().size() > 0 && start) {
                start = false;
                new IncomingMessageAsyncTask(getApplicationContext(), null, null).execute();
                new AppConfigurationAsyncTask().execute();
            }
        }
    }
}


