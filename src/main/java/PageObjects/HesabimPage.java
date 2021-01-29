package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HesabimPage {
	
	public HesabimPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/mail_auth_button")
	public WebElement giris_yap_butonu;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Kullanıcı adı veya e-posta adresi']")
	public WebElement kullanici_adi;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Şifreniz']")
	public WebElement sifre;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/btn_login")
	public WebElement login_button;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Çıkış Yap']")
	public WebElement cikis_yap;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/textinput_error")
	public List<WebElement> kirmizi_hatalar;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Giriş bilgileriniz hatalı']")
	public WebElement hatali;

}
