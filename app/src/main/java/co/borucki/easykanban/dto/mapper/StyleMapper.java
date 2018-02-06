package co.borucki.easykanban.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import co.borucki.easykanban.dto.styleDTO.CustomStyleDTO;
import co.borucki.easykanban.dto.styleDTO.LoginStyleDTO;
import co.borucki.easykanban.dto.styleDTO.MailStyleDTO;
import co.borucki.easykanban.dto.styleDTO.MainStyleDTO;
import co.borucki.easykanban.dto.styleDTO.QrStyleDTO;
import co.borucki.easykanban.dto.styleDTO.ScannedStyleDTO;
import co.borucki.easykanban.dto.styleDTO.SingleMailStyleDTO;
import co.borucki.easykanban.dto.styleDTO.SplashStyleDTO;
import co.borucki.easykanban.model.style.CustomStyle;
import co.borucki.easykanban.model.style.LoginStyle;
import co.borucki.easykanban.model.style.MailStyle;
import co.borucki.easykanban.model.style.MainStyle;
import co.borucki.easykanban.model.style.QrStyle;
import co.borucki.easykanban.model.style.ScannedStyle;
import co.borucki.easykanban.model.style.SingleMailStyle;
import co.borucki.easykanban.model.style.SplashStyle;

public class StyleMapper {
    public static CustomStyle fromCustomStyleDTOToCustomStyle(CustomStyleDTO styleDTO) {
        return new CustomStyle(fromLoginStyleDTOToLoginStyle(styleDTO.getLoginStyleDTO())
                , fromMailStyleDTOToMailStyle(styleDTO.getMailStyleDTO())
                , fromSingleMailStyleDTOToSingleMailStyle(styleDTO.getSingleMailStyleDTO())
                , fromMainStyleDTOToMainStyle(styleDTO.getMainStyleDTO())
                , fromQrStyleDTOToQrStyle(styleDTO.getQrStyleDTO())
                , fromScannedStyleDTOToScannedStyle(styleDTO.getScannedStyleDTO())
                , fromSplashStyleDTOToSplashStyle(styleDTO.getSplashStyleDTO()));
    }

    public static List<CustomStyle> fromCustomStyleDTOToCustomStyle(List<CustomStyleDTO> styleDTOs) {
        List<CustomStyle> customStyleList = new ArrayList<>();
        for (CustomStyleDTO styleDTO : styleDTOs) {
            customStyleList.add(fromCustomStyleDTOToCustomStyle(styleDTO));
        }
        return customStyleList;
    }

    public static LoginStyle fromLoginStyleDTOToLoginStyle(LoginStyleDTO styleDTO) {
        return new LoginStyle(styleDTO.getBackgroundColor()
                , styleDTO.getBackgroundTextColor()
                , styleDTO.getToolBarColor()
                , styleDTO.getToolBarTextColor()
                , styleDTO.getStatusBarColor()
                , styleDTO.getToolBarIcon());
    }

    public static List<LoginStyle> fromLoginStyleDTOToLoginStyle(List<LoginStyleDTO> styleDTOs) {
        List<LoginStyle> loginStyleList = new ArrayList<>();
        for (LoginStyleDTO styleDTO : styleDTOs) {
            loginStyleList.add(fromLoginStyleDTOToLoginStyle(styleDTO));
        }

        return loginStyleList;
    }

    public static MailStyle fromMailStyleDTOToMailStyle(MailStyleDTO styleDTO) {
        return new MailStyle(styleDTO.getStatusBarColor()
                , styleDTO.getBackgroundColor()
                , styleDTO.getBackgroundTextColor()
                , styleDTO.getLogoAlpha()
                , styleDTO.isLogoVisible() > 0
                , styleDTO.getSingleRowColor()
                , styleDTO.getSingleRowTextColor()
                , styleDTO.getSingleRowUnreadColor()
                , styleDTO.getSingleRowUnreadTextColor()
        );
    }

    public static List<MailStyle> fromMailStyleDTOToMailStyle(List<MailStyleDTO> styleDTOs) {
        List<MailStyle> mailStyleList = new ArrayList<>();
        for (MailStyleDTO styleDTO : styleDTOs) {
            mailStyleList.add(fromMailStyleDTOToMailStyle(styleDTO));
        }
        return mailStyleList;
    }

    public static MainStyle fromMainStyleDTOToMainStyle(MainStyleDTO styleDTO) {
        return new MainStyle(styleDTO.getStatusBarColor()
                , styleDTO.getLayoutColor()
                , styleDTO.getLayoutTextColor()
                , styleDTO.getLayoutLogoShow() > 0
                , styleDTO.getLayoutLogoAlpha()
                , styleDTO.getButtonColor()
                , styleDTO.getButtonTextColor()
                , styleDTO.getBadgeColor()
                , styleDTO.getBadgeTextColor()
                , styleDTO.getToolBarColor()
                , styleDTO.getToolBarTextColor()
                , styleDTO.getToolBarIcon());
    }

