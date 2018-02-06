package co.borucki.easykanban.model.style;

public class CustomStyle {
    private LoginStyle loginStyle;
    private MailStyle mailStyle;
    private SingleMailStyle singleMailStyle;
    private MainStyle mainStyle;
    private QrStyle qrStyle;
    private ScannedStyle scannedStyle;
    private SplashStyle splashStyle;

    public CustomStyle() {
    }

    public CustomStyle(LoginStyle loginStyle
            , MailStyle mailStyle
            , SingleMailStyle singleMailStyle
            , MainStyle mainStyle
            , QrStyle qrStyle
            , ScannedStyle scannedStyle
            , SplashStyle splashStyle) {
        this.loginStyle = loginStyle;
        this.mailStyle = mailStyle;
        this.singleMailStyle = singleMailStyle;
        this.mainStyle = mainStyle;
        this.qrStyle = qrStyle;
        this.scannedStyle = scannedStyle;
        this.splashStyle = splashStyle;
    }

    public LoginStyle getLoginStyle() {
        return loginStyle;
    }

    public void setLoginStyle(LoginStyle loginStyle) {
        this.loginStyle = loginStyle;
    }

    public MailStyle getMailStyle() {
        return mailStyle;
    }

    public void setMailStyle(MailStyle mailStyle) {
        this.mailStyle = mailStyle;
    }

    public SingleMailStyle getSingleMailStyle() {
        return singleMailStyle;
    }

    public void setSingleMailStyle(SingleMailStyle singleMailStyle) {
        this.singleMailStyle = singleMailStyle;
    }

    public MainStyle getMainStyle() {
        return mainStyle;
    }

    public void setMainStyle(MainStyle mainStyle) {
        this.mainStyle = mainStyle;
    }

    public QrStyle getQrStyle() {
        return qrStyle;
    }

    public void setQrStyle(QrStyle qrStyle) {
        this.qrStyle = qrStyle;
    }

    public ScannedStyle getScannedStyle() {
        return scannedStyle;
    }

    public void setScannedStyle(ScannedStyle scannedStyle) {
        this.scannedStyle = scannedStyle;
    }

    public SplashStyle getSplashStyle() {
        return splashStyle;
    }

    public void setSplashStyle(SplashStyle splashStyle) {
        this.splashStyle = splashStyle;
    }
}
