package CrackerServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class CrackerDictionnaire extends Cracker {
    
    public String attaque(String username) throws Exception {
        // Implémentation de la méthode de cassage de mot de passe par l'algorithme du dictionnaire
        System.out.println("Cracking password using dictionary attack...");


        String returnedPassword;
        long debut = System.currentTimeMillis();

        returnedPassword = parDictionnaire(username);
        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/(1000);

        System.out.println("temps ecoule : "+tempsEcoule+"s");
        return returnedPassword;

        
    }

    
    public String parDictionnaire(String username) throws Exception{
        try {
            File file = new File("../password-bib/french_passwords_top20000.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                // là, il faut faire la requete vers le serveur
                // Créer les paramètres de la requête
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", line);

                String url = "http://localhost/design_pattern/index.php";
                HttpResponse<String> reponse; 
                reponse = Md.mdHttp(url, params);

                // Récupérer le code de statut de la réponse
                int statusCode = reponse.statusCode();
                if(statusCode == 200){
                    String responseBody = reponse.body();

                    // Traiter la réponse selon les besoins
                    System.out.println("Code de statut : " + statusCode);
                    System.out.println("Corps de la réponse : " + responseBody);

                    bufferedReader.close();
                    return line;
                }
                    
            }

            fileReader.close();    
            return null;
            

            
            
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("ngandiy maami probleme");
        }
        return "";
    }




    
}
