package co.borucki.easykanban.asyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.borucki.easykanban.adapter.IncomingMessageAdapter;
import co.borucki.easykanban.dto.IncomingMessageDTO;
import co.borucki.easykanban.dto.mapper.Mapper;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;

public class IncomingMessageAsyncTask extends AsyncTask<Void, Void, List<IncomingMessageDTO>> {
    private final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();
    private final IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();
    private SwipeRefreshLayout mRefreshLayout;
    private IncomingMessageAdapter mAdapter;
    private final Context context;

    public IncomingMessageAsyncTask(Context context, SwipeRefreshLayout mRefreshLayout, IncomingMessageAdapter mAdapter) {
        this.mAdapter = mAdapter;
        this.mRefreshLayout = mRefreshLayout;
        this.context = context;
    }

    @Override
    protected List<IncomingMessageDTO> doInBackground(Void... voids) {
        String id = mCustomRepo.isCommercialLicence() ? String.valueOf(mCustomRepo.getIMEI()) : "demo";
        String link = "http://www.borucki.co/api_v2/kanban/getNewMessage?id="
                + id
                + "&start="
                + mMessageRepo.getLastMessageId();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
//        return Arrays.asList(restTemplate.getForObject(link, IncomingMessageDTO[].class));
        List<IncomingMessageDTO> incomming = new ArrayList<>();
        IncomingMessageDTO incomingMessageDTO = new IncomingMessageDTO();
        incomingMessageDTO.setId(1);
        incomingMessageDTO.setFrom("łukasz");
        incomingMessageDTO.setContents("proszę zrobić inwentaryzację");
        incomingMessageDTO.setSubject("inwent");


        incomming.add(incomingMessageDTO);

        return incomming;
    }

    @Override
    protected void onPostExecute(List<IncomingMessageDTO> incomingMessageDTOS) {
        mMessageRepo.saveMessages(Mapper.fromIncomingMessageDTOToIncomingMessage(incomingMessageDTOS));
        if (mAdapter != null && mRefreshLayout != null) {
            mAdapter.setData(mMessageRepo.getAllMessages());
            mRefreshLayout.setRefreshing(false);
        } else {
//TODO make notification
        }
    }
}
