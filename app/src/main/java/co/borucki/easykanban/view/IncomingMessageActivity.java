package co.borucki.easykanban.view;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.R;
import co.borucki.easykanban.adapter.IncomingMessageAdapter;
import co.borucki.easykanban.model.IncomingMessage;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.statics.SampleData;

public class IncomingMessageActivity extends AppCompatActivity {
    private UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();
    private User mUser;
    private long userId;
    private IncomingMessageAdapter mAdapter;
    @BindView(R.id.incoming_message_scroll_view)
    RecyclerView mScrollView;
    @BindView(R.id.incoming_message_swipe_refresh)
    SwipeRefreshLayout mRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_message);
        Intent intent = getIntent();
        userId = intent.getLongExtra("USER_ID", 0);
        mUser = mUserRepo.getUserById(userId);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mScrollView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        mScrollView.addItemDecoration(dividerItemDecoration);
        mAdapter = new IncomingMessageAdapter(this);
        mScrollView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                SampleData.loadMessages();
                refreshData();
                mRefreshLayout.setRefreshing(false);
            }
        });
        refreshData();
        mAdapter.setOnClickListener(mOnClickListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }

    private final View.OnClickListener mOnClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    IncomingMessage message = (IncomingMessage) v.getTag();
                    Intent intent = new Intent(getApplicationContext(), SingleMessageView.class);
                    intent.putExtra("MESSAGE_ID", message.getId());
                    intent.putExtra("USER_ID", userId);
                    startActivity(intent);
                }
            };

    private void refreshData() {
        mAdapter.setData(mMessageRepo.getAllMessages());
    }
}