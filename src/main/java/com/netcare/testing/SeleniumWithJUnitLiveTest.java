package com.netcare.testing;

import lombok.Getter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.*;

@Getter
public class SeleniumWithJUnitLiveTest {

    private static SeleniumExample seleniumExample;
    private static SeleniumExampleGoogleChrome seleniumExampleGoogleChrome;
    private String expectedTitle = "netcare | Perfectly Customized IT Solutionsdfsdf";


    @BeforeClass
    public static void setUp() {
        seleniumExample = new SeleniumExample();
    }

    @Test
    public void testMethod() {
        String actualTitle = seleniumExample.getTitle();
        assertNotNull(actualTitle);
        assertEquals(expectedTitle,seleniumExampleGoogleChrome.getTitle());
        //seleniumExampleGoogleChrome.testMethod1();
        assertEquals(expectedTitle, actualTitle);
        assertTrue(seleniumExample.isAuthorInformationAvailable());
    }

    @AfterClass
    public static void tearDown() {
        seleniumExample.closeWindow();
    }

}