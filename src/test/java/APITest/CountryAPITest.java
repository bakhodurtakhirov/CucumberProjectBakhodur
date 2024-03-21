package APITest;

import APITest.POJO.Country;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class CountryAPITest {
    Cookies cookies;
    
    @BeforeClass //Will run once if we run entire class. With @Beforemethod it will run loginTest() for each method which is not necessary and waist of time.
    void loginTest() {
        
        baseURI = "https://test.mersys.io/school-service/api/countries";
        
        Map<String, Object> credentials = new HashMap<>();//Because values are of different types so need to use superclass Object
        credentials.put("username", "turkeyts");
        credentials.put("password", "TechnoStudy123");
        credentials.put("rememberMe", true);
        
        cookies = given()
                .body(credentials)
                .contentType(ContentType.JSON) //must to write to avoid type error
                .when()
                .post("https://test.mersys.io/auth/login")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response().getDetailedCookies(); // Extract the all tokens as a cookie so we can use it in other tests for authorization
    }
    
    @Test(dependsOnMethods = "createCountry", priority = 2)
    void getListOfCountries() {
        given()
                .body("{}")
                .cookies(cookies) //to send cookies(instead of headers) as per documentation
                .contentType(ContentType.JSON)
                .when()
                .post("/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", hasItem(responseCountry.getName()));
    }
    
    public String randomCountry() {
        return RandomStringUtils.randomAlphabetic(8);
    }
    
    public String randomCountryCode() {
        return RandomStringUtils.randomAlphanumeric(3);
    }
    
    Country responseCountry;
    Country requestCountry;
    
    @Test(priority = 1)
    void createCountry() {
        requestCountry = new Country();
        requestCountry.setId(null);
        requestCountry.setName(randomCountry());
        requestCountry.setCode(randomCountryCode());
        requestCountry.setTranslateName(new ArrayList<>());
        requestCountry.setHasState(false);
        
        responseCountry = given()
                .body(requestCountry)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .log().body()
                .extract().jsonPath().getObject("", Country.class); //entire response body with ""
        
        Assert.assertEquals(requestCountry.getName(), responseCountry.getName());
        Assert.assertEquals(requestCountry.getCode(), responseCountry.getCode());
        
/*        {
            "id": "65f61bb623b090743a489f44",
                "name": "FegNBKxC",
                "shortName": null,
                "translateName": [
        
    ],
            "code": "2SU",
                "hasState": false
        }*/
    }
    
    @Test(dependsOnMethods = "createCountry", priority = 3)
    void createNegativeCountry() {
//        Country country = new Country(); //this is alternative of using requestCountry
//        country.setId(null);
//        country.setName(responseCountry.getName());
//        country.getCode(responseCountry.getCode());
//        country.setTranslateName(responseCountry.getTranslateName());
//        country.setHasState(false);
        
        given()
                .body(requestCountry)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(400);
    }
    
    @Test(dependsOnMethods = "createCountry", priority = 4)
    void getCountryByName() {
        given()
                .body("{\"name\":\"" + responseCountry.getName() + "\"}")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post("/search")
                .then()
                .log().body()
                .statusCode(200);
    }
    
    @Test(dependsOnMethods = "createCountry", priority = 5)
    void updateCountry() {
        responseCountry.setName(randomCountry());
        responseCountry.setCode(randomCountryCode());
        
        given()
                .body(responseCountry)
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .put()
                .then()
                .statusCode(200)
                .body("id", equalTo(responseCountry.getId()));
    }

    @Test(dependsOnMethods = "createCountry", priority = 6)
    void deleteCountry(){
        given()
                .cookies(cookies)
                .pathParams("countryId", responseCountry.getId())
                .when()
                .delete("/{countryId}")
                .then()
                .statusCode(200);
    }
    
    @Test(dependsOnMethods = {"createCountry", "deleteCountry"}, priority = 7)
    void deleteCountryNegative(){
        given()
                .cookies(cookies)
                .pathParams("countryId", responseCountry.getId())
                .when()
                .delete("/{countryId}")
                .then()
                .statusCode(400);
    }
}
