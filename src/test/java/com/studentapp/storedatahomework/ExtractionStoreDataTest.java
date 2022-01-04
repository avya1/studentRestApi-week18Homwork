package com.studentapp.storedatahomework;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class ExtractionStoreDataTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3030;
        response=given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
    }
    //2. Extract the total
    @Test
    public void test002(){
        int total=response.extract().path("total");
        System.out.println("The value of total is "+total);
    }
    //3. Extract the name of 5th store
    @Test
    public void test003(){
        String name=response.extract().path("data[4].name");
        System.out.println("The name of 5th store is "+name);
    }
    //Extract the names of all the store
    @Test
    public void test004() {

        List<String> name = response.extract().path("data.name");
        System.out.println("List of stores name are : " + name);

    }
    //5. Extract the storeId of all the store
    @Test
    public void test005(){
        List<Integer> storeId = response.extract().path("data.id");
        System.out.println("List of stores Id are : " + storeId);

    }
    //6. Print the size of the data list
    @Test
    public void test006(){
        int size=response.extract().path("data.size");
        System.out.println("List of stores Id are : " + size);

    }
    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007(){
        List<HashMap<String,?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("List of stores Id are : " + values);
    }
    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008(){
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Rochester'}");
        System.out.println("Address of the store name: " + address);
            }
     //9. Get all the services of 8th store
    @Test
    public void test009(){
        List<HashMap<String, ?>> services = response.extract().path("data[7].services");
        System.out.println("Services of 8 store: " + services);

    }
    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010(){

        List<HashMap<String,?>> storeService=response.extract().path("data.findAll{it.services.name=='Windows Store'}.storeservices");

        System.out.println("StoreServices Are"+storeService);
    }
    //11. Get all the storeId of all the store
    @Test
    public void test011(){
        List<Integer> storeId=response.extract().path("data.services.storeservices.storeId");
        System.out.println("All StoreId is "+storeId);
    }
    //12. Get id of all the store
    @Test
    public void test012(){
        List<Integer> id=response.extract().path("data.id");
        System.out.println("All the stores Id "+id);
    }
    //13. Find the store names Where state = ND
    @Test
    public void test013(){
    List<String> storeName=response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("All the store name where state is ND "+storeName);
    }
    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014(){
        List<HashMap<String,Object>> services =response.extract().path("data.findAll{it.name=='Rochester'}.services");
        int total=services.size();
        System.out.println("Total store services are: " + total);
    }
    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015(){

        List<String> createdAt=response.extract().path("data.services.findAll{it.name=='Windows Store'}.createdAt");
        System.out.println("CreatedAt for all services whose name is window store"+createdAt);
    }
    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016()
    {
        List<String> services = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("Total store services are: " + services);

    }
    //17. Find the zip of all the store
    @Test
    public void test017(){
        List<Integer>zip=response.extract().path("data.zip");
        System.out.println("Zip of all store"+zip);
    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test018(){
        List<Integer> zip=response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("Zip of store name roseville is "+zip);
    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019(){
        List<HashMap<String, ?>> storeServices = response.extract().path("data.findAll{it.services.name=='Magnolia Home Theater'}.id");
         System.out.println("Total store services are: " + storeServices);

    }

    //20. Find the lat of all the stores
    @Test
    public void test020(){
        List<Integer> lat=response.extract().path("data.lat");
        System.out.println("lat of all store is  "+lat);
    }



}
