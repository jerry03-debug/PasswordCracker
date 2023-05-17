public class App{
    public static void main(String args[]){
        String methodeDeCrackage = "bruteforce";
        Crackage cracker = CrackageFactory.createPasswordCracker(methodeDeCrackage);

        cracker.hasherMotDePasse("password123");
        cracker.crackerMotDePasse("hashedPassword");
        
    }
}