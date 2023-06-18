import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;

import java.net.URL;


@DefaultUrl("http://zxing.appspot.com/generator/")
public class QRGenerator extends PageObject {
/*
    WebElementFacade contents = $("//select[@class= \"gwt-ListBox\"]");
    WebElementFacade PhoneNumber =  $("//td[contains(text(),\"Phone number\")]/following-sibling::td/input");
    WebElementFacade Message = $("//td[contains(text(),\"Message\")]/following-sibling::td/input");
*/

    public void inputParametersSMS(String phoneNumber, String message) {
        $("//select[@class= \"gwt-ListBox\"]").selectByValue("SMS");
        $("//td[contains(text(),\"Phone number\")]/following-sibling::td/input").sendKeys(phoneNumber);
        $("//td[contains(text(),\"Message\")]/following-sibling::td/textarea").sendKeys(message);
    }

    public void generateQRCode() {
        $("//td[contains(text(),\"Barcode size\")]/following-sibling::td/select").selectByVisibleText("Medium");
        $("//td[contains(text(),\"Error correction\")]/following-sibling::td/select").selectByValue("M");
        $("//td[contains(text(),\"Character encoding\")]/following-sibling::td/select").selectByValue("UTF-8");
        $(".gwt-Button").click();
        //$("//a[text() = \"Download\"]").click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDownloadURL() {
        String download = $("#downloadlink").getAttribute("href");
        return download;

    }
    public void verifyErrorMessage(){
        $("#errorMessageID").shouldContainText("Phone number must be digits only.");
    }
}


