package MainGittiGidiyor.GittiGidiyorFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AnasayfaPage;
import PageObjects.HesabimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GirisYapNoInput extends BaseGittiGidiyor{
	
	@Test
	public void no_input() 
	{
		AnasayfaPage anasayfa = new AnasayfaPage(driver);
		HesabimPage hesabim = new HesabimPage(driver);
		
		anasayfa.hesabım_anasayfa.click();
		hesabim.giris_yap_butonu.click();
		hesabim.login_button.click();
		
		assertEquals(hesabim.kirmizi_hatalar.get(0).isDisplayed() && hesabim.kirmizi_hatalar.get(1).isDisplayed(), true);
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

}
