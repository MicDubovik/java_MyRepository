package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList;

/**
 * Description items column.
 */
public class Item {
    private String id;
    protected String name;
    protected String description;
    protected String comment;


    public Item() {
    }

    public Item(  String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, String comment) {
        this.name = name;
        this.description = description;
        this.comment = comment;
    }

    public Item(String id, String name, String description, String comment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
