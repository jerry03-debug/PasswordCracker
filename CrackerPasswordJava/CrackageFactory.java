
// Factory pour l'instanciation des classes en fonction du choix de l'utilisateur

public class CrackageFactory {

    public static Cracker createPasswordCracker(String methode) {
        if (methode.equalsIgnoreCase("bruteforce")) {
            return new CrackerBruteForce();
        } else if (methode.equalsIgnoreCase("dictionary")) {
            return new CrackerDictionnaire();
        } else {
            System.out.println("La methode de crackage"+methode+"est invalide");
        }
        return null;
    }
}
