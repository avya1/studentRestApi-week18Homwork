package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class StudentPutTest extends TestBase {
@Test
        public void updateStudentWithPut() {
    StudentPojo studentPojo = new StudentPojo();
    studentPojo.setFirstName("Samiksha");
    studentPojo.setLastName("Rathod");
    studentPojo.setEmail("sami12345@gmail.com");
    studentPojo.setProgramme("Manual Testing");
    Response response=given().header("Content-Type","application/json")
            .pathParam("id",101)
            .body(studentPojo)
            .when()
            .put("/{id}");
    response.then().statusCode(200);
    response.prettyPrint();
}

}
