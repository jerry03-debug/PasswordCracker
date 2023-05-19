import java.util.Scanner;

public class CrackerSimpleModule {
    private String password;
    public CrackerSimpleModule(String password){
        this.password = password;
    }


    public void attaque(Scanner in){
        
        String returnedPassword;

        // Scanner in = new Scanner(System.in);
        String methode = getMethodeCrackaque(in);
        System.out.println("Vous voulez nous defier!\nOn peut craquer ton mot de passe simple de deux facon yaay xool : ");



        Cracker cracker = CrackageFactory.createPasswordCracker(methode);
        returnedPassword = cracker.crackerSimplePassword(new StringBuilder(this.password));
        if(returnedPassword == null){
            System.out.println("Bravo mec ! Nous n'avons pu cracker ton mot de passe");
        }else{
            System.out.println("mot de passe cracke. le mot de passe est : "+returnedPassword);
        }
        
        
        // in.close();
    }


    public String getMethodeCrackaque(Scanner in){
        boolean bon = false;
        String methodeDeCraquage=null;
        while (!bon) {
            System.out.println("bruteforce -----> Pour la methode brute force");
            System.out.println("dictionary -----> Pour la methode dictionnaire");
            System.out.print("Fais ton choix : ");
            methodeDeCraquage = in.nextLine();
            if(!(methodeDeCraquage.equalsIgnoreCase("bruteforce") || methodeDeCraquage.equalsIgnoreCase("dictionary"))){
                System.out.print("Mec yaw tamitt, faut être sérieux!\nJ'ai écris blanc sur noir 'bruteforce' ou 'dictionary'");
            }else 
                bon = true;
        }

        return methodeDeCraquage;
    }


}
