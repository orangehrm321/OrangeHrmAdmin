package Orangehrm.Ornagehrm;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Admin {
	public WebDriver driver;
	@BeforeMethod
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system8\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin",Keys.TAB,"admin123",Keys.TAB,Keys.ENTER);
		
	}
	@AfterMethod
	public void closeapp() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test(priority=1)
	public void admin() throws InterruptedException
	{
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement usermanage=driver.findElement(By.id("menu_admin_UserManagement"));
		WebElement user=driver.findElement(By.id("menu_admin_viewSystemUsers"));
		a.moveToElement(admin).pause(3000).moveToElement(usermanage).pause(3000).moveToElement(user).click().build().perform();
		
		/*driver.findElement(By.id("menu_admin_viewAdminModule")).click();*/
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("admin143");
		Select sel=new Select(driver.findElement(By.id("searchSystemUser_userType")));
		Thread.sleep(3000);
		sel.selectByValue("2");
		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("T N VIJAYA BHASKAR");
		Select sel1=new Select(driver.findElement(By.id("searchSystemUser_status")));
		sel1.selectByValue("1");
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("resetBtn")).click();
		driver.findElement(By.name("btnAdd")).click();	
		Select sel2=new Select(driver.findElement(By.cssSelector("#systemUser_userType")));
		sel2.selectByValue("2");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"systemUser_employeeName_empName\"]")).sendKeys("Jasmine Morgan");
		driver.findElement(By.xpath("//*[@id=\"systemUser_userName\"]")).sendKeys("jasmi1");
		Select sel3=new Select(driver.findElement(By.cssSelector("#systemUser_status")));
		sel3.selectByValue("0");
		driver.findElement(By.id("systemUser_password")).sendKeys("Admin*123",Keys.TAB,"Admin*123");
		driver.findElement(By.cssSelector("#btnSave")).click();
	    driver.close();
		}
	@Test(priority=2) 
	public void job() throws InterruptedException, IOException
	{
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Job Titles']")).click();
		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		//job title menu
		driver.findElement(By.xpath("//*[@id=\"jobTitle_jobTitle\"]")).sendKeys("attender1",Keys.TAB," distribute the  files");
		driver.findElement(By.xpath("//*[@id=\"jobTitle_jobSpec\"]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\system8\\Desktop\\vijayAutoIt.exe");
		driver.findElement(By.xpath("//*[@id=\"jobTitle_note\"]")).sendKeys("vijay org file uploaded");
		driver.findElement(By.xpath("//input[@name='btnSave']")).click();
		driver.close();
	}
	
	
	
	@Test(priority=5)
	public void jobcategoires() throws InterruptedException {
	
	Actions a=new Actions(driver);
	WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
	WebElement job=driver.findElement(By.id("menu_admin_Job"));
	WebElement jobc=driver.findElement(By.id("menu_admin_jobCategory"));
	a.moveToElement(admin).pause(3000).moveToElement(job).pause(3000).moveToElement(jobc).click().build().perform();
	driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"jobCategory_name\"]")).sendKeys("attender12");
	driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
	List<WebElement> e1= driver.findElements(By.xpath("//input[@type='checkbox']"));
	e1.get(4).click();
	driver.findElement(By.xpath("//*[@id=\"btnDelete\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"dialogDeleteBtn\"]")).click();

	
	}
	
	@Test(priority=4) 
	public void jobEmpstatus() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement job=driver.findElement(By.id("menu_admin_Job"));
		WebElement empstatus=driver.findElement(By.id("menu_admin_employmentStatus"));
		a.moveToElement(admin).pause(3000).moveToElement(job).pause(3000).moveToElement(empstatus).click().build().perform();
		driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		driver.findElement(By.xpath("//input[@class='formInput']")).sendKeys("part aa time");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		Thread.sleep(3000);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(5).click();
		driver.findElement(By.xpath("//*[@id=\"btnDelete\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"dialogDeleteBtn\"]")).click();

	}
	@Test(priority=3) 
	public void jobpaygrades() throws InterruptedException
	{

		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement job=driver.findElement(By.id("menu_admin_Job"));
		WebElement paygrades=driver.findElement(By.id("menu_admin_viewPayGrades"));
		a.moveToElement(admin).pause(3000).moveToElement(job).pause(3000).moveToElement(paygrades).click().build().perform();
		driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"payGrade_name\"]")).sendKeys("daa123456");
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnAddCurrency\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"payGradeCurrency_currencyName\"]")).sendKeys("INR - Indian Rupee");
	    driver.findElement(By.xpath("//*[@id=\"payGradeCurrency_minSalary\"]")).sendKeys("55000",Keys.TAB,"100000");
	    driver.findElement(By.xpath("//*[@id=\"btnSaveCurrency\"]")).click();
	    driver.close();
	}
	@Test(priority=6) 
	public void jobWorkshift() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement job=driver.findElement(By.id("menu_admin_Job"));
		WebElement workshift=driver.findElement(By.id("menu_admin_workShift"));
		a.moveToElement(admin).pause(3000).moveToElement(job).pause(3000).moveToElement(workshift).click().build().perform();
		driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"workShift_name\"]")).sendKeys("second shift1");
		Select sel=new Select(driver.findElement(By.xpath("//*[@id=\"workShift_workHours_from\"]")));
		sel.selectByVisibleText("14:00");
		Select sel1=new Select(driver.findElement(By.xpath("//*[@id=\"workShift_workHours_to\"]")));
		sel1.selectByVisibleText("22:00");
		Thread.sleep(5000);
		Select sel2=new Select(driver.findElement(By.xpath("//*[@id=\"workShift_availableEmp\"]")));
		sel2.selectByVisibleText("Thomas Fleming");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAssignEmployee")).click();
		Select sel3=new Select(driver.findElement(By.xpath("//*[@id=\"workShift_availableEmp\"]")));
		sel3.selectByVisibleText("Russel Hamilton");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAssignEmployee")).click();
		Select sel4=new Select(driver.findElement(By.xpath("//*[@id=\"workShift_availableEmp\"]")));
		sel4.selectByVisibleText("John Smith");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		/*driver.findElement(By.id("btnAssignEmployee")).click();
		Select sel5=new Select(driver.findElement(By.xpath("//*[@id=\"workShift_assignedEmp\"]")));
		sel5.selectByVisibleText("John Smith");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"btnRemoveEmployee\"]")).click();*/
        //driver.close();
		List<WebElement> e1= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e1.get(3).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"btnDelete\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"dialogDeleteBtn\"]")).click();
	}
	@Test(priority=7) 
	public void Orginformation() throws InterruptedException
	{
	
	Actions a=new Actions(driver);
	WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
	WebElement org=driver.findElement(By.id("menu_admin_Organization"));
	WebElement ginfome=driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation"));
	a.moveToElement(admin).pause(3000).moveToElement(org).pause(3000).moveToElement(ginfome).click().build().perform();
	driver.findElement(By.xpath("//*[@id=\"btnSaveGenInfo\"]")).click();
	Actions a1=new Actions(driver);
	WebElement e=driver.findElement(By.xpath("//*[@id=\"organization_name\"]"));
	e.click();
	a1.keyDown(Keys.CONTROL).sendKeys("a1").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
	//driver.findElement(By.xpath("//*[@id=\"workShift_name\"]")).sendKeys("second shift1");
	driver.findElement(By.xpath("//*[@id=\"organization_name\"]")).sendKeys("bhaskar");
	driver.findElement(By.xpath("//*[@id=\"btnSaveGenInfo\"]")).click();

	
	}
	@Test(priority=8) 
	public void OrgLocations() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement org=driver.findElement(By.id("menu_admin_Organization"));
		WebElement location=driver.findElement(By.id("menu_admin_viewLocations"));
		a.moveToElement(admin).pause(3000).moveToElement(org).pause(3000).moveToElement(location).click().build().perform();
		driver.findElement(By.xpath("//*[@id=\"searchLocation_name\"]")).sendKeys("Texas R&D");
        Select sel=new Select(driver.findElement(By.xpath("//*[@id=\"searchLocation_country\"]")));
        sel.selectByVisibleText("United States");
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("btnReset")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("location_name")).click();
        driver.findElement(By.xpath("//*[@id=\"location_name\"]")).sendKeys("bhaskar3");
        Select sel1=new Select(driver.findElement(By.xpath("//*[@id=\"location_country\"]")));
        sel1.selectByVisibleText("India");
        driver.findElement(By.xpath("//*[@id=\"location_province\"]")).sendKeys("ap",Keys.TAB,"anantapur",Keys.TAB,"gooty",Keys.TAB,"515402",Keys.TAB,"0123456789",Keys.TAB,"040235689",Keys.TAB,"nochange",Keys.TAB,Keys.ENTER);
        List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(1).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.xpath("//*[@id=\"dialogDeleteBtn\"]")).click();
        
	}
	@Test(priority=9) 
	public void OrgStructure() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement org=driver.findElement(By.id("menu_admin_Organization"));
		WebElement structure=driver.findElement(By.id("menu_admin_viewCompanyStructure"));
		a.moveToElement(admin).pause(3000).moveToElement(org).pause(3000).moveToElement(structure).click().build().perform();
		driver.findElement(By.id("btnEdit")).click();
		driver.findElement(By.id("treeLink_addChild_1")).click();
		driver.findElement(By.id("txtUnit_Id")).sendKeys("Team4",Keys.TAB,"kishor4",Keys.TAB,"Good Employee for manager");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"treeLink_delete_8\"]")).click();
		driver.findElement(By.id("dialogYes")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnEdit")).click();
	}
	@Test(priority=16) 
	public void ConfigurationEmailConfig() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement config=driver.findElement(By.id("menu_admin_Configuration"));
		WebElement email=driver.findElement(By.id("menu_admin_listMailConfiguration"));
		a.moveToElement(admin).pause(3000).moveToElement(config).pause(3000).moveToElement(email).click().build().perform();
		driver.findElement(By.id("editBtn")).click();
		driver.findElement(By.id("emailConfigurationForm_txtMailAddress")).sendKeys("kishor@gmail.com");
		Select s=new Select(driver.findElement(By.id("emailConfigurationForm_cmbMailSendingMethod")));
		s.selectByVisibleText("SMTP");
		driver.findElement(By.id("emailConfigurationForm_txtSmtpHost")).sendKeys("google",Keys.TAB,"12345",Keys.ENTER);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='radio']"));
		e.get(1).click();
		driver.findElement(By.id("emailConfigurationForm_txtSmtpUser")).sendKeys("kishor",Keys.TAB,"kishor124",Keys.ENTER);
		List<WebElement> e1= driver.findElements(By.xpath("//input[@type='radio']"));
		e1.get(4).click();
		List<WebElement> e2= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e2.get(0).click();
		driver.findElement(By.id("emailConfigurationForm_txtTestEmail")).sendKeys("admin@example.com",Keys.TAB,Keys.ENTER);

	}
	@Test(priority=17) 
	public void ConfigurationEmailSub() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement config=driver.findElement(By.id("menu_admin_Configuration"));
		WebElement emailsub=driver.findElement(By.id("menu_admin_viewEmailNotification"));
		a.moveToElement(admin).pause(3000).moveToElement(config).pause(3000).moveToElement(emailsub).click().build().perform();
		driver.findElement(By.id("btnEdit")).click();
		List<WebElement> e2= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e2.get(2).click();
		driver.findElement(By.id("btnSave")).click();

	}
	@Test(priority=18) 
	public void ConfigurationLocalization() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement config=driver.findElement(By.id("menu_admin_Configuration"));
		WebElement local=driver.findElement(By.id("menu_admin_localization"));
		a.moveToElement(admin).pause(3000).moveToElement(config).pause(3000).moveToElement(local).click().build().perform();
		driver.findElement(By.id("btnSave")).click();
		Select s=new Select (driver.findElement(By.id("localization_dafault_language")));
		s.selectByValue("es_ES");
		List<WebElement> e= driver.findElements(By.xpath("//*[@id=\"localization_use_browser_language\"]"));
		e.get(0).click();
		Select s1=new Select (driver.findElement(By.id("localization_default_date_format")));
		s1.selectByValue("d-m-Y");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(4000);
	}
	@Test(priority=19) 
	public void ConfigurationModules() throws InterruptedException
	{
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement config=driver.findElement(By.id("menu_admin_Configuration"));
		WebElement modules=driver.findElement(By.id("menu_admin_viewModules"));
		a.moveToElement(admin).pause(3000).moveToElement(config).pause(3000).moveToElement(modules).click().build().perform();
		driver.findElement(By.id("btnSave")).click();
		List<WebElement> e1= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e1.get(3).click();
		driver.findElement(By.id("btnSave")).click();
	}
	@Test(priority=21) 
	public void ConfigurationRegisterOAuthClient() throws InterruptedException
	{
		
		
	Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement config=driver.findElement(By.id("menu_admin_Configuration"));
		WebElement roac=driver.findElement(By.id("menu_admin_registerOAuthClient"));
		a.moveToElement(admin).pause(3000).moveToElement(config).pause(3000).moveToElement(roac).click().build().perform();
		driver.findElement(By.id("oauth_client_id")).sendKeys("krishna kishor",Keys.TAB,"Nothing is secret",Keys.TAB,"https://opensource-demo.orangehrmlive.com",Keys.ENTER);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
		List<WebElement> e1= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e1.get(1).click();
		driver.findElement(By.id("btnDelete")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("dialogDeleteBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("[ https://orangehrm.github.io/orangehrm-api-doc ]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("[ https://github.com/orangehrm/api-sample-app-php ]")).click();
		driver.quit();
		
	}
	@Test(priority=20) 
	public void ConfigurationSocialMediaAuthentication() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement config=driver.findElement(By.id("menu_admin_Configuration"));
		WebElement sma=driver.findElement(By.id("menu_admin_openIdProvider"));
		a.moveToElement(admin).pause(3000).moveToElement(config).pause(3000).moveToElement(sma).click().build().perform();
		driver.findElement(By.id("btnAdd")).click();
		Select s =new Select(driver.findElement(By.id("openIdProvider_type")));
		s.selectByValue("2");
		driver.findElement(By.id("openIdProvider_name")).sendKeys("krishna kishor",Keys.TAB,"https://opensource-demo.orangehrmlive.com/",Keys.TAB,"kkb786",Keys.TAB,"Nothing is secret to the client",Keys.TAB,"dvp00145",Keys.TAB,Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> e1= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e1.get(1).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnDelete")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("dialogDeleteBtn")).click();

		
	}
	@Test(priority=15) 
	public void Nationalities() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement nat=driver.findElement(By.id("menu_admin_nationality"));
		a.moveToElement(admin).pause(3000).moveToElement(nat).pause(3000).click().build().perform();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("nationality_name")).sendKeys("kishor1",Keys.TAB,Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(1).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();

	}
	@Test(priority=11) 
	public void QualificationsEducation() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement qua=driver.findElement(By.id("menu_admin_Qualifications"));
		WebElement edu=driver.findElement(By.id("menu_admin_viewEducation"));
		a.moveToElement(admin).pause(3000).moveToElement(qua).pause(3000).moveToElement(edu).click().build().perform();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("education_name")).sendKeys("MCA",Keys.TAB,Keys.ENTER);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(1).click();
		driver.findElement(By.id("btnDel")).click();
	}
	@Test(priority=13) 
	public void QualificationsLanguages() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement qua=driver.findElement(By.id("menu_admin_Qualifications"));
		WebElement lang=driver.findElement(By.id("menu_admin_viewLanguages"));
		a.moveToElement(admin).pause(3000).moveToElement(qua).pause(3000).moveToElement(lang).click().build().perform();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("language_name")).sendKeys("Telugu",Keys.TAB,Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(1).click();
		driver.findElement(By.id("btnDel")).click();

	}
	@Test(priority=12) 
	public void QualificationsLicenses() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement qua=driver.findElement(By.id("menu_admin_Qualifications"));
		WebElement lice=driver.findElement(By.id("menu_admin_viewLicenses"));
		a.moveToElement(admin).pause(3000).moveToElement(qua).pause(3000).moveToElement(lice).click().build().perform();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("license_name")).sendKeys("permanent license",Keys.TAB,Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(1).click();
		driver.findElement(By.id("btnDel")).click();

	}
	@Test(priority=14) 
	public void QualificationsMembership() throws InterruptedException
	{

		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement qua=driver.findElement(By.id("menu_admin_Qualifications"));
		WebElement memb=driver.findElement(By.id("menu_admin_membership"));
		a.moveToElement(admin).pause(3000).moveToElement(qua).pause(3000).moveToElement(memb).click().build().perform();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("membership_name")).sendKeys("gold1 card",Keys.TAB,Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(1).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();

	}
	@Test(priority=11) 
	public void Qualificationsskills() throws InterruptedException
	{

		
		Actions a=new Actions(driver);
		WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement qua=driver.findElement(By.id("menu_admin_Qualifications"));
		WebElement skills=driver.findElement(By.id("menu_admin_viewSkills"));
		a.moveToElement(admin).pause(3000).moveToElement(qua).pause(3000).moveToElement(skills).click().build().perform();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("skill_name")).sendKeys("kishor1",Keys.TAB,"His qualification is MCA",Keys.TAB,Keys.ENTER);
		List<WebElement> e= driver.findElements(By.xpath("//input[@type='checkbox']"));
		e.get(1).click();
		driver.findElement(By.id("btnDel")).click();

	}
	
}
