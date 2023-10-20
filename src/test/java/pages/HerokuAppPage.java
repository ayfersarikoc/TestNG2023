package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuAppPage {
    public HerokuAppPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(tagName = "h3")
    public WebElement iframeYaziElementi;

    @FindBy(id = "mce_0_ifr")
    public WebElement ilkiframeElementi;

    @FindBy(tagName = "p")
    public WebElement textBoxKutuElementi;

    @FindBy(linkText = "Elemental Selenium")
    public WebElement elementalSeleniumYaziElementi;

    @FindBy(tagName = "h3")
    public WebElement openingBaslikElementi;

    @FindBy(linkText = "Click Here")
    public WebElement clickElementi;

    @FindBy(tagName = "h3")
    public WebElement newWindowElementi;


}
