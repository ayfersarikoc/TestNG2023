package tests.grupPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_JUnit_iframe {

            @Test

            public void IframeTest(){
                // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.

                Driver.getDriver().get(ConfigReader.getProperty("herokuappUrl"));

                HerokuAppPage herokuAppPage=new HerokuAppPage();
                // 2 ) Bir metod olusturun: iframeTest
                //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
                //  konsolda yazdirin.
                Assert.assertTrue(herokuAppPage.iframeYaziElementi.isEnabled());

                //  - Text Box’a “Merhaba Dunya!” yazin.
        /*
            Locate dogru oldugu halde
            webelement'i kullanamiyorsak
            webelement bir iframe icinde olabilir
            Eger iframe icinde ise
            - once o iframe'i locate etmeli
            - locate ettigimiz iframe'e gecis yapmali
            - sonra istenen islemi gerceklestirmeliyiz
            Iframe'e gecis yapinca
            driver'imiz artik o sayfaya gecmis olur
            anasayfadaki webelementleri goremez
            Eger testimizde iframe disindan element kullanmamiz gerekirse
            once iframe'den disari cikmamiz lazim
            driver.switchTo().defaultContent();
         */
                Driver.getDriver().switchTo().frame(herokuAppPage.ilkiframeElementi);

               herokuAppPage.textBoxKutuElementi.clear();
                ReusableMethods.bekle(2);

               herokuAppPage.textBoxKutuElementi.sendKeys("Merhaba Dunya");




                //  - TextBox’in altinda bulunan “Elemental Selenium”
                //    linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
                //iframe'e gecen driver'i yeniden anasayfaya dondurmemiz gerekir
                Driver.getDriver().switchTo().defaultContent();
                Assert.assertTrue(herokuAppPage.elementalSeleniumYaziElementi.isDisplayed());
                System.out.println(herokuAppPage.elementalSeleniumYaziElementi.getText());

                Driver.closeDriver();
            }
}

