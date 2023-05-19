import java.util.Scanner;

public class CrackerHashedModule {
    private String password;
    public CrackerHashedModule(String password){
        this.password = password;
    }

    public void attaque(Scanner in){
        String returnedPassword;

        int nbreLettre = 0;

        // Scanner in = new Scanner(System.in);
        String methode = getMethodeCrackaque(in);
        System.out.println("Vous voulez nous defier avec un mot de passe hashe!\nOn peut craquer ton mot de passe hashe de deux façon yaay xool : ");

        System.out.print("j'avoue cela risque d'etre chaud pour ma machine aide-nous en nous disant le nombre de caractere avant le hash : ");
        nbreLettre = in.nextInt();
        in.nextLine();
        System.out.println("C'est partie");


        Cracker cracker = CrackageFactory.createPasswordCracker(methode);
        returnedPassword = cracker.crackerHashedPassword(new StringBuilder(this.password), nbreLettre);
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
    
            methodeDeCraquage = in.nextLine();
            if(!(methodeDeCraquage.equalsIgnoreCase("bruteforce") || methodeDeCraquage.equalsIgnoreCase("dictionary"))){
                System.out.print("Mec yaw tamitt, faut être sérieux!\nJ'ai écris blanc sur noir 'bruteforce' ou 'dictionary'");
            }else 
                bon = true;
        }

        return methodeDeCraquage;
    }


}
