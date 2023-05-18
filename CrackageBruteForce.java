public class CrackageBruteForce extends Crackage {
    
    public String crackerSimplePassword(String password) {
        // Implémentation de la méthode de cassage de mot de passe par BruteForce
        System.out.println("Cracking password using bruteforce...");

        String returnedPassword;
        char[] passwordToGenerate = new char[password.length()];
        returnedPassword = forceBrute(password, passwordToGenerate, 0, password.length(), true);
        return returnedPassword;

    }

    
    public String crackerHashedPassword(String password, int initalLength) {
        // Implémentation de la méthode de hachage de mot de passe avec BruteForce
        System.out.println("Hashing password using bruteforce algorithm...");
        
        String returnedPassword;

        char[] passwordToGenerate = new char[initalLength];
        returnedPassword = forceBrute(password, passwordToGenerate, 0, initalLength, false);
        return returnedPassword;
    }

    
    public String forceBrute(String passWorld, char[] chaine, int position, int longueur, boolean isSimple){
        
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
            for (int i = 97; i < 97+26; i++) {
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