package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){

        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setEmail("Akshat2@gmail.com");
        Response response= given().header("Content-Type","application/json")
                .pathParam("id",101)
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();



    }
}
