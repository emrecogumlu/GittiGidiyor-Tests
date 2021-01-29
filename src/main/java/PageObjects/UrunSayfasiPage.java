package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UrunSayfasiPage {
	
	public UrunSayfasiPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/btnAddBasket")
	public WebElement sepete_ekle_butonu;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/tv_best_deal_price")
	public WebElement urunun_fiyati;

}
