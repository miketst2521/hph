/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hphjunittests;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 *
 * @author lapprestamo
 */
 @RunWith(JUnit4.class)
 public class JunitTests {
   String urlHome = "http://iac.billing-port/";
   private static ChromeDriverService service;
   private WebDriver driver;
   private WebElement element;

   @BeforeClass //Ejecutar justo al instanciar la clase
   public static void createAndStartService() throws IOException {
     service = new ChromeDriverService.Builder()
         .usingDriverExecutable(new File("C:\\Users\\LapPrestamo\\Documents\\chromedriver_win32\\chromedriver.exe"))
         .usingAnyFreePort()
         .build();
     service.start();
   }

   @AfterClass//Ejecutar justo despues de dejar de instanciar la clase
   public static void createAndStopService() {
     service.stop();
   }

   @Before//Ejecutar antes de todos los métodos con anotación @Test
   public void createDriver() {
     driver = new RemoteWebDriver(service.getUrl(),
         DesiredCapabilities.chrome());
   }

   @After//Ejecutar despues de todos los métodos con anotación @Test
   public void quitDriver() {
     driver.quit();
   }
   
   @Test//Metodo que será tomado como parte de las pruebas
   public void testHPHMainPageHeader(){
       driver.get(urlHome);
       element = driver.findElement(By.cssSelector("body > div.wrapper > header > h1 > a > figure > img"));
       assertEquals("http://iac.billing-port/Content/img/lg-hutchison-ports.svg", element.getAttribute("src"));
   }
   
   @Test
   public void hphHomePageRegistryButton(){
       driver.get(urlHome);
       element = driver.findElement(By.cssSelector("#regis"));
       assertEquals("http://iac.billing-port/Usuario/registro", element.getAttribute("href"));
   }
 }