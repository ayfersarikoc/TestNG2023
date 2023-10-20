package tests.day16_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_QualitydemyNegatifLoginTesti {

    QualitydemyPage qualitydemyPage;
   @Test
   /*NegativeTest
1- https://www.qualitydemy.com/ anasayfasina gidin
2- login linkine basin
3- Kullanvalid 3 farkli test method’u olusturun.
- gecerli username, gecersiz password
- gecersiz username, gecerli password
- gecersiz username, gecersiz password.
4- Login butonuna basarak login olun
5- Basarili olarak giris yapilamadigini test edin

    */
    public void gecersizPsswordTest() {
       Driver.getDriver().get("https://www.qualitydemy.com/");
       qualitydemyPage=new QualitydemyPage();
       qualitydemyPage.ilkLoginLinki.click();

qualitydemyPage.cookieAcceptElement.click();
       qualitydemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
       qualitydemyPage.passwordKutusu.sendKeys("12345");
       ReusableMethods.bekle(2);
       qualitydemyPage.loginButonu.click();
       ReusableMethods.bekle(2);
       Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
       Driver.closeDriver();

   }
    @Test
    public void gecersizEmailTest(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.cookieAcceptElement.click();
        qualitydemyPage.emailKutusu.sendKeys("alican@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");
        ReusableMethods.bekle(2);
        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(1);
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void gecersizEmailPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage=new QualitydemyPage();
        ReusableMethods.bekle(3);
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.cookieAcceptElement.click();
        qualitydemyPage.emailKutusu.sendKeys("alican@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("12345");
        ReusableMethods.bekle(5);
        qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(3);
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }
}
