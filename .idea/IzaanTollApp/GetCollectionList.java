package IzaanTollApp;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetCollectionList {
    public Response getCollectionList(){
        GetToken token=new GetToken();
        String accessToken=token.getToken();
        String bearerToken="Bearer "+accessToken;
        RestAssured.baseURI="https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev";
        String endPoint="toll-collection-list";
        System.out.println(bearerToken);

        Response response =RestAssured.given()
                .header("Authorization",bearerToken)
                .get(endPoint);
        System.out.println(response.prettyPrint());

        return response;

    }
    public static void main(String[] args) {





    }
}
