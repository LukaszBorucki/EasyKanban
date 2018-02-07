package co.borucki.easykanban.dto;

public class CustomerDTO {
    private String name;
    private String mailAddress;
    private String mailPassword;
    private String mailHost;
    private int mailSMTPPort;
    private String mailTo;
    private String licenceOwner;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String mailAddress, String mailPassword, String mailHost, int mailSMTPPort, String mailTo, String licenceOwner) {
        this.name = name;
        this.mailAddress = mailAddress;
        this.mailPassword = mailPassword;
        this.mailHost = mailHost;
        this.mailSMTPPort = mailSMTPPort;
        this.mailTo = mailTo;
        this.licenceOwner = licenceOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public int getMailSMTPPort() {
        return mailSMTPPort;
    }

    public void setMailSMTPPort(int mailSMTPPort) {
        this.mailSMTPPort = mailSMTPPort;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getLicenceOwner() {
        return licenceOwner;
    }

    public void setLicenceOwner(String licenceOwner) {
        this.licenceOwner = licenceOwner;
    }
}
