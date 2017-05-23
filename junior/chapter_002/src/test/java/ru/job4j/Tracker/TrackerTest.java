package ru.job4j.Tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты !!!
 */
public class TrackerTest {
    /**
     * add.
     * @throws Exception
     */
    @Test
    public void add() throws Exception {
        Tracker tracker = new Tracker();
       Item item = tracker.add(new Item("first name","first desc","first comment"));
       String result = item.getName();
        assertThat(result,is("first name"));
    }

    /**
     * addComment.
     * @throws Exception
     */
    @Test
    public void addComment() throws Exception {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first name","first desc"));
        String id = item.getId();
        String comment = "new comment";
          tracker.addComment( item,comment);
        assertThat(item.getComment(),is("new comment"));
    }

    /**
     * editItem.
     * @throws Exception
     */
    @Test
    public void editItem() throws Exception {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first name","first desc","comment"));
        Item item2 = tracker.add(new Item("Sec name","second desc","sec comment"));
        String id = item.getId();
        tracker.editItem( item,item2);
        assertThat(tracker.editItem( item,item2).getDescription(),is("second desc"));

    }

    /**
     * findByComment.
     * @throws Exception
     */
    @Test
    public void findByComment() throws Exception {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first name","first desc","comment"));

        assertThat(tracker.findByComment( "ment"),is(item));
    }

    /**
     * deleteItem.
     * @throws Exception
     */
    @Test
    public void deleteItem() throws Exception {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("first name","first desc","comment"));
        Item item2 = tracker.add(new Item("second name","second desc","second comment"));
        int count = tracker.getAll().length ;
        int newLenght =0;

        String id1 = item1.getId();
        String id2 = item2.getId();
        tracker.deleteItem(id1) ;
        int newLenght2=0;
        for (int i = 0; i < count; i++) {
            if (tracker.getAll()[i] != null) {
                newLenght2++;
            }
        }
        assertThat(newLenght2 ,is(1));
    }

    /**
     * findById.
     * @throws Exception
     */
    @Test
    public void findById() throws Exception {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("first name","first desc","comment"));
        Item item2 = tracker.add(new Item("second name","second desc","second comment"));

        String id1 = item1.getId();

        assertThat(  tracker.findById(id1),is(item1));

    }

    /**
     * getAll.
     * @throws Exception
     */
    @Test
    public void getAll() throws Exception {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("first name","first desc","comment"));
        Item item2 = tracker.add(new Item("second name","second desc","second comment"));

        String id1 = item1.getId();
        tracker.getAll();
        assertThat(  tracker.getAll().length,is(2));

    }

}