package ru.job4j.Tracker;

/**
 * Created by Katy on 27.02.2017.
 */
public class StartUI {
    private Input input;
    String operation;

    public StartUI(Input input) {
        this.input = input;
    }



    public void init() {

        Tracker tracker = new Tracker();
        String operation;
        System.out.println("*********************");
        System.out.println("*  Пограмма заявок  *");
        System.out.println("*********************");

        do {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("1-Add new task, 2-Edit task, 3-Add comment for task, \n " +
                    "4-Snow all task, 5-Search task by Key-Word, 6-Find task by ID  ,\n " +
                    " 7- Delete task, 8-Exit");

            System.out.println("----------------------------------------------------------------------------------");

            operation = input.operation("Select operation :");

            switch (operation) {
                case "1":
                    String name = input.askName("Please enter the tasks name: ");
                    String description = input.askDesc("Please enter the tasks description: ");
                    tracker.add(new Item(name, description));
                    break;
                case "2":
                    Item item3 = new Item();
                    String id = input.askId("Please enter the tasks ID:");
                    name = input.askName("Please enter the tasks name: ");
                    description = input.askDesc("Please enter the tasks description: ");
                    tracker.editItem(tracker.findById(id) ,new Item(name,description));
                    break;
                case "3":
                    id = input.askId("Please enter the tasks ID:");
                    String comment = input.askComment("Please enter comment for the tasks : ");
                    tracker.addComment(comment, id);
                    break;
                case "4":
                    for (Item item : tracker.getAll()) {
                        if (item!=null)
                        System.out.print(item.getId() + "\t" + item.getName() + "\t" + item.getDescription() + "\t" + item.getComment());
                        System.out.println();
                    }
                    break;
                case "5":
                    String word = input.askWord("Please enter word for search : ");
                    Item item = tracker.findByComment(word);
                    System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getDescription() + "\t" + item.getComment());

                    break;
                case "6":
                    id = input.askId("Please enter the tasks ID:");
                    item = tracker.findById(id);
                    System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getDescription() + "\t" + item.getComment());

                    break;
                case "7":
                    id = input.askId("Please enter the tasks ID:");
                    tracker.deleteItem(id);
                    break;
                case "8":
                    operation = "exit";
                    System.out.println("By !!!");

            }
        } while (operation != "exit");
    }

    public static void main(String[] args) {
        Item item = new Item();
           Input input = new StubInput(new String[]{"1","old task","old newdesc","4","8"});
      //  Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}


