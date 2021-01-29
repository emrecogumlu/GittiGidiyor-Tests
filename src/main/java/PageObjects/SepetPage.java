package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SepetPage {
	
	public SepetPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/total_price")
	public WebElement total_ucret;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/spnAmountDownArrow")
	public WebElement adet_belirle;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='2']")
	public WebElement iki_adet;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/basketItemProductQuantityTV")
	public WebElement toplam_adet;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/txtProductTitle")
	public WebElement urun_adi;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sepetinizde ürün bulunmamaktadır.']")
	public WebElement sepet_bos;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/txtDelete")
	public WebElement sepetten_kaldir;
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement evet;
}
