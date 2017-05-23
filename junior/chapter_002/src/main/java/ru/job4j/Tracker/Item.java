package ru.job4j.Tracker;

/**
 * Класс описывающий заявку.
 */
public class Item {
    /**
     * Id.
     */
    private String id;
    /**
     * Name.
     */
    protected String name;
    /**
     * Desc.
     */
    protected String description;
    /**
     * Comment.
     */
    protected String comment;

    /**
     * Constructor.
     */
    public Item() {
    }

    /**
     * Constructor.
     * @param name
     * @param description
     */
    public Item(  String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor.
     * @param name
     * @param description
     * @param comment
     */
    public Item(String name, String description, String comment) {
        this.name = name;
        this.description = description;
        this.comment = comment;
    }

    /**
     * Constructor.
     * @param id
     * @param name
     * @param description
     * @param comment
     */
    public Item(String id, String name, String description, String comment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comment = comment;
    }

    /**
     * Getter.
     * @return
     */
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    /**
     * Getter.
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Setter.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Getter.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
