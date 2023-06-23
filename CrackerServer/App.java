package CrackerServer;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int methode = 0;
        String returnedPassword;
        
        bienvenue();
        methode = in.nextInt();

        System.out.println("la methode est "+methode);
        Cracker cracker = CrackageFactory.createPasswordCracker(methode);
        try {
            returnedPassword = cracker.attaque("diery");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.getMessage();
            in.close();
            return;
        }

        if(returnedPassword == null){
            System.out.println("Bravo mec ! Nous n'avons pu cracker ton mot de passe");
        }else{
            System.out.println("Mot de passe cracke. le mot de passe est : "+returnedPassword);
        }


        in.close();
    }

    public static void bienvenue(){
        System.out.println("Bienvenu dans notre programme d'attaque blah blah blah!");
        System.out.println("1 -----> attaque par bruteforce");
        System.out.println("2 -----> attaque par dictionary ");
        System.out.print("Saisir votre choix : ");
    }


    

}
