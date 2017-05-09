package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList.Database;

/**
 * Values items.
 */
public class ItemDB {
    private int id;
    private String name;
    private String comment;
    private String description;

    /**
     * Constructor.
     * @param id
     * @param name
     * @param comment
     * @param description
     */
    public ItemDB(int id, String name, String comment, String description) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.description = description;
    }

    /**
     * Constructor.
     */
    public ItemDB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
