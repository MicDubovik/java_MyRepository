/**
 * Created by Katy on 18.02.2017.
 */
public class Dog implements Pet {
    private String name;

    public Dog(final String name) {
        this.name = name;
    }

    @Override
    public void makesound() {
        System.out.println("Gav-Gav");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
