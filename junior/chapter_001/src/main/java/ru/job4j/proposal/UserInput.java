package ru.job4j.proposal;

import java.util.Scanner;

/**
 * Created by Katy on 25.02.2017.
 */
public class UserInput {
    public static void main(String[] args) {

        OperationWithProposal owp = new OperationWithProposal();
        owp.proposals = owp.createListProposal();

        String operation = "empty";


        System.out.println("*********************");
        System.out.println("*  Пограмма заявок  *");
        System.out.println("*********************");

        do {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("1-Добавление новой заявки,2-Редактирование заявки,3-Добавить комментарий к заявке, \n" +
                    "4-Отображение списка всех заявок,5-Поиск заявки по фильтру,6-Удаление заявки ,\n " +
                    "7- Выход из программы");

            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(" Введите номер для выбора операции...");
            Scanner scan = new Scanner(System.in);
            if (scan.hasNext()) operation = scan.next();
            switch (operation) {
                case "1":
                   owp.addProposal();

                    break;
                case "2":
                    owp.editProposal();
                    break;
                case "3":
                    owp.editComment();
                    break;
                case "4":
                    owp.showAllProposal();
                    break;
                case "5":
                    owp.searchByWords();
                    break;
                case "6":
                    owp.deleteProposal();
                    break;
                case "7":
                    operation = "exit";
                    System.out.println("By !!!");

            }
        } while (operation != "exit");


    }
}
