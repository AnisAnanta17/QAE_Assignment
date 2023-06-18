import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static java.sql.DriverManager.println;

@RunWith(SerenityRunner.class)
public class QAE_assessment {

    @Steps
    private QRGeneratorSteps QR;
    @Steps
    decodeSteps decode;

    @Managed(driver = "chrome")
    WebDriver browser;

    @Test
    public void GenerateQRSMS() {
        QR.userIsNavigateToTheQRGenerator();
        QR.UserInputforSMSParameter();
        try {
            QR.UserDownloadtheQR("QRSMS.png");
        } catch (Exception e) {
            e.printStackTrace();

        }
        decode.userNavigateTotheQRDecoderSite();
        decode.userDecodetheQR();
        decode.verifyTheQRContent();
    }


    @Test
    public void ValidatePhoneNumberNumericOnly() {
        QR.userIsNavigateToTheQRGenerator();
        QR.UserInputInvalidPhoneNumber();
        QR.verifyInvalidPhoneNumberErrorMessage();
    }
}