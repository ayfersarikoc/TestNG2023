package tests.day19_testNGreports_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {
    @Test
    public void nutellaTesti() {
        extentTest=extentReports.createTest("Amazon arama Testi","Kullanici amazonda Nutella aratip ilk urune gidebilmeli");
        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici anasayfaya gider");
        // url'in amazon icerdigini test edelim
        String expectedIcerik = "amazon";
        String actualUrl1=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl1.contains(expectedIcerik));
        extentTest.pass("url'nin amazon icerdigini test eder");
        // aranacak kelimeyi aratalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
extentTest.info("Test datasi olarak belirlenen kelimeyi aratir");
        // sonuclarin aranacak kelimeyi icerdigini test edelim
        String expectedSonucIcerik =ConfigReader.getProperty("amazonAranacakKelime");
        String actualSonucYazisi =amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));
extentTest.pass("amazon arama sonuclarinin  aranan kelimeyi icerdigini test eder");
        // ilk urune tiklayalim
        amazonPage.ilkUrunElementi.click();
        extentTest.info("ilk urune tiklar");
        // ilk urun isminde aranacak kelime bulundugunu test edelim

        String expectedUrunIcerik =ConfigReader.getProperty("amazonAranacakKelime");
        String actualIsim =amazonPage.ilkUrunIsimElementi.getText();

        Assert.assertTrue(actualIsim.contains(expectedUrunIcerik));
extentTest.pass("ilk urun isminde aranan kelime bulundugunu test eder" );

        // sayfayi kapatalim

        Driver.closeDriver();
extentTest.info("sayfayi kapatir");
    }
}
