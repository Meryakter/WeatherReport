import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static java.lang.System.getProperty;


public class WeatherForecast {
    public static void main(String[] args) {
        /*
        url=https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
        *Domain=https://api.openweathermap.org/data/2.5
        * Resource=/weather
        * Query param1=lat=30.2711286//key=value
        * Query param2=lon=-97.7436995
        * Query param3=appid=f96718b5f115dbfd313dd53465d86a56

*/

        RestAssured.baseURI="https://api.openweathermap.org/data/2.5";
String apiKey="f96718b5f115dbfd313dd53465d86a56";
String resource="/forecast";
Double longitude=-97.7436995;
Double latitude =30.2711286;
        String unitType="metric";

        Response response = given()
                .queryParam("lon", longitude)
                .queryParam("lat", latitude)
                .queryParam("appid",apiKey)
                .queryParam("units", unitType)
                .get(resource);


        System.out.println(response.prettyPrint());

        String filePath = System.getProperty("user.dir") + "/output/hourly-forecast.txt";

        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(response.asString());
            fw.flush();

        }
       // catch (IOException ie){
         //   System.out.println(Arrays.toString(Arrays.toString(ie.getStackTrace()).toCharArray()));
        catch (IOException ie){
            System.out.println(ie.getStackTrace());
        }





    }

}
