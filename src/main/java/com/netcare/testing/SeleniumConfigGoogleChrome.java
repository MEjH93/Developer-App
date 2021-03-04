package com.netcare.testing;

import lombok.Getter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;


@Getter
public class SeleniumConfigGoogleChrome {

    private WebDriver driver;

    public SeleniumConfigGoogleChrome() {
        Capabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    static {
        System.setProperty("webdriver.chrome.driver", findFile("C:\\Users\\pc\\Desktop\\mejhovski\\chromedriver.exe"));
    }

    static private String findFile(String filename) {
        String paths[] = {"", "bin/", "target/classes"};
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }




}
