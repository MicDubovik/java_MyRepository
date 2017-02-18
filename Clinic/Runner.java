import java.util.Scanner;

/**
 * Created by Katy on 18.02.2017.
 */
public class Runner {

    private Clinic clinic;
    private Client[] clients;

    public Runner() {
        this.clinic = new Clinic();
    }

//    public int inputList() {
//        clients[0] = new Client("Ivanov", new Cat("Vasya"));
//        clients[1] = new Client("Petrov", new Dog("Sharik"));
//        clients[2] = new Client("Fedorov", new Cat("Sonya"));
//        clients[3] = new Client("Sidorov", new Dog("Polcan"));
//        return clients.length;
//    }

    Scanner reader = new Scanner(System.in);


    public void showmenu() {
        System.out.println("---------------------------------");
        System.out.println("       Hi it's <Clinic list>     ");
        System.out.println("---------------------------------");
        System.out.println("        <Select operation>       ");
        System.out.println(" 1- for show list clients        ");
        System.out.println(" 2- for add clients              ");
        System.out.println(" 3- for remove clients           ");
        System.out.println(" 4- for find clients by last_name");
        System.out.println(" 5- for find clients by  Pet_name");
        System.out.println(" 6- for exit                     ");
        System.out.println("---------------------------------");

    }

    boolean isReading=true ;
    public boolean Reading() {

        int operation = reader.nextInt();
        if (operation==6){
            isReading=true;
        }
        switch (operation) {
            case 1:
                clinic.show_client();
                break;
            case 2:
                clinic.addClient(new Client());
                break;
            case 3:
                clinic.removeClients();
                break;
            case 4:
                clinic.findByClientName();
                break;
            case 5:
                clinic.findByPetName();
                break;
            case 6:
                break;
            default:
                System.out.println("The operation is not !!!");

        }
        return isReading;
    }


}
