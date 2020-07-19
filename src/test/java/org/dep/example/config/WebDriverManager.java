package org.dep.example.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {

  private static WebDriver driver;

  public static WebDriver getWebDriver() {
    if (driver == null) {
      resetWebDriver();
    }
    return driver;
  }

  public static void resetWebDriver() {
//    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
//    driver = new ChromeDriver();
    driver = new InternetExplorerDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
}
