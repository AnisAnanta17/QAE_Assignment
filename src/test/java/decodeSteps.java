import net.thucydides.core.annotations.Step;

public class decodeSteps {
    private Decoder decoder;
    String path = "QR.png";
    String QRContent = "smsto:0812212151:This is for automation";

    @Step
    public void userNavigateTotheQRDecoderSite(){
        decoder.open();
    }

    @Step
    public void userDecodetheQR(){
        decoder.uploadFile();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Step
    public void verifyTheQRContent(){
    decoder.verifyQRContent(QRContent);
    }
}
