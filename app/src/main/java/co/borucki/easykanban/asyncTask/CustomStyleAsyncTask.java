package co.borucki.easykanban.asyncTask;

import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import co.borucki.easykanban.dto.mapper.StyleMapper;
import co.borucki.easykanban.dto.styleDTO.CustomStyleDTO;
import co.borucki.easykanban.model.style.CustomStyle;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
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
import co.borucki.easykanban.repository.style.SplashStyleRepository;
import co.borucki.easykanban.repository.style.SplashStyleRepositoryImpl;

public class CustomStyleAsyncTask extends AsyncTask<Void, Void, CustomStyleDTO> {
    private final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();
    private final LoginStyleRepository mLoginStyleRepo = LoginStyleRepositoryImpl.getInstance();
    private final SplashStyleRepository mSplashStyleRepo = SplashStyleRepositoryImpl.getInstance();
    private final ScannedStyleRepository mScannedStyleRepo = ScannedStyleRepositoryImpl.getInstance();
    private final MainStyleRepository mMainStyleRepo = MainStyleRepositoryImpl.getInstance();
    private final MailStyleRepository mMailStyleRepo = MailStyleRepositoryImpl.getInstance();
    private final SingleMailStyleRepository mSingleMailStyleRepo = SingleMailStyleRepositoryImpl.getInstance();
    private final QrStyleRepository mQrStyleRepo = QrStyleRepositoryImpl.getInstance();
    private boolean background;

    public CustomStyleAsyncTask(boolean background) {
        this.background = background;
    }

    @Override
    protected CustomStyleDTO doInBackground(Void... voids) {
        String id = mCustomRepo.isCommercialLicence() ? String.valueOf(mCustomRepo.getIMEI()) : "demo";
        String link = "http://www.borucki.co/api_v2/kanban/getCustomStyle?id=" + id;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return restTemplate.getForObject(link, CustomStyleDTO.class);
    }

