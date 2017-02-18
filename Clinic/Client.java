import java.util.Scanner;

/**
 * Created by Katy on 18.02.2017.
 */
public class Client {
    private String lname_client;
    private Pet pet;
    Scanner reader = new Scanner(System.in);

    public Client(){

    }

    public Client(String lname_client, Pet pet) {
        this.lname_client = lname_client;
        this.pet = pet;
    }



    public Pet addPet() {

        System.out.println("Input dog,cat...");
        String animal= reader.next();
        System.out.println("Input name:");
        String name = reader.next();
        if(animal.equals("dog")){
        Pet pet = new Dog(name) ;}
        else if (animal.equals("cat")){
            Pet pet = new Cat(name);
        }

      return pet;
    }

    public String getLname_client() {
        return lname_client;
    }


    public void setLname_client(String lname_client) {
        this.lname_client = lname_client;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void removePet() {
        this.pet = null;
    }

    public void show() {
        System.out.print("Client lname:" + lname_client + "\t Pet name:" + pet.getName());
    }
}
