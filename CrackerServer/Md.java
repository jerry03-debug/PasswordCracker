package CrackerServer;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
// import java.net.http.HttpHeaders;
// import java.util.HashMap;
import java.util.Map;
public class Md{
    // public static void main(String[] args) {
    //     // Créer un client HTTP
    //     HttpClient client = HttpClient.newHttpClient();

    //     // Définir l'URL de la route d'authentification
    //     String url = "http://localhost/design_pattern/index.php";

    //     // Créer les paramètres de la requête
    //     // Map<String, String> params = new HashMap<>();
    //     // params.put("username", "diery");
    //     // params.put("password", "passerr");

    //     // Construire le corps de la requête avec les paramètres
    //     // StringBuilder requestBody = new StringBuilder();
    //     // for (Map.Entry<String, String> entry : params.entrySet()) {
    //     //     String key = entry.getKey();
    //     //     String value = entry.getValue();
    //     //     requestBody.append(key).append("=").append(value).append("&");
    //     // }

    //     Map<String, String> requestBody = new HashMap<>();
    //     requestBody.put("username", "diery");
    //     requestBody.put("password", "passer");

    //     // String jsonString = new ObjectMapper().writeValueAsString(requestBody);;
        

    //     // Créer une requête POST avec le corps de la requête
    //     HttpRequest request = HttpRequest.newBuilder()
    //             .uri(URI.create(url))
    //             .header("Content-Type", "application/x-www-form-urlencoded")
    //             .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
    //             .build();

    //     try {
    //         // Envoyer la requête et obtenir la réponse
    //         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


    //         // Récupérer le code de statut de la réponse
    //         int statusCode = response.statusCode();

    //         // Récupérer le corps de la réponse
    //         String responseBody = response.body();

    //         // Traiter la réponse selon les besoins
    //         System.out.println("Code de statut : " + statusCode);
    //         System.out.println("Corps de la réponse : " + responseBody);
    //     } catch (Exception e) {
    //         // Gérer les éventuelles erreurs
    //         e.printStackTrace();
    //     }
    // }

    public static HttpResponse<String> mdHttp(String url, Map<String, String> params) throws Exception{
        HttpClient client = HttpClient.newHttpClient();


        // Construire le corps de la requête avec les paramètres
        StringBuilder requestBody = new StringBuilder();
        for (Map.Entry<String,String> param : params.entrySet()) {
            if (requestBody.length() != 0) requestBody.append('&');
            requestBody.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            requestBody.append('=');
            requestBody.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }


        // Créer une requête POST avec le corps de la requête
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();
        try {
            // Envoyer la requête et obtenir la réponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;

        } catch (Exception e) {
            // Gérer les éventuelles erreurs
           throw new Exception("on dirais qu'il y a eu un problème inattendu", null);
        }


    }

}