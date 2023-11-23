import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class WeatherGet {

    public static void main(String[] args) {

        /*
        https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
        * domain = https://api.openweathermap.org/data/2.5
        * resource = /weather
        * queryParam1 = lat= 39.2128 //key=value
        * queryParam2 = lon= -76.7137
        * queryParam3 = appid= 7504a33640b962d70d85ebb9021531b6
        * */

        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";

        String apiKey = "7504a33640b962d70d85ebb9021531b6";

        String resource = "/weather";

        String longitude = "-76.7137";

        String latitude = "39.2128";

        String unitType = "metric";

        Response response = given()
                .queryParam("lon", longitude)
                .queryParam("lat", latitude)
                .queryParam("appid",apiKey)
                .queryParam("units", unitType)
                .get(resource);

        System.out.println(response.prettyPrint());

        String filePath = System.getProperty("user.dir") + "/output/get-weather.txt";

        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(response.asString());
            fw.flush();
        }
        catch (IOException ie){
            System.out.println(ie.getStackTrace());
        }



    }


}