    public static List<MainStyle> fromMainStyleDTOToMainStyle(List<MainStyleDTO> styleDTOs) {
        List<MainStyle> mainStyleList = new ArrayList<>();
        for (MainStyleDTO styleDTO : styleDTOs) {
            mainStyleList.add(fromMainStyleDTOToMainStyle(styleDTO));
        }
        return mainStyleList;
    }

    public static QrStyle fromQrStyleDTOToQrStyle(QrStyleDTO styleDTO) {
        return new QrStyle(styleDTO.getStatusBarColor()
                , styleDTO.getBackgroundColor()
                , styleDTO.getBackgroundTextColor()
                , styleDTO.getLogoAlpha()
                , styleDTO.isLogoVisible() > 0);
    }

    public static List<QrStyle> fromQrStyleDTOToQrStyle(List<QrStyleDTO> styleDTOs) {
        List<QrStyle> qrStyleList = new ArrayList<>();
        for (QrStyleDTO styleDTO : styleDTOs) {
            qrStyleList.add(fromQrStyleDTOToQrStyle(styleDTO));
        }
        return qrStyleList;
    }

    public static ScannedStyle fromScannedStyleDTOToScannedStyle(ScannedStyleDTO styleDTO) {
        return new ScannedStyle(styleDTO.getStatusBarColor()
                , styleDTO.getToolBarColor()
                , styleDTO.getToolBarTextColor()
                , styleDTO.getToolBarIcon()
                , styleDTO.getBackgroundColor()
                , styleDTO.getBackgroundTextColor()
                , styleDTO.getSingleRowTextColor()
                , styleDTO.getSingleRowDelButtonImage()
                , styleDTO.getSendButtonColor()
                , styleDTO.getSendButtonTextColor()
                , styleDTO.getLogoAlpha()
                , styleDTO.isLogoVisible() > 0
                , styleDTO.getFabTintColor()
                , styleDTO.getFabRippleColor()
                , styleDTO.getFabLogo());
    }

    public static List<ScannedStyle> fromScannedStyleDTOToScannedStyle(List<ScannedStyleDTO> styleDTOs) {
        List<ScannedStyle> scannedStyleList = new ArrayList<>();
        for (ScannedStyleDTO styleDTO : styleDTOs) {
            scannedStyleList.add(fromScannedStyleDTOToScannedStyle(styleDTO));
        }
        return scannedStyleList;
    }

    public static SingleMailStyle fromSingleMailStyleDTOToSingleMailStyle(SingleMailStyleDTO styleDTO) {
        return new SingleMailStyle(styleDTO.getStatusBarColor()
                , styleDTO.getBackgroundColor()
                , styleDTO.getBackgroundTextColor()
                , styleDTO.getDelButtonColor()
                , styleDTO.getDelButtonTextColor()
                , styleDTO.getLogoAlpha()
                , styleDTO.isLogoVisible() > 0);
    }

    public static List<SingleMailStyle> fromSingleMailStyleDTOToSingleMailStyle(List<SingleMailStyleDTO> styleDTOs) {
        List<SingleMailStyle> singleMailStyleList = new ArrayList<>();
        for (SingleMailStyleDTO styleDTO : styleDTOs) {
            singleMailStyleList.add(fromSingleMailStyleDTOToSingleMailStyle(styleDTO));
        }
        return singleMailStyleList;
    }

    public static SplashStyle fromSplashStyleDTOToSplashStyle(SplashStyleDTO styleDTO) {
        return new SplashStyle(styleDTO.getLogo()
                , styleDTO.getSplashTime()
                , styleDTO.getTextVisible()
                , styleDTO.getCustomText()
                , styleDTO.getThanksText()
                , styleDTO.getCustomTextSize()
                , styleDTO.getThanksTextSize()
                , styleDTO.getBackgroundColor()
                , styleDTO.getBackgroundTextColor()
                , styleDTO.getStatusBarColor());
    }

    public static List<SplashStyle> fromSplashStyleDTOToSplashStyle(List<SplashStyleDTO> styleDTOs) {
        List<SplashStyle> splashStyleList = new ArrayList<>();
        for (SplashStyleDTO styleDTO : styleDTOs) {
            splashStyleList.add(fromSplashStyleDTOToSplashStyle(styleDTO));
        }
        return splashStyleList;
    }
}

