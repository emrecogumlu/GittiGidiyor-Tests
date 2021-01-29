package MainGittiGidiyor.GittiGidiyorFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.AnasayfaPage;
import PageObjects.HesabimPage;
import PageObjects.SepetPage;
import PageObjects.UrunSayfasiPage;
import PageObjects.UrunlerPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class UrunEkleCikar extends BaseGittiGidiyor{
	
	@Test
	public void urun_ekle_cikar() throws InterruptedException 
	{
		AnasayfaPage anasayfa = new AnasayfaPage(driver);
		Utilities utilities = new Utilities(driver);
		UrunlerPage urunlerPage = new UrunlerPage(driver);
		UrunSayfasiPage urunsayfasi = new UrunSayfasiPage(driver);
		SepetPage sepet = new SepetPage(driver);
		
		anasayfa.arama_kutusu.click();
		anasayfa.arama_kutusu.sendKeys("bilgisayar");
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(960, 1850)).perform();
		
		int min=0;
		int max=1;
		Random rnd = new Random();
		
		int num=rnd.nextInt(max-min+1)+min;
	
		urunlerPage.urunler.get(num).click();
		
		String fiyat = urunsayfasi.urunun_fiyati.getText();
		
		utilities.scrollIntoText("Sepete Ekle");
		
		urunsayfasi.sepete_ekle_butonu.click();
		
		anasayfa.sepetim_anasayfa.click();
		
		String total_fiyat = sepet.total_ucret.getText();
		
		total_fiyat = total_fiyat.replace(" TL", "");
		
		assertEquals(total_fiyat, fiyat);
		
		sepet.adet_belirle.click();
		
		String iki_tane = sepet.iki_adet.getText();
		
		sepet.iki_adet.click();
		
		Thread.sleep(3000);
		
		String adet_miktarim = sepet.toplam_adet.getText();
		
		assertEquals(iki_tane, adet_miktarim);
		
		sepet.sepetten_kaldir.click();
		
		sepet.evet.click();
		
		assertEquals(sepet.sepet_bos.isDisplayed(), true);
		
		
		
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
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
	@Parameters({"gecerli_mail","gecerli_sifre"})
	@BeforeTest
	public void log_in_valid(String gecerli_mail,String gecerli_sifre) throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GittiGidiyorApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		AnasayfaPage anasayfam = new AnasayfaPage(driver);
		HesabimPage hesabim = new HesabimPage(driver);
		Utilities utilities = new Utilities(driver);
		
		anasayfam.hesabım_anasayfa.click();
		
		hesabim.giris_yap_butonu.click();
		
		hesabim.kullanici_adi.click();
		
		hesabim.kullanici_adi.sendKeys(gecerli_mail);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.sifre.click();
		
		hesabim.sifre.sendKeys(gecerli_sifre);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.login_button.click();
		
		Thread.sleep(15000);
		
		anasayfam.hesabım_anasayfa.click();
		
		utilities.scrollIntoText("Çıkış Yap");
		
		assertEquals(hesabim.cikis_yap.isDisplayed(), true);
		
		service.stop();
	}
	
	@AfterTest
	public void log_out() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GittiGidiyorApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		AnasayfaPage anasayfamm = new AnasayfaPage(driver);
		Utilities utilities = new Utilities(driver);
		HesabimPage hesabimm = new HesabimPage(driver);
		
		anasayfamm.hesabım_anasayfa.click();
		
		utilities.scrollIntoText("Çıkış Yap");
		
		hesabimm.cikis_yap.click();
		
		service.stop();
		
		
	}

}
