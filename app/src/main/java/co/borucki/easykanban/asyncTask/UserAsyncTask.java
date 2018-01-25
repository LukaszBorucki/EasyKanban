package co.borucki.easykanban.asyncTask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.borucki.easykanban.dto.UserDTO;
import co.borucki.easykanban.dto.mapper.Mapper;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.view.LoginActivity;

public class UserAsyncTask extends AsyncTask<Void, Void, List<UserDTO>> {
    private final UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();
    private List<String> spinnerArray;
    private ArrayAdapter<String> adapter;
    private ProgressDialog progressDialog;
    private Activity loginActivity;

    public UserAsyncTask(List<String> spinnerArray, ArrayAdapter<String> adapter, Activity loginActivity) {
        this.spinnerArray = spinnerArray;
        this.adapter = adapter;
        this.loginActivity = loginActivity;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(loginActivity);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading Users data");
        progressDialog.show();
    }

    @Override
    protected List<UserDTO> doInBackground(Void... voids) {

        String link = "http://www.borucki.co/api_v2/kanban/getAllUsers?id="
                + mCustomRepo.getIMEI();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, UserDTO[].class));
    }

    @Override
    protected void onPostExecute(List<UserDTO> userDTOS) {
        List<UserDTO> toUpdateList = new ArrayList<>();
        List<UserDTO> toSaveList = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            if (userDTO.isForceChanges() > 0) {
                toUpdateList.add(userDTO);
            } else {
                toSaveList.add(userDTO);
            }
        }
        mUserRepo.updateUser(Mapper.fromUserDTOToUser(toUpdateList));
        mUserRepo.saveUser(Mapper.fromUserDTOToUser(toSaveList));
        if (adapter != null && spinnerArray != null) {
            for (User user : mUserRepo.getAllUsers()) {
                spinnerArray.add(user.getName() + " " + user.getSurname());
            }
            adapter.notifyDataSetChanged();
        }
        progressDialog.dismiss();
    }
}
