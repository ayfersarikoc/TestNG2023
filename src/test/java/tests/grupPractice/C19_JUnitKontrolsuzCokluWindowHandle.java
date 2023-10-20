package tests.grupPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuAppPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class C19_JUnitKontrolsuzCokluWindowHandle {


    @Test
    public void test01(){
        HerokuAppPage herokuAppPage=new HerokuAppPage();
        // https://the-internet.herokuapp.com/iframe url'ine gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuappUrl"));
        String ilksayfaWhd= Driver.getDriver().getWindowHandle();

        // sayfa basliginin Internet icerdigini test edin.
       String actualTitle= Driver.getDriver().getTitle();
       String expectedTitle="Internet";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Elemental Selenium linkini tiklayin
        herokuAppPage.elementalSeleniumYaziElementi.click();

        // Yeni acilan tab'in Title'inin Selenium icerdigini test edin
        String ikinciWhd="";
        Set<String> whdSeti=Driver.getDriver().getWindowHandles();
        for (String each:whdSeti
             ) {
            if(!each.equals(ilksayfaWhd)){
                ikinciWhd=each;
            }

        }
        Driver.getDriver().switchTo().window(ikinciWhd);
        String actual2Title=Driver.getDriver().getTitle();
        String expected2Title="Selenium";
        Assert.assertTrue(actual2Title.contains(expected2Title));

        // Ilk sayfaya donup url'in internet icerdigini test edin
        Driver.getDriver().switchTo().window(ilksayfaWhd);
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="internet";

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        Driver.getDriver().quit();


    }

}
