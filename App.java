import java.util.Scanner;

public class App{
    public static void main(String args[]){

        int choice=0;
        String algo;
        Scanner in = new Scanner(System.in);
        String password;
        String returnedPassword;

        System.out.println("Bienvenu dans notre programme de hashage et de crackage de mot de passe !");
        System.out.println("1 -----> Pour hasher un mot de passe ");
        System.out.println("2 -----> Pour casser un mot de passe simple");
        System.out.println("3 -----> Pour casser un mot de passe hashe");
        choice = in.nextInt();
        in.nextLine();

        if(choice == 1){
            System.out.println("Excellent choix!");
            System.out.println("Veuillez saisir votre mot de passe :");
            password = in.nextLine();

            System.out.println("Veuillez saisir l'algo de hashage :");
            algo = in.nextLine();
            String hashedPassword = MdService.mdHasheur(algo, password);
            System.out.println("le hash de "+password+" par l'ago " + algo +" est : " + hashedPassword);

        }else{
            if(choice == 2 || choice == 3){
                System.out.println("Vous voulez nous defier!\nOn peut craquer ton mot de passe de deux façon yaay xool : ");
                System.out.println("Veuillez saisir votre mot de passe :");
                password = in.nextLine();
                int nbreLettre = password.length();
                if(choice == 3){
                    System.out.print("Saisir le nombre de caractere de votre mot de passe : ");
                    nbreLettre = in.nextInt();
                    in.nextLine();
                }

                System.out.println("bruteforce -----> Pour la methode brute force");
                System.out.println("dictionary -----> Pour la methode dictionnaire");
                String methodeDeCrackage = in.nextLine();
                
                Crackage cracker = CrackageFactory.createPasswordCracker(methodeDeCrackage);
                
                // verifier ce qui est retourner
                if(cracker == null){
                    System.out.println("");
                }else{
                    if(choice == 2)
                        returnedPassword = cracker.crackerSimplePassword(password);
                    else 
                        returnedPassword = cracker.crackerHashedPassword(password, nbreLettre);

                    if(returnedPassword == null)
                        System.out.println("Felicitation! Nous n'avons pas reussi a cracker ton mot de passe");
                    else 
                        System.out.println("Ton mot de passe est : "+returnedPassword);
                }


            }
    
            



        }




        in.close();
        
    }
}