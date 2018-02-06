package co.borucki.easykanban.view;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.easykanban.Mail;
import co.borucki.easykanban.R;
import co.borucki.easykanban.adapter.ScannedProductAdapter;
import co.borucki.easykanban.asyncTask.ProductAsyncTask;
import co.borucki.easykanban.model.EventLog;
import co.borucki.easykanban.model.Product;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.EventLogRepository;
import co.borucki.easykanban.repository.EventLogRepositoryImpl;
import co.borucki.easykanban.repository.ProductRepository;
import co.borucki.easykanban.repository.ProductRepositoryImpl;
import co.borucki.easykanban.repository.ScannedProductRepository;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.statics.CustomLayoutViewSetup;
import co.borucki.easykanban.statics.DateTimeCounter;
import co.borucki.easykanban.statics.ImageBitmap;
import co.borucki.easykanban.statics.InternetAccess;

public class ScannedProductActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST = 101;
    private static final int REQUEST_CODE = 200;
    private final UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private final ProductRepository mProductRepo = ProductRepositoryImpl.getInstance();
    private final ScannedProductRepository mScannedProductRepo = ScannedProductRepositoryImpl.getInstance();
    private final EventLogRepository mLogRepo = EventLogRepositoryImpl.getInstance();
    private final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();

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
    @BindView(R.id.scanned_product_logo)
    ImageView mLogo;
    @BindView(R.id.scanned_product_layout)
    RelativeLayout mLayout;
    @BindView(R.id.scanned_product_activity_author)
    TextView mAuthor;
    @BindView(R.id.scanned_product_fab)
    FloatingActionButton mFAB;
    private boolean isSent;
    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_product);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        list_type = ScannedType.valueOf(intent.getStringExtra("LIST_TYPE").toUpperCase());
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat
                    .requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }
        CustomLayoutViewSetup.setEnableSendListButton(mSendList, list_type);
        mUserId = intent.getLongExtra("USER_ID", -1);
        mUser = mUserRepo.getUserById(mUserId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mScrollView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration
                = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        mScrollView.addItemDecoration(dividerItemDecoration);
        mAdapter = new ScannedProductAdapter(this);
        mScrollView.setAdapter(mAdapter);
        mAdapter.setOnImageClickListener(mOnImageClickListener);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                mRefreshLayout.setRefreshing(false);
            }
        });
        refreshData();
        CustomLayoutViewSetup.setScannedLayout(navigationToolBar, ScannedProductActivity.this, list_type, mSendList, mLayout, mLogo, mAuthor, mFAB);
        setSupportActionBar(navigationToolBar);
    }

    private void refreshData() {
        mAdapter.setData(mScannedProductRepo
                .getAllScannedProductByType(list_type.getType().toUpperCase()));
        CustomLayoutViewSetup.setEnableSendListButton(mSendList, list_type);

    }

    private final ImageView.OnClickListener mOnImageClickListener = new ImageView.OnClickListener() {
        @Override
        public void onClick(View v) {
            final ScannedProduct scannedProduct = (ScannedProduct) v.getTag();
            final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.dialog_delete_scanned_product_title);
            builder.setMessage(getString(R.string.dialog_delete_scanned_product_message, scannedProduct.getProductId()));
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.dialog_delete_scanned_product_positive_button_title, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mScannedProductRepo.delete(scannedProduct);
                    mLogRepo.saveEventLog(new EventLog(0, DateTimeCounter.getDateTime()
                            , mUserId
                            , "deleted scanned product " + scannedProduct.toString()
                            , "DELETED SCANNED PRODUCT"));
                    refreshData();
                }
            });
            builder.setNegativeButton(R.string.dialog_delete_scanned_product_negative_buttontitle, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();

        }
    };


    @OnClick(R.id.scanned_product_fab)
    public void OnClickFloatingActionBar() {
        Intent intent = new Intent(ScannedProductActivity.this, BarCodeActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            scannedBeepSignal();
            if (data != null) {
                final Barcode barcode = data.getParcelableExtra("barcode");
                Product product = mProductRepo.findProductById(barcode.displayValue);
                if (product == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ScannedProductActivity.this);
                    builder.setTitle(R.string.scanned_product_not_exist_alert_title);
                    builder.setMessage(getString(R.string.scanned_product_not_exist_alert_message, barcode.displayValue));
                    builder.setCancelable(true);
                    builder.show();

                } else {

                    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(false);
                    LayoutInflater inflater = this.getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.scanned_product_confirmation, null);
                    final TextView productDescription = dialogView.findViewById(R.id.scanned_product_confirmation_text);
                    final TextView dialogTitle = dialogView.findViewById(R.id.scanned_product_confirmation_title);
                    final TextView position = dialogView.findViewById(R.id.scanned_product_confirmation_position);
                    final TextView positionRack = dialogView.findViewById(R.id.scanned_product_confirmation_rack);
                    final TextView positionRackShelf = dialogView.findViewById(R.id.scanned_product_confirmation_rack_shelf);
                    final TextView positionRackShelfRow = dialogView.findViewById(R.id.scanned_product_confirmation_rack_shelf_row);
                    final ImageView productLogo = dialogView.findViewById(R.id.scanned_product_confirmation_image);
                    if (list_type == ScannedType.RECEIVED) {
                        position.setText(R.string.scanned_product_position);
                        positionRack.setText(getString(R.string.scanned_product_position_rack, product.getRackNo()));
                        positionRackShelf.setText(getString(R.string.scanned_product_position_rack_shelf, product.getRackShelfNo()));
                        positionRackShelfRow.setText(getString(R.string.scanned_product_position_rack_shelf_row, product.getRackShelfRowNo()));
                    } else {
                        position.setVisibility(View.GONE);
                        positionRack.setVisibility(View.GONE);
                        positionRackShelf.setVisibility(View.GONE);
                        positionRackShelfRow.setVisibility(View.GONE);
                    }

                    dialogTitle.setText(R.string.scanned_product_dialog_title);

                    productDescription.setText(getResources().getString(R.string.product_id_and_description, product.getProductId(), product.getDescription()));
                    productLogo.setImageBitmap(ImageBitmap.decodeImageFromByteArrayToBitmap(product.getPhoto()));

                    builder.setView(dialogView)
                            .setPositiveButton(R.string.scanned_product_dialog_positive_button, new DialogInterface.OnClickListener() {


                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    ScannedProduct scannedProduct = new ScannedProduct(0
                                            , barcode.displayValue
                                            , 1
                                            , DateTimeCounter.getDateTime()
                                            , list_type.getType().toUpperCase());
                                    mScannedProductRepo.save(scannedProduct);
                                    mLogRepo.saveEventLog(
                                            new EventLog(1
                                                    , DateTimeCounter.getDateTime()
                                                    , mUserId
                                                    , "scanned " + scannedProduct.toString()
                                                    , "SCANNED QR CODE"));
                                    refreshData();

                                }
                            });
                    builder.setNegativeButton(R.string.scanned_product_dialog_negative_button, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();

                }


            }
        }
    }

    @OnClick(R.id.send_lists)
    public void OnClickListSend() {
        if (mCustomRepo.isCommercialLicence()) {
            List<ScannedProduct> scannedProducts = mScannedProductRepo
                    .getAllScannedProductByType(list_type.getType().toUpperCase());
            stringBuilder = new StringBuilder();
            stringBuilder.append("List of scanned products >>");
            stringBuilder.append(list_type.getType().toUpperCase());
            stringBuilder.append("<<:\n\n");
            stringBuilder.append("No.\t|\tProduct Id\t|\tProduct description\t|\tQuantity\t|\tScanned on\t|\n");

            int counter = 1;
            for (ScannedProduct scannedProduct : scannedProducts) {
                stringBuilder.append(counter++);
                stringBuilder.append("\t|\t");
                stringBuilder.append(scannedProduct.getProductId());
                stringBuilder.append("\t|\t");
                Product product = mProductRepo.findProductById(scannedProduct.getProductId());
                stringBuilder.append(product.getDescription());
                stringBuilder.append("\t|\t");
                stringBuilder.append(scannedProduct.getQuantity());
                stringBuilder.append(" ");
                stringBuilder.append(product.getUnit());
                stringBuilder.append("\t|\t");
                stringBuilder.append(scannedProduct.getTimeStamp());
                stringBuilder.append("\t|\n");
            }
            sendMessage();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(R.string.demo_version_title);
            builder.setMessage(R.string.demo_version_message);
            builder.show();
        }
    }

    private void sendMessage() {

        String[] recipients = mCustomRepo.getMailTo().split(";");
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.m = new Mail(mCustomRepo.getMailAddress(), mCustomRepo.getMailPassword());
        email.m.set_from(mCustomRepo.getMailAddress());
        email.m.setBody(stringBuilder.toString());
        email.m.set_to(recipients);
        email.m.set_host(mCustomRepo.getMailHost());
        email.m.set_port(String.valueOf(mCustomRepo.getMailSMTPPort()));
        email.m.set_sport(String.valueOf(mCustomRepo.getMailSMTPPort()));
        email.m.set_subject(mCustomRepo.getCustomerName() + "-" + list_type.getType().toUpperCase());
        email.execute();
    }

    class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
        Mail m;
        private ProgressDialog progressDialog;

        public SendEmailAsyncTask() {
        }

        @Override
        protected void onPreExecute() {

            progressDialog = new ProgressDialog(ScannedProductActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Send lists by mail");
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (isSent) {
                mLogRepo.saveEventLog(
                        new EventLog(1, DateTimeCounter.getDateTime(), mUserId, "sent: \n" + stringBuilder.toString(), "SEND MAIL")
                );
                mScannedProductRepo.delete(mScannedProductRepo
                        .getAllScannedProductByType(list_type.getType().toUpperCase()));
                refreshData();

            } else {
                mLogRepo.saveEventLog(
                        new EventLog(1, DateTimeCounter.getDateTime(), mUserId, "Failed to send list by mail", "SEND MAIL")
                );
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(ScannedProductActivity.this);
                alertDialog.setCancelable(true);
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("Failed to send list by mail\nCheck Internet connection and try again later");
                alertDialog.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
            progressDialog.dismiss();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                isSent = m.send();
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

    public void scannedBeepSignal() {
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.beep);
        mediaPlayer.setVolume(maxVolume, maxVolume);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
                mp.stop();
            }
        });
        mediaPlayer.start();


        final Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            v.vibrate(300);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.load_products) {
            if (InternetAccess.isOnLine(this)) {
                new ProductAsyncTask(false).execute();
            }
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_menu_logged, menu);
        return true;
    }
}
