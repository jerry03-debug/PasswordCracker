public class CrackerBruteForce extends Cracker {
    
    public String crackerSimplePassword(StringBuilder password) {
        // Implémentation de la méthode de cassage de mot de passe par BruteForce
        System.out.println("Cracking password using bruteforce...");

        String returnedPassword;
        char[] passwordToGenerate = new char[password.length()];
        long debut = System.currentTimeMillis();

        returnedPassword = forceBrute(password, passwordToGenerate, 0, password.length(), true);
        long fin = System.currentTimeMillis();
        long tempsEcoule = fin - debut;
        System.out.println("temps ecoule : "+tempsEcoule+"s");

        return returnedPassword;

    }

    
    public String crackerHashedPassword(StringBuilder password, int initalLength) {
        // Implémentation de la méthode de hachage de mot de passe avec BruteForce
        System.out.println("Hashing password using bruteforce algorithm...");
        
        String returnedPassword;

        char[] passwordToGenerate = new char[initalLength];
        returnedPassword = forceBrute(password, passwordToGenerate, 0, initalLength, false);
        return returnedPassword;
    }

    
    public String forceBrute(StringBuilder passWorld, char[] chaine, int position, int longueur, boolean isSimple){
        
        if(position == longueur-1){
            // dernière position il faut faire la comparaison 
            for (int i = 97; i < 97+26; i++) {
                chaine[position] = toChar(i);
                String combinaision = new String(chaine);
                if(MdService.mdCompare(passWorld, combinaision, isSimple)){
                    return combinaision;
                }
            }
            return null;

        }else{
            // ce n'est pas le dernier niveau il faut descendre au dernier niveau
            for (int i = 97; i < 123; i++) {
                chaine[position] = toChar(i);
                if(forceBrute(passWorld, chaine, position +1,longueur, isSimple) != null){
                    // on a une correspondance, il faut encore retourner
                    return new String(chaine);
                }
            }

            return null;
        }


        
    }

    
    public char toChar(int codeAsci){
        char lettre = (char)codeAsci;
        return lettre;
    }


}