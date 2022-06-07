package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

/* Utils class is built to create utilities that can be used across project and that are reusable */

public class Utils {
    public static RequestSpecification req;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // below will set baseURI in requests
    public RequestSpecification requestSpecification() throws IOException {
        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    // reads global.properties file and fetches the value for the given key
    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public List<String> getJsonList(Response response, String key) {
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        return jsonPath.getList(key);
    }

    public String getRequestToken(String token) throws IOException {
        if (token.equalsIgnoreCase("default")) {
            return getGlobalValue("defaultToken");
        } else
            return token;
    }

    // dynamically generates the checkInDate
    public String getCheckInDate(String requestedDate) {
        LocalDateTime now = LocalDateTime.now();
        if (requestedDate.equalsIgnoreCase("default")) {
            return now.format(formatter);
        } else
            return requestedDate;
    }

    // dynamically generates the checkOutDate
    public String getCheckOutDate(String requestedDate) throws ParseException {
        LocalDateTime now = LocalDateTime.now().plusDays(5);
        if (requestedDate.equalsIgnoreCase("default")) {
            return now.format(formatter);
        } else
            return requestedDate;
    }

}
