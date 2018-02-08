package co.borucki.easykanban.asyncTask;

import android.os.AsyncTask;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import co.borucki.easykanban.Mail;
public class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
   public Mail m;
    public SendEmailAsyncTask() {
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            m.send();
            return true;
        } catch (AuthenticationFailedException e) {
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}