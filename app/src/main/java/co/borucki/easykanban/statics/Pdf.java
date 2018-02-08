package co.borucki.easykanban.statics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.pdf.PdfDocument;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.borucki.easykanban.R;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.ProductRepository;
import co.borucki.easykanban.repository.ProductRepositoryImpl;
import co.borucki.easykanban.repository.ScannedProductRepository;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;


public class Pdf {


    public static void createPdf(Context context, Activity activity, String fileName, String type, User user) {
        final ScannedProductRepository mScannedRepo = ScannedProductRepositoryImpl.getInstance();
        final ProductRepository mProductRepo = ProductRepositoryImpl.getInstance();
        final CustomDataRepository mRepository = CustomDataRepositoryImpl.getInstance();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float hight = displaymetrics.heightPixels;
        float width = displaymetrics.widthPixels;
        int convertHighet = (int) hight, convertWidth = (int) width;

        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(convertWidth, convertHighet, 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        Bitmap bitmap;
        if (!mRepository.getLogo().equals("")) {
            bitmap = ImageBitmap.decodeImageFromStringToBitmap(mRepository.getLogo());
        } else {
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.splash_logo);
        }
        canvas.drawBitmap(bitmap
                , new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight())
                , new Rect(convertWidth - 200, 0, convertWidth - 100, 100)
                , paint);

        canvas.drawLine(100, 100, convertWidth - 100, 100, paint);
        canvas.drawLine(100, convertHighet - 100, convertWidth - 100, convertHighet - 100, paint);
        canvas.drawLine(100, 100, 100, convertHighet - 100, paint);
        canvas.drawLine(convertWidth - 100, 100, convertWidth - 100, convertHighet - 100, paint);
        String typeOfList;
        switch (type) {
            case "USED":
                typeOfList = context.getString(R.string.pdf_used_product, mRepository.getCustomerName());
                break;
            case "RECEIVED":
                typeOfList = context.getString(R.string.pdf_received_product, mRepository.getCustomerName());
                break;
            case "STOCKTAKING":
                typeOfList = context.getString(R.string.pdf_stocktaking, mRepository.getCustomerName());
                break;
            default:
                typeOfList = "";
                break;
        }

        canvas.drawText(typeOfList, 100, 20, paint);
        canvas.drawText(DateTimeCounter.getDateTime(), 100, 40, paint);
        canvas.drawText(context.getString(R.string.pdf_send_by, user.getName(), user.getSurname()), 100, 60, paint);

        canvas.drawText(context.getString(R.string.pdf_no), 110, 130, paint);
        canvas.drawText(context.getString(R.string.pdf_product_id), 150, 130, paint);
        canvas.drawText(context.getString(R.string.pdf_description), 300, 130, paint);
        canvas.drawText(context.getString(R.string.pdf_quantity), 750, 130, paint);
        canvas.drawText(context.getString(R.string.pdf_scan_time), 850, 130, paint);
        canvas.drawLine(100, 135, convertWidth - 100, 135, paint);


        List<ScannedProduct> scannedProductList = mScannedRepo.getAllScannedProductByType(type);
        HashMap<String, List<ScannedProduct>> map = new HashMap<>();

        int x = 0, counter = 1;

        for (ScannedProduct item : scannedProductList) {
            List<ScannedProduct> itemsWithSameId = map.get(item.getProductId());
            if (itemsWithSameId == null) {
                itemsWithSameId = new ArrayList<>();
                map.put(item.getProductId(), itemsWithSameId);
            }
            itemsWithSameId.add(item);
        }

        for (String key : map.keySet()) {
            List<ScannedProduct> listOfElementsWithSameKey = map.get(key);
            canvas.drawText(String.valueOf(counter), 120, 150 + (x * 20), paint);
            canvas.drawText(key, 150, 150 + (x * 20), paint);
            canvas.drawText(mProductRepo.findProductById(key).getDescription(), 300, 150 + (x * 20), paint);
            canvas.drawText(String.valueOf(listOfElementsWithSameKey.size()) + " " + mProductRepo.findProductById(key).getUnit(), 750, 150 + (x * 20), paint);
            for (ScannedProduct scannedProduct : listOfElementsWithSameKey) {
                canvas.drawText(scannedProduct.getTimeStamp(), 850, 150 + (x * 20), paint);
                x++;
            }
            canvas.drawLine(100, 155 - 20 + (x * 20), convertWidth - 100, 155 - 20 + (x * 20), paint);
            counter++;
        }


        canvas.drawLine(140, 100, 140, 155 + ((x - 1) * 20), paint);
        canvas.drawLine(290, 100, 290, 155 + ((x - 1) * 20), paint);
        canvas.drawLine(740, 100, 740, 155 + ((x - 1) * 20), paint);
        canvas.drawLine(840, 100, 840, 155 + ((x - 1) * 20), paint);
        canvas.drawText(context.getString(R.string.pdf_footer,mRepository.getLicenceOwner()), 100, convertHighet-80, paint);

        document.finishPage(page);

        File cacheDir = context.getCacheDir();
        String tempPDFfile = cacheDir.getPath() + "/" + fileName + ".pdf";
        File filePath = new File(tempPDFfile);
        try {
            document.writeTo(new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }

        document.close();
    }

}
