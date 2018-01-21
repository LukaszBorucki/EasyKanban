package co.borucki.easykanban.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.R;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;
import co.borucki.easykanban.statics.CustomLayoutViewSetup;

public class MainActivity extends AppCompatActivity {
    private final IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();
    @BindView(R.id.usedProductButton)
    RelativeLayout mUsedProductButton;
    @BindView(R.id.usedProductButtonText)
    TextView mUsedProductButtonText;
    @BindView(R.id.usedProductButtonBadge)
    TextView mUsedProductButtonBadge;
    @BindView(R.id.receivedProductButton)
    RelativeLayout mReceivedProductButton;
    @BindView(R.id.receivedProductButtonText)
    TextView mReceivedProductButtonText;
    @BindView(R.id.receivedProductButtonBadge)
    TextView mReceivedProductButtonBadge;
    @BindView(R.id.messageButton)
    RelativeLayout mMessageButton;
    @BindView(R.id.messageButtonText)
    TextView mMessageButtonText;
    @BindView(R.id.messageButtonBadge)
    TextView mMessageButtonBadge;
    @BindView(R.id.stocktakingProductButton)
    RelativeLayout mStocktakingProductButton;
    @BindView(R.id.stocktakingProductButtonText)
    TextView mStocktakingProductButtonText;
    @BindView(R.id.stocktakingProductButtonBadge)
    TextView mStocktakingProductButtonBadge;
    @BindView(R.id.main_activity_logo)
    ImageView mLogo;
    @BindView(R.id.main_activity_author)
    TextView mAuthor;
    private long userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpButtons();
        setButtonOnClick();
        Intent intent = getIntent();
        userId = intent.getLongExtra("USER_ID", 0);
        CustomLayoutViewSetup.SetMainLayoutView(mLogo, mAuthor);
        CustomLayoutViewSetup.SetMessageBadge(mMessageButtonBadge);


    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpButtons();
        setButtonOnClick();
        CustomLayoutViewSetup.SetMainLayoutView(mLogo, mAuthor);
        CustomLayoutViewSetup.SetMessageBadge(mMessageButtonBadge);

    }

    private void setButtonOnClick() {
        mUsedProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ScannedProductActivity.class);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("LIST_TYPE", ScannedType.USED.getType().toUpperCase());
                v.getContext().startActivity(intent);
            }
        });
        mReceivedProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ScannedProductActivity.class);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("LIST_TYPE", ScannedType.RECEIVED.getType().toUpperCase());
                v.getContext().startActivity(intent);
            }
        });
        mMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), IncomingMessageActivity.class);
                intent.putExtra("USER_ID", userId);
                v.getContext().startActivity(intent);
            }
        });
        mStocktakingProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ScannedProductActivity.class);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("LIST_TYPE", ScannedType.STOCKTAKING.getType().toUpperCase());
                v.getContext().startActivity(intent);
            }
        });
    }

    private void setUpButtons() {
        CustomLayoutViewSetup.SetButtonView(mUsedProductButton, mUsedProductButtonText, mUsedProductButtonBadge, "Used product");
        CustomLayoutViewSetup.SetButtonView(mReceivedProductButton, mReceivedProductButtonText, mReceivedProductButtonBadge, "Received product");
        CustomLayoutViewSetup.SetButtonView(mMessageButton, mMessageButtonText, mMessageButtonBadge, "Incoming message");
        CustomLayoutViewSetup.SetButtonView(mStocktakingProductButton, mStocktakingProductButtonText, mStocktakingProductButtonBadge, "Stocktaking");
    }

    void startLoginIntent() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
