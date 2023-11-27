import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetCollectionPointId {
    public Response getCollectionPointId(){
        GetToken token = new GetToken();
        String accessToken = token.getToken();
        String bearerToken = "Bearer " + accessToken;
        System.out.println(bearerToken);
        RestAssured.baseURI = "https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev";
        // String resource = "toll-collection-list";
        String endPoint = "/toll-collection-list?collectionPointId=NY088734";
        Response response =RestAssured.given()
                .header("Authorization", bearerToken)
                .get(endPoint);
        System.out.println(response.prettyPrint());
return response;

    }
    public static void main(String[] args) {

    }
}

