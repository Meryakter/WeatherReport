import Utility.ReadJSONFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostLogin {
    public Response postLogin() {
        GetToken token = new GetToken();
        String accessToken = token.getToken();
        String bearerToken = "Bearer " + accessToken;
        System.out.println(bearerToken);
        RestAssured.baseURI = "https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev/cognito-login";
        //String bodyToLogin="{ \r\n   \"username\": \"manager\", \r\n   \"password\": \"Manager@412\"\r\n}";
        String jsonFilePath = "postLogin.json";
        String bodyToLogin = ReadJSONFile.readJSON(jsonFilePath);
        Response response = RestAssured.given()
                .header("Authorization", bearerToken)
                .body(bodyToLogin)
                .post();
        System.out.println(response.prettyPrint());


        return response;
    }}


