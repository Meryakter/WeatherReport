package IzaanTollApp;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserList {
    public Response getUserList(){
        GetToken token=new GetToken();
        //System.out.println(token.getToken());
        String bearerToken ="Bearer "+token.getToken();
        RestAssured.baseURI="https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev";
        String endPoint="/cognito-user-list";
        System.out.println(bearerToken);
        Response response=RestAssured.given()
                .header("Authorization",bearerToken)
                .get(endPoint);
        // System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
       return  response ;

    }
    public static void main(String[] args) {

    }
}
