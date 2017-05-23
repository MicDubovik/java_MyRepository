package ru.job4j.proposal;

import java.util.Date;
import java.util.Scanner;

/**
 * Класс заявок
 */
public class Proposal {
    /**
     * id
     */
    private String id = "Пустое поле";
    /**
     * Desc.
     */
    private String description = "Пустое поле";
    /**
     * Date.
     */
    private String date = "Пустое поле";
    /**
     * Comment.
     */
    private String comment = "Пустое поле";
    /**
     * Input param.
     */
    Scanner scan = new Scanner(System.in);

    /**
     * Constructor.
     */
    public Proposal() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date=date;
    }

    /**
     * Метод присвоения текущей даты заявке
     */

    public void editDate(){

        this.date = new Date().toString();
    }

    /**
     * Присвоение номера заявке
     */

    public void editId() {
        System.out.println("Введите ID вашей заявки :");
        scan = new Scanner(System.in);
        if (scan.hasNextLine())
            this.id = scan.nextLine();
    }

    /**
     * Присвоение описания заявке
     */

    public void editDescription() {
        System.out.println("Введите описание вашей заявки :");
        scan = new Scanner(System.in);
        if (scan.hasNextLine())
            this.description = scan.nextLine();
    }

    /**
     * Присвоение комментария заявке
     */
    public void editComment() {
        System.out.println("Добавьте комментарий к вашей заявке");
        scan = new Scanner(System.in);
        if (scan.hasNextLine())
            this.comment = scan.nextLine();
    }

    /**
     * инициализация заявки .
     */
    public void initializeProposal() {
        editDescription();
        editComment();
        editId();
        editDate();
    }

    /**
     * Показ полей заявки
     */
    public void show() {
        System.out.println(this.id + ". Date " + this.date + " description :" + description + "  comment: " + comment);
    }


}
