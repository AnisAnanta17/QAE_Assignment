import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://m28dev.github.io/qrdecoder/")
public class Decoder extends PageObject {

    public void uploadFile() {
        String filepath;
        filepath = System.getProperty("user.dir")+ "/QRSMS.png";
        $("#qrcode").sendKeys(filepath);


        $("//button[text() = \"Submit\"]").click();
    }
    public void verifyQRContent(String QRcontent){
        $("#decoded").shouldContainText(QRcontent);

    }

}
