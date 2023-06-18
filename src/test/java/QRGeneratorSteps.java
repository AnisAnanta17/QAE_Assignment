import net.thucydides.core.annotations.Step;

import java.net.URL;

public class QRGeneratorSteps {
    private QRGenerator QR;
    String phoneNumber = "0812212151";
    String message = "This is for automation";
    String phoneNumberInvalid = "asdasd!@#";
    @Step
    public void userIsNavigateToTheQRGenerator(){
        QR.open();
    }

    @Step
    public void UserInputforSMSParameter(){
        QR.inputParametersSMS(phoneNumber, message);
        QR.generateQRCode();
    }

    @Step
    public void UserDownloadtheQR(String filename) throws Exception {
        URL url = new URL(QR.getDownloadURL());
        utils.downloadFile(url, filename);
        Thread.sleep(3000);
    }
    @Step
    public void UserInputInvalidPhoneNumber(){
        QR.inputParametersSMS(phoneNumberInvalid, message);
        QR.generateQRCode();
    }

    @Step
    public void verifyInvalidPhoneNumberErrorMessage(){
    QR.verifyErrorMessage();
    }
}
