package uk.bestbuy.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import uk.bestbuy.utils.PropertyReader;

/* Created
 * by Lamee */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass

    public static void init(){

        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
    }
}
