package tests.day19_testNGreports_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {
    @Test
    public void amazonTopluArama(){
        //amazon ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // verilen listedeki her bir urun icin arama yaptirin
        String[] aranacakUrunler={"Nutella","Java","Armut","Cokokrem","Erik","malatya"};
        AmazonPage amazonPage=new AmazonPage();
        String aramaSonucu;
        String[] aramaSonuckelimeleri;
        String aramasonucSayisiStr;
        int aramaSonucSayisiInt;
        //her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin
        for (int i=0; i<aranacakUrunler.length;i++){
           amazonPage.aramaKutusu.sendKeys(aranacakUrunler[i]+ Keys.ENTER);
           aramaSonucu=amazonPage.sonucYaziElementi.getText();
           aramaSonuckelimeleri=aramaSonucu.split(" ");
           if(aramaSonuckelimeleri[2].equals("over")){
               aramasonucSayisiStr=aramaSonuckelimeleri[3];
           }else {
               aramasonucSayisiStr=aramaSonuckelimeleri[2];
           }
           aramasonucSayisiStr=aramasonucSayisiStr.replaceAll("\\D","");
           aramaSonucSayisiInt=Integer.parseInt(aramasonucSayisiStr);
        }

    }
}
