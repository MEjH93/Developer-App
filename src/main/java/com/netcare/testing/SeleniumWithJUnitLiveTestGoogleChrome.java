package com.netcare.testing;

import lombok.Getter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.*;

@Getter
public class SeleniumWithJUnitLiveTestGoogleChrome {

    private static SeleniumExampleGoogleChrome seleniumExampleGoogleChrome;
    private String expectedTitle = "netcare | Perfectly Customized IT Solutions";


    @BeforeClass
    public static void setUp() {
        seleniumExampleGoogleChrome = new SeleniumExampleGoogleChrome();
    }

    @Test
    public void testMethod() {
        String actualTitle = seleniumExampleGoogleChrome.getTitle();
        assertNotNull(actualTitle);
        assertEquals(expectedTitle, actualTitle);
        assertTrue(seleniumExampleGoogleChrome.isAuthorInformationAvailable());
    }

    @AfterClass
    public static void tearDown() {
        seleniumExampleGoogleChrome.closeWindow();
    }

}
