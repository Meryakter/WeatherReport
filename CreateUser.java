import Utility.ReadJSONFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUser {
    public Response createUser() {
        GetToken token = new GetToken();
        //System.out.println(token.getToken());
        String accessToken = token.getToken();
        String bearerToken = "Bearer " + accessToken;
       // System.out.println(bearerToken);
        RestAssured.baseURI = "https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev/cognito-create-user";
        String jsonFilePath="createUser.json";
        String bodyToCreateUser = ReadJSONFile.readJSON(jsonFilePath);
        Response response =RestAssured.given()
                // .header("Content-Type", ContentType.JSON)
                .header("Authorization", bearerToken)
                .body(bodyToCreateUser)
                .when()
                .post();
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
        return response;

    }


    public static void main(String[] args) {

    }
}