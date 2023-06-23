package CrackerServer;
// Factory pour l'instanciation des classes en fonction du choix de l'utilisateur

public class CrackageFactory {

    public static Cracker createPasswordCracker(int methode) {
        if (methode == 1) {
            return new CrackerBruteForce();
        } else if (methode == 2) {
            return new CrackerDictionnaire();
        } else {
            System.out.println("La methode de crackage"+methode+"est invalide");
        }
        return null;
    }
}
