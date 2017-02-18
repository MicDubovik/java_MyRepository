import java.util.Scanner;

/**
 * Класс для запуска калькулятора
 * поддерживает ввод от пользователя
 */
public class InteractRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try {
            Calculator calc = new Calculator();
            String exit = "no";
            while (!exit.equals("yes")) {
                System.out.println("Enter arithmetic operation");
                String operation = reader.next();
                System.out.println("Enter first arg: ");
                String first = reader.next();
                System.out.println("Second arg: ");
                String second = reader.next();
                if (operation.equals("*")) {
                    calc.mul(Integer.valueOf(first), Integer.valueOf(second));
                } else if (operation.equals("/")) {
                    calc.dev(Integer.valueOf(first), Integer.valueOf(second));
                } else if (operation.equals("-")) {

                    calc.sub(Integer.valueOf(first), Integer.valueOf(second));
                } else if (operation.equals("+")) {

                    calc.add(Integer.valueOf(first), Integer.valueOf(second));
                }
                System.out.println("Result :" + calc.getResult());
                System.out.println("For clean result enter 0,any - continue");
                String clean = reader.next();

                if (clean.equals("0")) {
                    calc.cleanResult();
                }
                System.out.println("Exit yes/no ?");
                exit = reader.next();
            }

        } finally {
            reader.close();
        }
    }
}