    @Override
    protected void onPostExecute(CustomStyleDTO customStyleDTO) {
        CustomStyle customStyle = StyleMapper.fromCustomStyleDTOToCustomStyle(customStyleDTO);

        mCustomRepo.setLogo(customStyle.getSplashStyle().getLogo());

        mSplashStyleRepo.setScreenTime(customStyle.getSplashStyle().getSplashTime());
        mSplashStyleRepo.setScreenTextVisible(customStyle.getSplashStyle().getTextVisible());
        mSplashStyleRepo.setScreenCustomText(customStyle.getSplashStyle().getCustomText());
        mSplashStyleRepo.setScreenThanksText(customStyle.getSplashStyle().getThanksText());
        mSplashStyleRepo.setScreenCustomTextSize(customStyle.getSplashStyle().getCustomTextSize());
        mSplashStyleRepo.setScreenThanksTextSize(customStyle.getSplashStyle().getThanksTextSize());
        mSplashStyleRepo.setLayoutColor(customStyle.getSplashStyle().getBackgroundColor());
        mSplashStyleRepo.setTextColor(customStyle.getSplashStyle().getBackgroundTextColor());
        mSplashStyleRepo.setStatusBarColor(customStyle.getSplashStyle().getStatusBarColor());

        mLoginStyleRepo.setLayoutColor(customStyle.getLoginStyle().getBackgroundColor());
        mLoginStyleRepo.setTextColor(customStyle.getLoginStyle().getBackgroundTextColor());
        mLoginStyleRepo.setToolBarColor(customStyle.getLoginStyle().getToolBarColor());
        mLoginStyleRepo.setToolBarTextColor(customStyle.getLoginStyle().getToolBarTextColor());
        mLoginStyleRepo.setStatusBarColor(customStyle.getLoginStyle().getStatusBarColor());
        mLoginStyleRepo.setToolBarIcon(customStyle.getLoginStyle().getToolBarIcon());

        mMainStyleRepo.setStatusBarColor(customStyle.getMainStyle().getStatusBarColor());
        mMainStyleRepo.setLayoutColor(customStyle.getMainStyle().getBackgroundColor());
        mMainStyleRepo.setLayoutTextColor(customStyle.getMainStyle().getBackgroundTextColor());
        mMainStyleRepo.setLayoutLogoShow(customStyle.getMainStyle().isLayoutLogoShow());
        mMainStyleRepo.setLayoutLogoAlpha(customStyle.getMainStyle().getLayoutLogoAlpha());
        mMainStyleRepo.setButtonColor(customStyle.getMainStyle().getButtonColor());
        mMainStyleRepo.setButtonTextColor(customStyle.getMainStyle().getButtonTextColor());
        mMainStyleRepo.setBadgeColor(customStyle.getMainStyle().getBadgeColor());
        mMainStyleRepo.setBadgeTextColor(customStyle.getMainStyle().getBadgeTextColor());
        mMainStyleRepo.setToolBarColor(customStyle.getMainStyle().getToolBarColor());
        mMainStyleRepo.setToolBarTextColor(customStyle.getMainStyle().getToolBarTextColor());
        mMainStyleRepo.setToolBarIcon(customStyle.getMainStyle().getToolBarIcon());

        mScannedStyleRepo.setStatusBarColor(customStyle.getScannedStyle().getStatusBarColor());
        mScannedStyleRepo.setToolBarColor(customStyle.getScannedStyle().getToolBarColor());
        mScannedStyleRepo.setToolBarTextColor(customStyle.getScannedStyle().getToolBarTextColor());
        mScannedStyleRepo.setToolBarIcon(customStyle.getScannedStyle().getToolBarIcon());
        mScannedStyleRepo.setLayoutColor(customStyle.getScannedStyle().getBackgroundColor());
        mScannedStyleRepo.setLayoutTextColor(customStyle.getScannedStyle().getBackgroundColor());
        mScannedStyleRepo.setSingleRowTextColor(customStyle.getScannedStyle().getBackgroundTextColor());
        mScannedStyleRepo.setSingleRowDelButtonImage(customStyle.getScannedStyle().getSingleRowDelButtonImage());
        mScannedStyleRepo.setSendButtonColor(customStyle.getScannedStyle().getSendButtonColor());
        mScannedStyleRepo.setSendButtonTextColor(customStyle.getScannedStyle().getSendButtonTextColor());
        mScannedStyleRepo.setLogoAlpha(customStyle.getScannedStyle().getLogoAlpha());
        mScannedStyleRepo.setLogoVisible(customStyle.getScannedStyle().isLogoVisible());
        mScannedStyleRepo.setFabTintColor(customStyle.getScannedStyle().getFabTintColor());
        mScannedStyleRepo.setFabRippleColor(customStyle.getScannedStyle().getFabRippleColor());
        mScannedStyleRepo.setFabLogo(customStyle.getScannedStyle().getFabLogo());

        mMailStyleRepo.setStatusBarColor(customStyle.getMailStyle().getStatusBarColor());
        mMailStyleRepo.setBackgroundColor(customStyle.getMailStyle().getBackgroundColor());
        mMailStyleRepo.setTextColor(customStyle.getMailStyle().getBackgroundTextColor());
        mMailStyleRepo.setLogoAlpha(customStyle.getMailStyle().getLogoAlpha());
        mMailStyleRepo.setLogoVisible(customStyle.getMailStyle().isLogoVisible());
        mMailStyleRepo.setSingleRowColor(customStyle.getMailStyle().getSingleRowColor());
        mMailStyleRepo.setSingleRowTextColor(customStyle.getMailStyle().getSingleRowTextColor());
        mMailStyleRepo.setSingleRowUnreadColor(customStyle.getMailStyle().getSingleRowUnreadColor());
        mMailStyleRepo.setSingleRowUnreadTextColor(customStyle.getMailStyle().getSingleRowUnreadTextColor());

        mSingleMailStyleRepo.setStatusBarColor(customStyle.getSingleMailStyle().getStatusBarColor());
        mSingleMailStyleRepo.setBackgroundColor(customStyle.getSingleMailStyle().getBackgroundColor());
        mSingleMailStyleRepo.setBackgroundTextColor(customStyle.getSingleMailStyle().getBackgroundTextColor());
        mSingleMailStyleRepo.setDelButtonColor(customStyle.getSingleMailStyle().getDelButtonColor());
        mSingleMailStyleRepo.setDelButtonTextColor(customStyle.getSingleMailStyle().getDelButtonTextColor());
        mSingleMailStyleRepo.setLogoAlpha(customStyle.getSingleMailStyle().getLogoAlpha());
        mSingleMailStyleRepo.setLogoVisible(customStyle.getSingleMailStyle().isLogoVisible());

        mQrStyleRepo.setStatusBarColor(customStyle.getQrStyle().getStatusBarColor());
        mQrStyleRepo.setBackgroundColor(customStyle.getQrStyle().getBackgroundColor());
        mQrStyleRepo.setBackgroundTextColor(customStyle.getQrStyle().getBackgroundTextColor());
        mQrStyleRepo.setLogoAlpha(customStyle.getQrStyle().getLogoAlpha());
        mQrStyleRepo.setLogoVisible(customStyle.getQrStyle().isLogoVisible());
        if (background) {
            new AppConfigurationConfirmAsyncTask().execute("Custom_style");
        }
    }
}
