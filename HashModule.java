import java.util.Scanner;

public class HashModule {
    private String password;
    public HashModule(String password){
        this.password = password;
    }

    public void hasher(Scanner in){
        // Scanner in = new Scanner(System.in);
        System.out.println("Excellent choix!");
        

        // saisir l'algo de hashage
        System.out.println("Veuillez saisir l'algo de hashage :");
        String algo = in.nextLine();
        // in.nextLine();
        
        System.out.println("l'algo de hash est : "+algo);
        String hashedPassword = MdService.mdHasheur(algo, password);
        System.out.println("le hash de "+password+" par l'ago " + algo +" est : " + hashedPassword);

        // in.close();
    }
}
