package IzaanTollApp;

import Utility.ReadJSONFile;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
//non-premitive data types - String,object,Class
import static io.restassured.RestAssured.given;

public class SubmitToll {
    public Response submitToll() {
        GetToken token = new GetToken();
        String accessToken = token.getToken();
        String bearerToken = "Bearer " + accessToken;
        System.out.println(bearerToken);
        RestAssured.baseURI = "https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev/tollcollection";
        String jsonFilePath = "submitToll.json";
        String bodyToSubmitToll = ReadJSONFile.readJSON(jsonFilePath);
        Response response = RestAssured.given()
                .header("Authorization", bearerToken)
                .body(bodyToSubmitToll)
                .when()
                .post();
        System.out.println(response.prettyPrint());
        return response;

        //public static void main(String[] args) {


    }

       // System.out.println(response.prettyPrint());

    }



