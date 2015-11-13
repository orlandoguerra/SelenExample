package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class TNSNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "Drivers\\chromedriver.exe");
		WebDriver driver = new InternetExplorerDriver();

		driver.get("http://oberth/project/tnsnames.php");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Map<String, String> valuesIdentitySSP = new HashMap<String, String>();
		Map<String, String> valuesIdentityTIERS = new HashMap<String, String>();
		
		
		Select envId = new Select(driver.findElement(By.xpath("//*[@id='EnvId']")));
		List<WebElement> options = envId.getOptions();
		List<String> optionString = new ArrayList<String>();
		for (WebElement webElement : options) {
			optionString.add(webElement.getText());
		}
		
		
		for (String opt : optionString) {
			
			envId = new Select(driver.findElement(By.xpath("//*[@id='EnvId']")));
			if(opt.startsWith("TIERS")){
				envId.selectByVisibleText(opt);
				driver.findElement(By.xpath("html/body/form/center/input")).click();

				if (driver.findElements(By.xpath("html/body/h3/b/center/center/table/tbody/tr[6]/td[2]")).size() != 0){
					System.out.println("#"+opt);
					
					String userNameTiers = driver.findElement(By.xpath("html/body/h3/b/center/center/table/tbody/tr[3]/td[2]")).getText();
					String userPwdTiers = driver.findElement(By.xpath("html/body/h3/b/center/center/table/tbody/tr[3]/td[3]")).getText();
					String tnsTiers = driver.findElement(By.xpath("html/body/h3/b/center/center/table/tbody/tr[3]/td[4]")).getText().replaceAll(" ", "");
							
					String userNameSSP = driver.findElement(By.xpath("html/body/h3/b/center/center/table/tbody/tr[6]/td[2]")).getText();
					String userPwdSSP = driver.findElement(By.xpath("html/body/h3/b/center/center/table/tbody/tr[6]/td[3]")).getText();
					String tnsSSP = driver.findElement(By.xpath("html/body/h3/b/center/center/table/tbody/tr[6]/td[4]")).getText().replaceAll(" ", "");
				
					System.out.println(tnsTiers);
					System.out.println(tnsSSP);
					
					String valueSSP = userNameSSP+"/"+userPwdSSP+"@"+tnsSSP.substring(0, tnsSSP.indexOf("="));
					String valueTIERS = userNameTiers+"/"+userPwdTiers+"@"+tnsTiers.substring(0, tnsTiers.indexOf("="));
					
					valuesIdentitySSP.put(opt, valueSSP);
					valuesIdentityTIERS.put(opt, valueTIERS);
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
		
		
		Set<Entry<String, String>> keySSP =  valuesIdentitySSP.entrySet();
		
		for (Entry<String, String> entry : keySSP) {
			System.out.println("<-------------"+entry.getKey()+"--------------------------->");
			System.out.println(valuesIdentityTIERS.get(entry.getKey()));
			System.out.println(valuesIdentitySSP.get(entry.getKey()));
			
		}
		
		
		//<-------------TIERS_LOCAL1--------------------------->
		//TIERS1CON/GJKYW3L3FDP1G0@Tiers_Online_Local01
		//.selectByValue("number:4");
		

	}

}
