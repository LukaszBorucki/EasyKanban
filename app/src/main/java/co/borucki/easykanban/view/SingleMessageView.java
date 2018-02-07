package co.borucki.easykanban.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.easykanban.R;
import co.borucki.easykanban.model.EventLog;
import co.borucki.easykanban.model.IncomingMessage;
import co.borucki.easykanban.repository.EventLogRepository;
import co.borucki.easykanban.repository.EventLogRepositoryImpl;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;
import co.borucki.easykanban.statics.CustomLayoutViewSetup;
import co.borucki.easykanban.statics.DateTimeCounter;
import co.borucki.easykanban.statics.Session;

public class SingleMessageView extends AppCompatActivity {
    private final IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();
    private final EventLogRepository mLogRepo = EventLogRepositoryImpl.getInstance();
    private long userId;
    private long messageId;
    private IncomingMessage message;
    private Runnable runnable;
    private Handler handler;
    private boolean changedReadMessageStatus = false;

    @BindView(R.id.single_message_from)
    TextView mFrom;
    @BindView(R.id.single_message_subject)
    TextView mSubject;
    @BindView(R.id.single_message_text)
    TextView mText;
    @BindView(R.id.single_message_author)
    TextView mAuthor;
    @BindView(R.id.single_message_logo)
    ImageView mLogo;
    @BindView(R.id.delete_message)
    Button mDeleteButton;
    @BindView(R.id.single_message_view)
    RelativeLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_message_view);
        ButterKnife.bind(this);
        Session.checkIfSessionIsActive(this);
        Intent intent = getIntent();
        userId = intent.getLongExtra("USER_ID", -1);
        messageId = intent.getLongExtra("MESSAGE_ID", -1);
        message = mMessageRepo.getMessageById(messageId);
        CustomLayoutViewSetup.setSingleMessageView(mLayout, mLogo, mFrom, mSubject, mText, mAuthor, mDeleteButton, this);
        mFrom.setText(message.getFrom());
        mSubject.setText(message.getSubject());
        mText.setText(message.getContents());
        mText.setTextSize(20);
        mText.setMovementMethod(new ScrollingMovementMethod());
        changedReadMessageStatus = message.isRead();
        handler = new Handler();
        handler.postDelayed(runnable, 3000);

        runnable = new Runnable() {
            @Override
            public void run() {
                if (!changedReadMessageStatus) {
                    message.setRead(true);
                    message.setWhoReadFirstMessage(userId);
                    mLogRepo.saveEventLog(
                            new EventLog(0
                                    , DateTimeCounter.getDateTime()
                                    , userId
                                    , "Read message id= \"" + message.getId() + "\""
                                    , "MESSAGE"));
                    mMessageRepo.saveMessage(message);
                    changedReadMessageStatus = true;
                }
            }
        };
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }


    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Session.checkIfSessionIsActive(this);
        handler.postDelayed(runnable, 3000);
    }

    @OnClick(R.id.delete_message)
    public void deleteMessage() {
        handler.removeCallbacks(runnable);
        message.setHidden(true);
        if (!message.isRead()) {
            message.setRead(true);
            message.setWhoReadFirstMessage(userId);
            mLogRepo.saveEventLog(
                    new EventLog(0
                            , DateTimeCounter.getDateTime()
                            , userId
                            , "Read message id= \"" + message.getId() + "\""
                            , "MESSAGE"));
        }
        message.setWhoHideMessage(userId);
        mMessageRepo.saveMessage(message);
        mLogRepo.saveEventLog(
                new EventLog(0
                        , DateTimeCounter.getDateTime()
                        , userId
                        , "Delete message id= \"" + message.getId() + "\""
                        , "MESSAGE"));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Session.checkIfSessionIsActive(this);
    }


}
