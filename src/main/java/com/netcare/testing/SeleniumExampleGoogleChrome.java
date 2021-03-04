package com.netcare.testing;

import lombok.Setter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static junit.framework.TestCase.*;


@Setter
public class SeleniumExampleGoogleChrome {

    private SeleniumConfigGoogleChrome config;
    private String url = "http://www.netcare.de";

    public SeleniumExampleGoogleChrome() {
        config = new SeleniumConfigGoogleChrome();
        config.getDriver().get(url);
    }


    public void closeWindow() {
        this.config.getDriver().close();
    }

    public String getTitle() {
        return this.config.getDriver().getTitle();
    }

    public void getAboutNetcare() {
        closeOverlay();
        clickAboutLink();
        clickAboutUsLink();
        clickApply();
        checkLinkedin();
    }

    private void closeOverlay() {
        List<WebElement> webElementList = this.config.getDriver()
                .findElements(By.tagName("a"));
        if (webElementList != null) {
            webElementList.stream()
                    .filter(webElement -> "Close".equalsIgnoreCase(webElement.getAttribute("title")))
                    .filter(WebElement::isDisplayed)
                    .findAny()
                    .ifPresent(WebElement::click);
        }

    }

    private void clickAboutLink() {
        Actions actions = new Actions(config.getDriver());
        WebElement aboutElement = this.config.getDriver()
                .findElement(By.id("menu-item-6138"));

        actions.moveToElement(aboutElement).perform();
    }

    private void clickAboutUsLink() {
        WebElement element = this.config.getDriver()
                .findElement(By.partialLinkText("about it."));
        element.click();
    }

    public boolean isAuthorInformationAvailable() {
        return this.config.getDriver()
                .getPageSource()
                .contains("Privacy Policy");
    }

    public void clickApply() {
        WebElement aboutelement = this.config.getDriver().findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/p[3]/a"));
    }

    public void checkLinkedin() {
        WebElement element = this.config.getDriver().findElement(By.xpath("/html/body/div[1]/footer/nav/div/div/div[1]/ul/li[3]/a"));
    }

   /* @Test
    public void testMethod1() {
        String actualTitle = seleniumExample.getTitle();
        assertNotNull(actualTitle);
        assertEquals(expectedTitle,seleniumExampleGoogleChrome.getTitle());
        assertEquals(expectedTitle, actualTitle);
        assertTrue(seleniumExample.isAuthorInformationAvailable());
    }*/

}