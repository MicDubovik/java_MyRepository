package ru.job4j.proposal;

import java.util.Scanner;

/**
 * Класс для обработки массива заявок.
 *
 */
public class OperationWithProposal {
    Proposal[] proposals;

    Scanner scan = new Scanner(System.in);

    public OperationWithProposal() {

    }

    /**
     * Показ всего массива заявок
     */
    public void showAllProposal() {
        int count = 0;
        for (int i = 0; i < proposals.length; i++) {
            if (proposals[i].getId() != "Пустое поле") {
                proposals[i].show();
                count++;
            }
            if (count < 1 && i == proposals.length - 1) System.out.println("Нет заявок");
        }

    }

    /**
     * Редактирование заявки по номеру из массива заявок
     */

    public void editProposal() {
        int number = 0;

        for (int i = 0; i < proposals.length; i++) {
            System.out.println("Введите ID заявки для редактирования:");
            scan = new Scanner(System.in);
            if (scan.hasNextInt())
                number = scan.nextInt();
            if (proposals[number - 1].getId() != "Пустое поле") {
                proposals[number - 1].editDescription();
                break;
            } else {
                System.out.println("Нет такого ID !!!");
            }

        }
    }

    /**
     * Редактирование существующей заявки
     */
    public void editComment() {
        int number = 0;
        System.out.println("Введите ID заявки для добавления комментария:");
        scan = new Scanner(System.in);
        for (int i = 0; i < proposals.length; i++) {
            if (scan.hasNextInt() && proposals[i].getId() != "Пустое поле") {
                number = scan.nextInt();
                proposals[number].editComment();
            } else {
                System.out.println("Нет такого ID !!!");
            }

        }

    }

    /**
     * Удаление существующей заявки
     */
    public void deleteProposal() {
        int number = 0;
        System.out.println("Введите ID заявки для удаления её из базы:");
        scan = new Scanner(System.in);
        if (scan.hasNextInt()) number = scan.nextInt();
        if (proposals[number - 1].getId() != "Пустое поле") {
            proposals[number - 1].setDescription("Пустое поле");
            proposals[number - 1].setComment("Пустое поле");
            proposals[number - 1].setId("Пустое поле");
            proposals[number - 1].setDate("Пустое поле");

        } else {
            System.out.println("Нет такого ID !!!");
        }
    }

    /**
     * Поиск заявки по указанной строке
     */

    public void searchByWords() {
        System.out.println("Введите слово для поиска по базе заявок:");
        scan = new Scanner(System.in);
        String word = "empty";
        if (scan.hasNext())
            word = scan.next();
        for (int i = 0; i < proposals.length; i++) {
            if (proposals[i].getDescription().contains(word) || proposals[i].getComment().contains(word)) {
                proposals[i].show();
                break;

            } else {
                System.out.println("Нет такого слова в базе заявок !");
            }
        }
    }

    /**
     * Создание пустого листа заявок числом 100
     *
     * @return
     */

    public Proposal[] createListProposal() {
        Proposal[] proposals = new Proposal[100];
        for (int i = 0; i < proposals.length; i++) {
            proposals[i] = new Proposal();
        }

        return proposals;
    }

    /**
     * Добавление заявки в массив заявок
     */

    public void addProposal() {
        int count = 0;
        for (int i = 0; i < proposals.length; i++) {
            if (proposals[i].getId() == "Пустое поле" && count < 1) {
                count++;
                proposals[i].initializeProposal();
            }

        }

    }

}



