import java.util.Scanner;

public class Menu {
    public Menu(){
        bienvenue();
    }


    public void demarrer(Scanner in){
        // on gère les entrée du gars

        // Scanner in = new Scanner(System.in);
        int choice=0;

        // on récupère son choix
        choice = in.nextInt();
        in.nextLine();

        System.out.print("Veuillez saisir votre mot de passe : ");
        String password = in.nextLine();

        switch (choice) {
            case 1:
                // il faut appeler le module hashModule
                HashModule hashModule = new HashModule(password);
                hashModule.hasher(in);
                break;
            
            case 2:
                // il faut appeler le module crackerSimpleModule
                CrackerSimpleModule crackerSimpleModule = new CrackerSimpleModule(password);
                crackerSimpleModule.attaque(in);
                break;
            
                case 3:
                // il faut appeler le module crackerHashedModule
                CrackerHashedModule crackerHashedModule = new CrackerHashedModule(password);
                crackerHashedModule.attaque(in);
                break;   

        
            default:
                System.out.println("Mais mec ! A un moment donné, il faut être sérieux quoi\nJ'ai écris blan sur noir 1, 2 ou 3 et tu ose écrire "+choice);
                break;
        }

        // in.close();


    }


    public void bienvenue(){
        System.out.println("Bienvenu dans notre programme de hashage et de crackage de mot de passe !");
        System.out.println("1 -----> Pour hasher un mot de passe ");
        System.out.println("2 -----> Pour casser un mot de passe simple");
        System.out.println("3 -----> Pour casser un mot de passe hashe");
        System.out.print("Saisir votre choix : ");
    }
}
