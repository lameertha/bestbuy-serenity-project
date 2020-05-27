package uk.bestbuy.crudtest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import uk.bestbuy.steps.ProductsSteps;
import uk.bestbuy.testbase.TestBase;
import uk.bestbuy.utils.TestUtils;

import static org.hamcrest.core.IsEqual.equalTo;

/* Created
 * by Lamee */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCRUDTest extends TestBase {
    static String name = "APPLE New Mobile"+ TestUtils.getRandomValue();
    static String  type = "iOS 5009" +TestUtils.getRandomValue();
    static String  upc = "ABC"+TestUtils.getRandomValue();
    static double  price = 87.99;
    static String  description = "This is a placeholder request for creating a new product.";
    static String  model = "NP12345"+ TestUtils.getRandomValue();


    @Steps
    ProductsSteps productsSteps;

    @Title("This test will create a new products and verify its generated")
    @Test

    public void test001(){
        productsSteps.createNewProduct(name,type,upc,price,description,model);

    }

    @Title("This test will get the product information by ID")
    @Test

    public void test002(){
        productsSteps.getProductById().statusCode(200);

    }

    @Title("This test will update the product information and verify the updated information")
    @Test

    public void test003(){
        name = name+"_Changed";
        price = 89.99;
        upc = upc + "_added";
        productsSteps.updateProduct(name,type,upc,price,description,model).statusCode(200);
        productsSteps.getProductById().body("name",equalTo(name));

    }
    @Title("This test will delete the product information and verify the product is deleted ")
    @Test

    public void test004(){
        productsSteps.deleteProductById().statusCode(200);
        productsSteps.getProductById().statusCode(404);
    }
}
