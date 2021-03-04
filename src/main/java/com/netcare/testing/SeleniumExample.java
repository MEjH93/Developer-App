package com.netcare.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumExample {

    private SeleniumConfig config;
    private String url = "http://www.netcare.de";

    public SeleniumExample() {
        config = new SeleniumConfig();
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
                .contains("hello@netcare.de");
    }

    public void clickApply() {
        WebElement aboutelement = this.config.getDriver().findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/p[3]/a"));
    }

    public void checkLinkedin() {
        WebElement element = this.config.getDriver().findElement(By.xpath("/html/body/div[1]/footer/nav/div/div/div[1]/ul/li[3]/a"));
        /*By.id(1),By.xpath("footer/nav/div/div/div1.."));
        {id}--->xpath*/
    }

}