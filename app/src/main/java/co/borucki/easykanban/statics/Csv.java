package co.borucki.easykanban.statics;

import android.app.Activity;
import android.content.Context;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.borucki.easykanban.R;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.ProductRepository;
import co.borucki.easykanban.repository.ProductRepositoryImpl;
import co.borucki.easykanban.repository.ScannedProductRepository;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;

public class Csv {
    private static FileWriter mFileWriter;

    public static void createFile(Context context, Activity activity, String fileName, String type, User user) {
        final ScannedProductRepository mScannedRepo = ScannedProductRepositoryImpl.getInstance();
        final ProductRepository mProductRepo = ProductRepositoryImpl.getInstance();
        final CustomDataRepository mRepository = CustomDataRepositoryImpl.getInstance();
        Map<String, List<ScannedProduct>> itemsMap = new HashMap<>();
        for (ScannedProduct scannedProduct : mScannedRepo.getAllScannedProductByType(type.toUpperCase())) {
            List<ScannedProduct> uniqueItem = itemsMap.get(scannedProduct.getProductId());
            if (uniqueItem == null) {
                uniqueItem = new ArrayList<>();
                itemsMap.put(scannedProduct.getProductId(), uniqueItem);
            }
            uniqueItem.add(scannedProduct);
        }
        File cacheDir = context.getCacheDir();
        String tempCSVFile = cacheDir.getPath() + "/" + fileName + ".csv";
        CSVWriter writer;
        try {
            writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(tempCSVFile), "ISO-8859-2"), ';', CSVWriter.NO_QUOTE_CHARACTER);
            StringBuilder builder = new StringBuilder();
            builder.append(context.getString(R.string.csv_product_code));
            builder.append("\t");
            builder.append(context.getString(R.string.csv_product_quantity));
            builder.append("\t");
            builder.append(context.getString(R.string.csv_product_unit));
            builder.append("\t");
            builder.append(context.getString(R.string.csv_product_description));
            builder.append("\t");
            builder.append(context.getString(R.string.csv_scan_timestamp));
            writer.writeNext(builder.toString().split("\t"));
            for (String key : itemsMap.keySet()) {
                List<ScannedProduct> currentList = itemsMap.get(key);
                builder = new StringBuilder();
                builder.append(key);
                builder.append("\t");
                builder.append(String.valueOf(currentList.size()));
                builder.append("\t");
                builder.append(mProductRepo.findProductById(key).getUnit());
                builder.append("\t");
                builder.append(mProductRepo.findProductById(key).getDescription());
                builder.append("\t");
                int scanCounter = 0;
                for (ScannedProduct scannedProduct : currentList) {
                    if (scanCounter > 0) builder.append(" | ");
                    builder.append(scannedProduct.getTimeStamp());
                    scanCounter++;
                }
                writer.writeNext(builder.toString().split("\t"));
            }

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
            writer.writeNext(typeOfList.split("\t"));
            writer.writeNext(DateTimeCounter.getDateTime().split("\t"));
            writer.writeNext(context.getString(R.string.pdf_send_by, user.getName(), user.getSurname()).split("\t"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
