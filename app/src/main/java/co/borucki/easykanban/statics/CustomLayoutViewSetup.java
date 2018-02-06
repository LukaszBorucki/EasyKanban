package co.borucki.easykanban.statics;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import co.borucki.easykanban.R;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.IncomingMessageRepository;
import co.borucki.easykanban.repository.IncomingMessageRepositoryImpl;
import co.borucki.easykanban.repository.ScannedProductRepository;
import co.borucki.easykanban.repository.ScannedProductRepositoryImpl;
import co.borucki.easykanban.repository.style.LoginStyleRepository;
import co.borucki.easykanban.repository.style.LoginStyleRepositoryImpl;
import co.borucki.easykanban.repository.style.MailStyleRepository;
import co.borucki.easykanban.repository.style.MailStyleRepositoryImpl;
import co.borucki.easykanban.repository.style.MainStyleRepository;
import co.borucki.easykanban.repository.style.MainStyleRepositoryImpl;
import co.borucki.easykanban.repository.style.QrStyleRepository;
import co.borucki.easykanban.repository.style.QrStyleRepositoryImpl;
import co.borucki.easykanban.repository.style.ScannedStyleRepository;
import co.borucki.easykanban.repository.style.ScannedStyleRepositoryImpl;
import co.borucki.easykanban.repository.style.SingleMailStyleRepository;
import co.borucki.easykanban.repository.style.SingleMailStyleRepositoryImpl;
import co.borucki.easykanban.view.BarCodeActivity;
import co.borucki.easykanban.view.IncomingMessageActivity;
import co.borucki.easykanban.view.LoginActivity;
import co.borucki.easykanban.view.MainActivity;
import co.borucki.easykanban.view.ScannedProductActivity;
import co.borucki.easykanban.view.SingleMessageView;

public class CustomLayoutViewSetup {
    private static CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();
    private static LoginStyleRepository mLoginStyleRepo = LoginStyleRepositoryImpl.getInstance();
    private static ScannedStyleRepository mScannedStyleRepo = ScannedStyleRepositoryImpl.getInstance();
    private static MainStyleRepository mMainStyleRepo = MainStyleRepositoryImpl.getInstance();
    private static MailStyleRepository mMailStyleRepo = MailStyleRepositoryImpl.getInstance();
    private static SingleMailStyleRepository mSingleMailStyleRepo = SingleMailStyleRepositoryImpl.getInstance();
    private static QrStyleRepository mQrStyleRepo = QrStyleRepositoryImpl.getInstance();
    private static IncomingMessageRepository mMessageRepo = IncomingMessageRepositoryImpl.getInstance();
    private static ScannedProductRepository mScannedProductRepo = ScannedProductRepositoryImpl.getInstance();

