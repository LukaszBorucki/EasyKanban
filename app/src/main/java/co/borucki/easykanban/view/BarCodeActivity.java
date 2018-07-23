package co.borucki.easykanban.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import co.borucki.easykanban.R;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.statics.CustomLayoutViewSetup;
import co.borucki.easykanban.statics.Session;

public class BarCodeActivity extends Activity {
    private final CustomDataRepository mRepo = CustomDataRepositoryImpl.getInstance();
    SurfaceView cameraView;
    BarcodeDetector barcode;
    CameraSource cameraSource;
    SurfaceHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);
        Session.checkIfSessionIsActive(this);
        CustomLayoutViewSetup.setBarCodeActivity(this);
        cameraView = findViewById(R.id.cameraView);
        cameraView.setZOrderMediaOverlay(true);
        holder = cameraView.getHolder();
        barcode = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(mRepo.getCodeType())
                .build();

        if (!barcode.isOperational()) {
            Toast.makeText(getApplicationContext()
                    , R.string.bar_code_detector_error
                    , Toast.LENGTH_LONG).show();
            this.finish();
        }

        cameraSource = new CameraSource.Builder(this, barcode)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedFps(24)
                .setAutoFocusEnabled(true)
                .setRequestedPreviewSize(1920, 1024)
                .build();

        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ContextCompat
                        .checkSelfPermission(BarCodeActivity.this
                                , Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    try {
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
cameraSource.stop();
            }
        });

        barcode.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("barcode", barcodes.valueAt(0));
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Session.checkIfSessionIsActive(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Session.checkIfSessionIsActive(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraSource.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraSource.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cameraSource.stop();
    }
}
