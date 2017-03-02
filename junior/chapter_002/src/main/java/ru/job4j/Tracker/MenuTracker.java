package ru.job4j.Tracker;

/**
 * Created by Katy on 02.03.2017.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions(){

        this.actions[0]=new AddItem();
    }
    public void select(int key){
this.actions[key].execute(this.input,this.tracker);
    }
    private  class AddItem implements UserAction {

        public int key(){
            return 0;
        }

//        public void show(){
//            for (UserAction action : actions) {
//                System.out.println(action.info());
//            }
//        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.askName("Please enter the tasks name: ");
            String description = input.askDesc("Please enter the tasks description: ");
            tracker.add(new Item( name, description));

        }
        public String info(){
            return String.format("%s, %s",this.key(),"Add the new Item");
        }
    }

}
