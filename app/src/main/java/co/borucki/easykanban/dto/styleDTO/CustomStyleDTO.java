package co.borucki.easykanban.dto.styleDTO;


public class CustomStyleDTO {
   private LoginStyleDTO loginStyleDTO;
   private MailStyleDTO mailStyleDTO;
   private SingleMailStyleDTO singleMailStyleDTO;
   private MainStyleDTO mainStyleDTO;
   private QrStyleDTO qrStyleDTO;
   private ScannedStyleDTO scannedStyleDTO;
   private SplashStyleDTO splashStyleDTO;

    public CustomStyleDTO() {
    }

    public CustomStyleDTO(LoginStyleDTO loginStyleDTO
            , MailStyleDTO mailStyleDTO
            , SingleMailStyleDTO singleMailStyleDTO
            , MainStyleDTO mainStyleDTO
            , QrStyleDTO qrStyleDTO
            , ScannedStyleDTO scannedStyleDTO
            , SplashStyleDTO splashStyleDTO) {
        this.loginStyleDTO = loginStyleDTO;
        this.mailStyleDTO = mailStyleDTO;
        this.singleMailStyleDTO = singleMailStyleDTO;
        this.mainStyleDTO = mainStyleDTO;
        this.qrStyleDTO = qrStyleDTO;
        this.scannedStyleDTO = scannedStyleDTO;
        this.splashStyleDTO = splashStyleDTO;
    }

    public LoginStyleDTO getLoginStyleDTO() {
        return loginStyleDTO;
    }

    public void setLoginStyleDTO(LoginStyleDTO loginStyleDTO) {
        this.loginStyleDTO = loginStyleDTO;
    }

    public MailStyleDTO getMailStyleDTO() {
        return mailStyleDTO;
    }

    public void setMailStyleDTO(MailStyleDTO mailStyleDTO) {
        this.mailStyleDTO = mailStyleDTO;
    }

    public SingleMailStyleDTO getSingleMailStyleDTO() {
        return singleMailStyleDTO;
    }

    public void setSingleMailStyleDTO(SingleMailStyleDTO singleMailStyleDTO) {
        this.singleMailStyleDTO = singleMailStyleDTO;
    }

    public MainStyleDTO getMainStyleDTO() {
        return mainStyleDTO;
    }

    public void setMainStyleDTO(MainStyleDTO mainStyleDTO) {
        this.mainStyleDTO = mainStyleDTO;
    }

    public QrStyleDTO getQrStyleDTO() {
        return qrStyleDTO;
    }

    public void setQrStyleDTO(QrStyleDTO qrStyleDTO) {
        this.qrStyleDTO = qrStyleDTO;
    }

    public ScannedStyleDTO getScannedStyleDTO() {
        return scannedStyleDTO;
    }

    public void setScannedStyleDTO(ScannedStyleDTO scannedStyleDTO) {
        this.scannedStyleDTO = scannedStyleDTO;
    }

    public SplashStyleDTO getSplashStyleDTO() {
        return splashStyleDTO;
    }

    public void setSplashStyleDTO(SplashStyleDTO splashStyleDTO) {
        this.splashStyleDTO = splashStyleDTO;
    }
}