    public static void setMainLayoutView(Toolbar toolbar, ImageView logo, TextView author, RelativeLayout layout, MainActivity mainActivity) {
        if (mMainStyleRepo.getToolBarIcon().equals("")) {
            toolbar.setOverflowIcon(mainActivity.getResources().getDrawable(R.drawable.tool_bar_white_24dp));
        } else {
            toolbar.setOverflowIcon(
                    new BitmapDrawable(
                            ImageBitmap.decodeImageFromStringToBitmap(mMainStyleRepo.getToolBarIcon())));
        }
        toolbar.setBackgroundColor(Color.parseColor(mMainStyleRepo.getToolBarColor()));
        toolbar.setTitleTextColor(Color.parseColor(mMainStyleRepo.getToolBarTextColor()));
        mainActivity.getWindow().setStatusBarColor(Color.parseColor(mMainStyleRepo.getStatusBarColor()));
        layout.setBackgroundColor(Color.parseColor(mMainStyleRepo.getLayoutColor()));
        logo.setAlpha(mMainStyleRepo.getLayoutLogoAlpha());
        if (!mMainStyleRepo.getLayoutLogoShow()) {
            logo.setVisibility(View.GONE);
        }
        if (!mCustomRepo.getLogo().equals("")) {
            logo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mCustomRepo.getLogo()));
        }
        author.setTextColor(Color.parseColor(mMainStyleRepo.getLayoutTextColor()));
    }

    public static void setButtonView(RelativeLayout layout, TextView buttonText, TextView badgeText, String buttonTitle, boolean isEnabled) {
        layout.setEnabled(isEnabled);
        GradientDrawable shape = new GradientDrawable();
        float[] i = {40, 40, 40, 40, 40, 40, 0, 0};
        shape.setCornerRadii(i);

        layout.setBackground(shape);
        buttonText.setText(buttonTitle);
        buttonText.setTextSize(30);
        if (!mMainStyleRepo.getButtonTextColor().equals("")) {
            buttonText.setTextColor(Color.parseColor(mMainStyleRepo.getButtonTextColor()));
        }
        buttonText.setAllCaps(true);
        GradientDrawable shapeBadge = new GradientDrawable();
        shapeBadge.setCornerRadii(new float[]{40, 40, 40, 40, 40, 40, 0, 0});

        badgeText.setBackground(shapeBadge);
        if (!mMainStyleRepo.getBadgeTextColor().equals("")) {
            badgeText.setTextColor(Color.parseColor(mMainStyleRepo.getBadgeTextColor()));
        }
        badgeText.setVisibility(View.GONE);
        if (isEnabled) {
            if (!mMainStyleRepo.getButtonColor().equals("")) {
                shape.setColor(Color.parseColor(mMainStyleRepo.getButtonColor()));
            }
            if (!mMainStyleRepo.getBadgeColor().equals("")) {
                shapeBadge.setColor(Color.parseColor(mMainStyleRepo.getBadgeColor()));
            }
        } else {
            shape.setColor(Color.parseColor("#999a97"));
            shapeBadge.setColor(Color.parseColor("#757575"));
        }
    }

    public static void setLoginLayout(LoginActivity loginActivity, Toolbar navigationToolBar) {
        TextView mAuthor = loginActivity.findViewById(R.id.login_activity_author);
        mAuthor.setTextColor(Color.parseColor(mLoginStyleRepo.getTextColor()));

        ImageView mLogo = loginActivity.findViewById(R.id.login_layout_logo);
        if (!mCustomRepo.getLogo().equals("")) {
            mLogo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mCustomRepo.getLogo()));
        } else {
            mLogo.setImageDrawable(loginActivity.getResources().getDrawable(R.drawable.splash_logo));
        }
        RelativeLayout mLayout = loginActivity.findViewById(R.id.login_activity);
        mLayout.setBackgroundColor(Color.parseColor(mLoginStyleRepo.getLayoutColor()));
        loginActivity.getWindow().setStatusBarColor(Color.parseColor(mLoginStyleRepo.getStatusBarColor()));
        navigationToolBar.setBackgroundColor(Color.parseColor(mLoginStyleRepo.getToolBarColor()));
        navigationToolBar.setTitleTextColor(Color.parseColor(mLoginStyleRepo.getToolBarTextColor()));
        if (mLoginStyleRepo.getToolBarIcon().equals("")) {
            navigationToolBar.setOverflowIcon(loginActivity.getResources().getDrawable(R.drawable.tool_bar_white_24dp));
        } else {
            Drawable d = new BitmapDrawable(ImageBitmap.decodeImageFromStringToBitmap(mLoginStyleRepo.getToolBarIcon()));
            navigationToolBar.setOverflowIcon(d);
        }
        navigationToolBar.setTitle(R.string.login_activity_tool_bar_title);
    }

    public static void setScannedLayout(Toolbar navigationToolBar, ScannedProductActivity scannedProductActivity
            , ScannedType list_type, Button sendList, RelativeLayout layout, ImageView logo, TextView author, FloatingActionButton fAB) {
        scannedProductActivity.getWindow().setStatusBarColor(Color.parseColor(mScannedStyleRepo.getStatusBarColor()));
        fAB.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mScannedStyleRepo.getFabTintColor())));
        fAB.setRippleColor(Color.parseColor(mScannedStyleRepo.getFabRippleColor()));
        if (!mScannedStyleRepo.getFabLogo().equals("")) {
            fAB.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mScannedStyleRepo.getFabLogo()));
        }
        logo.setAlpha(mScannedStyleRepo.getLogoAlpha());
        if (!mScannedStyleRepo.isLogoVisible()) {
            layout.setVisibility(View.GONE);
        }
        if (!mCustomRepo.getLogo().equals("")) {
            logo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mCustomRepo.getLogo()));
        }
        layout.setBackgroundColor(Color.parseColor(mScannedStyleRepo.getLayoutColor()));
        author.setTextColor(Color.parseColor(mScannedStyleRepo.getLayoutTextColor()));//

        navigationToolBar.setBackgroundColor(Color.parseColor(mScannedStyleRepo.getToolBarColor()));
        navigationToolBar.setTitleTextColor(Color.parseColor(mScannedStyleRepo.getToolBarTextColor()));
        if (mScannedStyleRepo.getToolBarIcon().equals("")) {
            navigationToolBar.setOverflowIcon(scannedProductActivity.getResources().getDrawable(R.drawable.tool_bar_white_24dp));
        } else {
            Drawable d = new BitmapDrawable(ImageBitmap.decodeImageFromStringToBitmap(mScannedStyleRepo.getToolBarIcon()));
            navigationToolBar.setOverflowIcon(d);
        }
        sendList.setBackgroundColor(Color.parseColor(mScannedStyleRepo.getSendButtonColor()));
        sendList.setTextColor(Color.parseColor(mScannedStyleRepo.getSendButtonTextColor()));
        switch (list_type) {
            case USED:
                navigationToolBar.setTitle(R.string.scanned_product_tool_bar_title_used_product);
                sendList.setText(R.string.scanned_product_send_used_list);
                break;
            case RECEIVED:
                navigationToolBar.setTitle(R.string.scanned_product_tool_bar_title_delivered_product);
                sendList.setText(R.string.scanned_product_send_delivered_list);
                break;
            case STOCKTAKING:
                navigationToolBar.setTitle(R.string.scanned_product_tool_bar_title_stocktaking);
                sendList.setText(R.string.scanned_product_send_stocktaking_list);
                break;
        }

    }

    public static void setMessageBadge(TextView messageButtonBadge) {
        if (mMessageRepo.countUnreadMessages() > 0) {
            messageButtonBadge.setText(String.valueOf(mMessageRepo.countUnreadMessages()));
            messageButtonBadge.setVisibility(View.VISIBLE);
        }
    }

    public static void setScannedBadge(TextView scannedProductButtonBadge, String type) {
        if (mScannedProductRepo.countScannedProductByType(type) > 0) {
            scannedProductButtonBadge.setText(String.valueOf(mScannedProductRepo.countScannedProductByType(type)));
            scannedProductButtonBadge.setVisibility(View.VISIBLE);
        }
    }

    public static void setEnableSendListButton(Button sendList, ScannedType list_type) {
        if (mScannedProductRepo.countScannedProductByType(list_type.getType().toUpperCase()) > 0)
            sendList.setEnabled(true);
        else sendList.setEnabled(false);
    }

    public static void setIncomingMessageView(IncomingMessageActivity activity) {
        ImageView mLogo = activity.findViewById(R.id.incoming_message_logo);
        mLogo.setAlpha(mMailStyleRepo.getLogoAlpha());
        if (!mMailStyleRepo.isLogoVisible()) {
            mLogo.setVisibility(View.GONE);
        }
        if (!mCustomRepo.getLogo().equals("")) {
            mLogo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mCustomRepo.getLogo()));
        }
        TextView author = activity.findViewById(R.id.incoming_message_author);
        author.setTextColor(Color.parseColor(mMailStyleRepo.getTextColor()));

        RelativeLayout layout = activity.findViewById(R.id.incoming_message_activity_layout);
        layout.setBackgroundColor(Color.parseColor(mMailStyleRepo.getBackgroundColor()));

        activity.getWindow().setStatusBarColor(Color.parseColor(mMailStyleRepo.getStatusBarColor()));
    }

    public static void setSingleMessageView(RelativeLayout layout
            , ImageView logo
            , TextView from
            , TextView subject
            , TextView text
            , TextView author
            , Button deleteButton
            , SingleMessageView activity) {


        activity.getWindow().setStatusBarColor(Color.parseColor(mSingleMailStyleRepo.getStatusBarColor()));
        layout.setBackgroundColor(Color.parseColor(mSingleMailStyleRepo.getBackgroundColor()));
        logo.setAlpha(mSingleMailStyleRepo.getLogoAlpha());
        if (!mSingleMailStyleRepo.isLogoVisible()) {
            logo.setVisibility(View.GONE);
        }
        if (!mCustomRepo.getLogo().equals("")) {
            logo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mCustomRepo.getLogo()));
        }

        from.setTextColor(Color.parseColor(mSingleMailStyleRepo.getBackgroundTextColor()));
        subject.setTextColor(Color.parseColor(mSingleMailStyleRepo.getBackgroundTextColor()));
        text.setTextColor(Color.parseColor(mSingleMailStyleRepo.getBackgroundTextColor()));
        author.setTextColor(Color.parseColor(mSingleMailStyleRepo.getBackgroundTextColor()));
        deleteButton.setTextColor(Color.parseColor(mSingleMailStyleRepo.getDelButtonTextColor()));
        deleteButton.setBackgroundColor(Color.parseColor(mSingleMailStyleRepo.getDelButtonColor()));
    }

    public static void setBarCodeActivity(BarCodeActivity activity) {
        activity.getWindow().setStatusBarColor(Color.parseColor(mQrStyleRepo.getStatusBarColor()));

        TextView mAuthor = activity.findViewById(R.id.bar_code_author);
        mAuthor.setTextColor(Color.parseColor(mQrStyleRepo.getBackgroundTextColor()));

        RelativeLayout layout = activity.findViewById(R.id.bar_code_layout);
        layout.setBackgroundColor(Color.parseColor(mQrStyleRepo.getBackgroundColor()));


        ImageView mLogo = activity.findViewById(R.id.bar_code_logo);
        mLogo.setAlpha(mQrStyleRepo.getLogoAlpha());
        if (!mQrStyleRepo.isLogoVisible()) {
            mLogo.setVisibility(View.GONE);
        }
        if (!mCustomRepo.getLogo().equals("")) {
            mLogo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mCustomRepo.getLogo()));
        }
    }
}
