package ru.job4j.Tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты !!!
 */
public class TrackerTest {
    @Test
    public void add() throws Exception {
        Tracker tracker = new Tracker();
       Item item = tracker.add(new Item("first name","first desc","first comment"));
       String result = item.getName();
        assertThat(result,is("first name"));
    }

    @Test
    public void addComment() throws Exception {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first name","first desc"));
        String id = item.getId();
          tracker.addComment( "comment",id);
        assertThat(item.getComment(),is("comment"));
    }

    @Test
    public void editItem() throws Exception {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first name","first desc","comment"));
        String id = item.getId();
     //   tracker.editItem( id,"new desc");
        assertThat(item.getDescription(),is("new desc"));

    }

    @Test
    public void findByComment() throws Exception {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first name","first desc","comment"));

        assertThat(tracker.findByComment( "ment"),is(item));
    }

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

    @Test
    public void findById() throws Exception {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("first name","first desc","comment"));
        Item item2 = tracker.add(new Item("second name","second desc","second comment"));

        String id1 = item1.getId();

        assertThat(  tracker.findById(id1),is(item1));

    }



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