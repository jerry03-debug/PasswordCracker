public class App{
    public static void main(String args[]){
        String methodeDeCrackage = "bruteforce";
        Crackage cracker = CrackageFactory.createPasswordCracker(methodeDeCrackage);

        cracker.crackerSimplePassword("password123");
        cracker.crackerHashedPassword("hashedPassword");
        
    }
}