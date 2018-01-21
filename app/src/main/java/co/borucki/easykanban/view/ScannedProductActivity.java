package co.borucki.easykanban.view;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.R;
import co.borucki.easykanban.adapter.ScannedProductAdapter;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.statics.CustomLayoutViewSetup;

public class ScannedProductActivity extends AppCompatActivity {
    private UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private ScannedProductRepositoryImpl mScannedProductRepo = ScannedProductRepositoryImpl.getInstance();
    private ScannedProductAdapter mAdapter;
    private long mUserId;
    private User mUser;
    private ScannedType list_type;
    @BindView(R.id.scanned_product_scroll_view)
    RecyclerView mScrollView;
    @BindView(R.id.scanned_product_swipe_refresh)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.scanned_product_tool_bar)
    Toolbar navigationToolBar;
    @BindView(R.id.send_lists)
    Button mSendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_product);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mUserId = intent.getLongExtra("USER_ID", -1);
        mUser = mUserRepo.getUserById(mUserId);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mScrollView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        mScrollView.addItemDecoration(dividerItemDecoration);
        mAdapter = new ScannedProductAdapter(this);
        mScrollView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                mRefreshLayout.setRefreshing(false);
            }
        });
        refreshData();
        CustomLayoutViewSetup.SetScannedLayout(navigationToolBar);
        list_type = ScannedType.valueOf(intent.getStringExtra("LIST_TYPE").toUpperCase());


        switch (list_type) {
            case USED:
                navigationToolBar.setTitle(R.string.scanned_product_tool_bar_title_used_product);
                mSendList.setText(R.string.scanned_product_send_used_list);
                break;
            case RECEIVED:
                navigationToolBar.setTitle(R.string.scanned_product_tool_bar_title_delivered_product);
                mSendList.setText(R.string.scanned_product_send_delivered_list);
                break;
            case STOCKTAKING:
                navigationToolBar.setTitle(R.string.scanned_product_tool_bar_title_stocktaking);
                mSendList.setText(R.string.scanned_product_send_stocktaking_list);
                break;
        }


    }
    private void refreshData() {
        mAdapter.setData(mScannedProductRepo.getAllScannedProductByType(list_type.getType().toUpperCase()));
    }
}
