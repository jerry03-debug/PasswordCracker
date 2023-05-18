import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CrackageDictionnaire extends Crackage {
    
    public String crackerSimplePassword(String password) {
        // Implémentation de la méthode de cassage de mot de passe par l'algorithme du dictionnaire
        System.out.println("Cracking password using dictionary attack...");


        String returnedPassword;
        returnedPassword = parDictionnaire(password, true);
        return returnedPassword;

        
    }

    
    public String crackerHashedPassword(String password, int initalLength) {
        // Implémentation spécifique de la méthode de hachage de mot de passe par l'algorithme du dictionnaire
        System.out.println("Hashing password using dictionary algorithm...");


        String returnedPassword;
        returnedPassword = parDictionnaire(password, false);
        return returnedPassword;
    }

    public String parDictionnaire(String passWorld, boolean isSimple){
        try {
            File file = new File("../password-bib/french_passwords_top20000.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                if(MdService.mdCompare(passWorld, line, isSimple)){
                    // mot de passe trouvé
                    bufferedReader.close();
                    return line;
                }     
            }

            fileReader.close();    
            return null;
            

            
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ngandiy maami probleme");
        }
        return "";
    }




    
}
