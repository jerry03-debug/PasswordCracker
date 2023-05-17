
// Factory pour l'instanciation des classes en fonction du choix de l'utilisateur

public class CrackageFactory {

    public static Crackage createPasswordCracker(String methode) {
        if (methode.equalsIgnoreCase("bruteforce")) {
            return new CrackageBruteForce();
        } else if (methode.equalsIgnoreCase("dictionary")) {
            return new CrackageDictionnaire();
        } else {
            System.out.println("La méthode de crackage"+methode+"est invalide");
        }
        return null;
    }
}
