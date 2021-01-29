package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AnasayfaPage {
	
	public AnasayfaPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/appbar_search_text_autoCompleteTextView")
	public WebElement arama_kutusu;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sepetim']")
	public WebElement sepetim_anasayfa;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hesabım']")
	public WebElement hesabım_anasayfa;

}
