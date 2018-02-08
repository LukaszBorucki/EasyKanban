package co.borucki.easykanban.statics;

import android.app.Activity;
import android.content.Intent;

import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.view.LoginActivity;

public class Session {
    private static final CustomDataRepository mRepository = CustomDataRepositoryImpl.getInstance();

    public static boolean checkIfSessionIsActive(Activity activity) {
        if(DateTimeCounter.getPeriodInSeconds(mRepository.getLoginTimestamp())>60*3){
            Intent intent = new Intent(activity, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            activity.startActivity(intent);
            return false;
        }
        else{
            mRepository.setLoginTimestamp(DateTimeCounter.getDateTime());
            return true;
        }
    }
}
