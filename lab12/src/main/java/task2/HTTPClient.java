package task2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Random;
public class HTTPClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws Exception{
        int id = new Random().nextInt(100) + 1;
        getResourceById(id);
        createNewResource();
    }

    public static void getResourceById(int id) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL + "/" + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Resource obtained for ID " + id + ":");
        System.out.println(response.body());
    }

    public static void createNewResource() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        String newPostJson = """
            {
                "title": "foo",
                "body": "bar",
                "userId": 1
            }
        """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL))
                .POST(BodyPublishers.ofString(newPostJson))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println("Object sent:");
        System.out.println(newPostJson);

        System.out.println("Response received:");
        System.out.println(response.body());
    }
}
