/**
 * Created by Katy on 18.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();

//        runner.inputList();

         do{
            runner.showmenu();
            runner.Reading();
        }while (runner.Reading());

    }
}
