import java.util.Scanner;

/**
 * Created by Katy on 18.02.2017.
 */
public class Clinic {


    private Client[] clients = new Client[10];


    public Clinic() {

    }

    public Client[] getClients(int size) {
        return new Client[size];
    }

    Scanner reader = new Scanner(System.in);


    public void addClient(Client client) {
        System.out.println("Input name client:");
        String l_name = reader.next();
        for (int i = 0; i < clients.length; i++) {
            clients[i] = client;
        }
        client.addPet();
    }


    public void removeClients() {
        System.out.println("Input name client for remove:");
        String lname_client = reader.next();
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getLname_client().equals(lname_client)) {
                clients[i] = null;

            }
        }
    }

    public void findByClientName() {
        System.out.println("Input name client for remove:");
        String lname_client = reader.next();

        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getLname_client().equals(lname_client)) {
                clients[i].show();
            }

        }
    }

    public void findByPetName() {
        System.out.println("Input name client for remove:");
        String name_Pet = reader.next();
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getPet().getName().equals(name_Pet)) {
                clients[i].show();
            }
        }
    }

    public void show_client() {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i]!= null) {

                clients[i].show();
                System.out.println();
            } else {
                System.out.println("List empty");
            }

        }

    }


}
