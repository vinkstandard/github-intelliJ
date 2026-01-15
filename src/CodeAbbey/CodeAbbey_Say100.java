package CodeAbbey;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CodeAbbey_Say100 {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        String token = "SPVO5xO4L0zCXpSBHuaJ5jc0";
        String url = "http://2.59.218.221/say-100.php";

        var richiesta1 = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("token=" + token))
                .build();

        var response1 = httpClient.send(richiesta1, HttpResponse.BodyHandlers.ofString());
        var body1 = response1.body();
        String numero = body1.replaceAll("[A-Za-z :]", "");

        System.out.println(body1 + "\nnumero [" + numero.trim() + "]");
        String differenza = String.valueOf(100 - Integer.parseInt(numero.trim()));
        System.out.println("Diff: " + differenza);

        var richiesta2 = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("token=" + token + "&answer=" + differenza))
                .build();

        var response2 = httpClient.send(richiesta2, HttpResponse.BodyHandlers.ofString());
        var body2 = response2.body();

        System.out.println(body2.substring(4));
    }
}
