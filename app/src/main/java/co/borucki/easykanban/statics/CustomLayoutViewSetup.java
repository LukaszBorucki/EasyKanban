package co.borucki.easykanban.statics;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import co.borucki.easykanban.R;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;
import co.borucki.easykanban.repository.ScannedProductRepository;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;
import co.borucki.easykanban.view.LoginActivity;

public class CustomLayoutViewSetup {
    private static CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();
    private static IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();
    private static ScannedProductRepository mScannedProductRepo = ScannedProductRepositoryImpl.getInstance();

    public static void SetMainLayoutView(ImageView mLogo, TextView mAuthor) {
        mLogo.setAlpha(0.5f);
        mAuthor.setTextColor(Color.parseColor("#000000"));
    }

    public static void SetButtonView(RelativeLayout layout, TextView buttonText, TextView badgeText, String buttonTitle) {
        GradientDrawable shape = new GradientDrawable();
        float[] i = {40, 40, 40, 40, 40, 40, 0, 0};
        shape.setCornerRadii(i);
        shape.setColor(Color.parseColor("#F03F51B5"));
        layout.setBackground(shape);
        buttonText.setText(buttonTitle);
        buttonText.setTextSize(40);
        buttonText.setTextColor(Color.parseColor("#FFFFFF"));
        buttonText.setAllCaps(true);
        GradientDrawable shapeBadge = new GradientDrawable();
        shapeBadge.setCornerRadii(new float[]{40, 40, 40, 40, 40, 40, 0, 0});
        shapeBadge.setColor(Color.parseColor("#FF303F9F"));
        badgeText.setBackground(shapeBadge);
        badgeText.setTextColor(Color.parseColor("#FFFFFFFF"));
        badgeText.setVisibility(View.GONE);

    }

    public static void SetLoginLayout(LoginActivity loginActivity, TextView mAuthor, ImageView mLogo, RelativeLayout mLayout, Toolbar navigationToolBar) {
        mAuthor.setTextColor(Color.parseColor(mCustomRepo.getLoginTextColor()));
        if (!mCustomRepo.getLogo().equals("")) {
            mLogo.setImageBitmap(LocaleHelper.decodeImageFromStringToBitmap(mCustomRepo.getLogo()));
        }
        mLayout.setBackgroundColor(Color.parseColor(mCustomRepo.getLoginLayoutColor()));
        loginActivity.getWindow().setStatusBarColor(Color.parseColor(mCustomRepo.getLoginStatusBarColor()));
        navigationToolBar.setBackgroundColor(Color.parseColor(mCustomRepo.getLoginToolBarColor()));
        navigationToolBar.setTitleTextColor(Color.parseColor(mCustomRepo.getLoginToolBarTextColor()));
        if (mCustomRepo.getLoginToolBarIcon().equals("")) {
            navigationToolBar.setOverflowIcon(loginActivity.getResources().getDrawable(R.drawable.tool_bar_white_24dp));
        }
        navigationToolBar.setTitle(R.string.login_activity_tool_bar_title);
    }

    public static void SetScannedLayout(Toolbar navigationToolBar) {
        navigationToolBar.setBackgroundColor(Color.parseColor(mCustomRepo.getLoginToolBarColor()));
        navigationToolBar.setTitleTextColor(Color.parseColor(mCustomRepo.getLoginToolBarTextColor()));


    }

    public static void SetMessageBadge(TextView mMessageButtonBadge) {
        if (mMessageRepo.countUnreadMessages() > 0) {
            mMessageButtonBadge.setText(String.valueOf(mMessageRepo.countUnreadMessages()));
            mMessageButtonBadge.setVisibility(View.VISIBLE);
        }
    }

    public static void SetScannedBadge(TextView mScannedProductButtonBadge, String type) {
        if (mScannedProductRepo.countScannedProductByType(type) > 0) {
            mScannedProductButtonBadge.setText(String.valueOf(mScannedProductRepo.countScannedProductByType(type)));
            mScannedProductButtonBadge.setVisibility(View.VISIBLE);
        }
    }

    public static void SetEnableSendListButton(Button mSendList, ScannedType list_type) {
        if (mScannedProductRepo.countScannedProductByType(list_type.getType().toUpperCase()) > 0)
            mSendList.setEnabled(true);
        else mSendList.setEnabled(false);
    }

}
