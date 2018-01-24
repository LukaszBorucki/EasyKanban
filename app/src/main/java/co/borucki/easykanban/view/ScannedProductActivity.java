package co.borucki.easykanban.view;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.easykanban.R;
import co.borucki.easykanban.adapter.ScannedProductAdapter;
import co.borucki.easykanban.model.EventLog;
import co.borucki.easykanban.model.Product;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.model.User;
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
import co.borucki.easykanban.statics.SampleData;

public class ScannedProductActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST = 101;
    private static final int REQUEST_CODE = 200;
    private UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private ProductRepository mProductRepo = ProductRepositoryImpl.getInstance();
    private ScannedProductRepository mScannedProductRepo = ScannedProductRepositoryImpl.getInstance();
    private final EventLogRepository mLogRepo = EventLogRepositoryImpl.getInstance();

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
        list_type = ScannedType.valueOf(intent.getStringExtra("LIST_TYPE").toUpperCase());
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat
                    .requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }
        CustomLayoutViewSetup.SetEnableSendListButton(mSendList, list_type);
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
                SampleData.loadProduct();
                refreshData();
                mRefreshLayout.setRefreshing(false);
            }
        });
        refreshData();
        CustomLayoutViewSetup.SetScannedLayout(navigationToolBar);


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
        mAdapter.setData(mScannedProductRepo
                .getAllScannedProductByType(list_type.getType().toUpperCase()));
        CustomLayoutViewSetup.SetEnableSendListButton(mSendList, list_type);

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
                    final View dialogView = inflater.inflate(R.layout.scanned_product_confirmation,null);
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

                    productDescription.setText(product.getProductId() + "\n" + product.getDescription());
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
}
