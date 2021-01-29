package MainGittiGidiyor.GittiGidiyorFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.AnasayfaPage;
import PageObjects.HesabimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GirisYapYanlisBilgi extends BaseGittiGidiyor{
	
	@Test
	public void yanlis_bilgi() throws InterruptedException 
	{
		AnasayfaPage anasayfa = new AnasayfaPage(driver);
		HesabimPage hesabim = new HesabimPage(driver);
		Utilities utilities = new Utilities(driver);
		
		anasayfa.hesabım_anasayfa.click();
		
		hesabim.giris_yap_butonu.click();
		
		String mailString=utilities.randomMail();
		String sifreString=utilities.randomPassword(6);
		
		hesabim.kullanici_adi.click();
		hesabim.kullanici_adi.sendKeys(mailString);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.sifre.click();
		hesabim.sifre.sendKeys(sifreString);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.login_button.click();
		
		Thread.sleep(15000);
		
		assertEquals(hesabim.hatali.isDisplayed(), true);
		
	}
	
	@BeforeMethod
	public void BeforeMethod() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GittiGidiyorApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
	}
	
	@AfterMethod
	public void AfterMethod() 
	{
		service.stop();
	}

}
