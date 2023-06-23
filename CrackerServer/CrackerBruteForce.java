package CrackerServer;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class CrackerBruteForce extends Cracker {
    
    public String attaque(String username) throws Exception {
        // Implémentation de la méthode de cassage de mot de passe par BruteForce
        System.out.println("Cracking password using bruteforce...");

        String returnedPassword = new String();
        long debut = System.currentTimeMillis();

        for (int i = 1; i < 8; i++) {
            
            char[] passwordToGenerate = new char[i];
            returnedPassword = forceBrute(username, passwordToGenerate, 0);
           
            if(returnedPassword != null)
                break;
            
        }

        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/1000;
        System.out.println("temps ecoule : "+tempsEcoule+"s");

        return returnedPassword;

    }

    
   
    public String forceBrute(String username, char[] password, int position) throws Exception{
        int longueur = password.length;
        if(position == longueur-1){
            // dernière position il faut faire la comparaison 
            for (char i = 'a'; i <= 'z'; i++) {
                password[position] = i;
                String generatedPasswordString = new String(password);
                System.out.println(generatedPasswordString);
                // arrivée ici, il faut faire la requete

                // Créer les paramètres de la requête
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", generatedPasswordString);

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
                    return generatedPasswordString;
                }


            }
            return null;

        }else{
            // ce n'est pas le dernier niveau il faut descendre au dernier niveau
            for (char i = 'a'; i <= 'z'; i++) {
                password[position] = i;
                if(forceBrute(username, password, position +1) != null){
                    // on a une correspondance, il faut encore retourner
                    return new String(password);
                }
            }

            return null;
        }


        
    }


}