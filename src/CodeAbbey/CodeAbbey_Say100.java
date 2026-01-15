package CodeAbbey;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CodeAbbey_Say100 {
    public static void main(String[] args) throws IOException, InterruptedException {

//        https://www.codeabbey.com/index/task_view/say-100

        // creo un client e salvo le info come token e url a cui fare la richiesta
        HttpClient httpClient = HttpClient.newHttpClient();
        String token = "SPVO5xO4L0zCXpSBHuaJ5jc0";
        String url = "http://2.59.218.221/say-100.php";

        // mando la prima richiesta, utilizzando il token che mi è stato dato
        var richiesta1 = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("token=" + token))
                .build();

        // salvo la risposta, il server mi passa questo nel body "secret: [NUMERO]", dove num è un numero da 1 a 99
        var risposta1 = httpClient.send(richiesta1, HttpResponse.BodyHandlers.ofString());
        var body1 = risposta1.body();
        System.out.println("----------Body 1----------\n" + body1);
        String numero = body1.replaceAll("[A-Za-z :]", "").trim(); // estraggo il numero

        System.out.println("numero estratto: [" + numero + "]");
        String differenza = String.valueOf(100 - Integer.parseInt(numero));
        System.out.println("Diff: " + differenza);

        // invio una seconda richiesta, contenente il token iniziale, e la risposta
        var richiesta2 = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("token=" + token + "&answer=" + differenza))
                .build();

        // se abbiamo fatto bene, il server restituirà "end: [token di vittoria]"
        var risposta2 = httpClient.send(richiesta2, HttpResponse.BodyHandlers.ofString());
        var body2 = risposta2.body();
        System.out.println("\n----------Body 2----------\n" + body2);
        System.out.println("token di vittoria estratto: " + body2.substring(4).trim());
    }
}
