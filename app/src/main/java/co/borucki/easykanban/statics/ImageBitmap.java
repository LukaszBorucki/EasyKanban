package co.borucki.easykanban.statics;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ImageBitmap {
    public static byte[] decodeImageFromStringToByteArray(String image) {
        return Base64.decode(image, Base64.DEFAULT);
    }

    public static Bitmap decodeImageFromByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public static Bitmap decodeImageFromStringToBitmap(String image) {
        byte[] byteArrayImage = decodeImageFromStringToByteArray(image);
        return decodeImageFromByteArrayToBitmap(byteArrayImage);
    }
}
