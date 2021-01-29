package MainGittiGidiyor.GittiGidiyorFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.AnasayfaPage;
import PageObjects.HesabimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GirisYapAzKarakter extends BaseGittiGidiyor{
	
	@Parameters({"gecerli_mail","az_karakterli_sifre"})
	@Test
	public void az_karakter(String gecerli_mail,String az_karakterli_sifre) 
	{
		AnasayfaPage anasayfa = new AnasayfaPage(driver);
		HesabimPage hesabim = new HesabimPage(driver);
		
		anasayfa.hesabım_anasayfa.click();
		
		hesabim.giris_yap_butonu.click();
		
		hesabim.kullanici_adi.click();
		hesabim.kullanici_adi.sendKeys(gecerli_mail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.sifre.click();
		hesabim.sifre.sendKeys(az_karakterli_sifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.login_button.click();
		
		assertEquals(hesabim.kirmizi_hatalar.get(0).isDisplayed(), true);
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
