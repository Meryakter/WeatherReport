package IzaanTollApp;

import Utility.ReadJSONFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResetPassword {
    public Response resetPassword(){
        GetToken token=new GetToken();
        String accessToken=token.getToken();
        String bearerToken="Bearer "+accessToken;
        System.out.println(bearerToken);
        RestAssured.baseURI="https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev/cognito-admin-set-user-password";
        String jsonFilePath="resetPassword.json";
        String bodyToCreateUser = ReadJSONFile.readJSON(jsonFilePath);
        Response response=RestAssured.given()
                .header("Authorization",bearerToken)
                .body(bodyToCreateUser)
                .post();
        System.out.println(response.prettyPrint());
        return response;
    }

    public static void main(String[] args) {

}}
