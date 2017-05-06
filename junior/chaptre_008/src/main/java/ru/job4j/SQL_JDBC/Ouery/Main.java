package ru.job4j.SQL_JDBC.Ouery;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katy on 06.05.2017.
 */
public class Main {
    /**
     * Таблица ордеров.
     */
    Orders orders;
    /**
     * Таблица прикрепляемых данных.
     */
    Attachments attachments;
    /**
     * Шаблон запроса.
     */
    String pattern;
    /**
     * Текст по которому пользователь ищет в таблице.
     */
    String ask;
    /**
     * Может быть любое поле из таблиц.
     */
    String fields;
    /**
     * Число указываемое пользователем для сравнения .
     */
    int num;
    /**
     * Временная переменная
     */
    int i =0;
    /**
     * Лист дополнительных условий.
     */
    List<String> queryList = new ArrayList<>();

    /**
     * Метод создающий примерный шаблон. Шаблонов может быть много.
     * Для примера зоздан один.
     */
    public void pattern(){

      pattern =  "SELECT * FROM" + orders + "INNER JOIN" + attachments + "ON (" +
                                  orders.attachment_id + "="+ attachments.attach_id +
                                        " ) WHERE"+ attachments.description_attach+" LIKE  '%"+ask+"%'" +
                                                                                  queryList.get(i)+ this.fields;
      ;


    }

    public void fillQueryList(){

        String field1=null;
        /**
         * Делаем оператторы условий.
         */
        String operation1 = "<>";
        String operation2 = ">=";
        String operation3 = "<=";
        String operation4 = "<";
        String operation5 = ">";
        /**
         * Добавляем их в лист
         */
        List<String> operations = new ArrayList<>();
        operations.add(operation1);
        operations.add(operation2);
        operations.add(operation3);
        operations.add(operation4);
        operations.add(operation5);
        /**
         * Делаем дополнительное составное условие из полей и операторов
         */
        this.fields = field1+ operations.get(i)+ num ;

        /**
         * дополнительные условия.
         */
        String query1 = "WHERE "  ;
        String query2 = "AND "  ;
        String query3 = "OR "  ;
        /**
         * добавляем их в лист.
         */
        queryList.add(query1);
        queryList.add(query2);
        queryList.add(query3);

//         ...
//         ...

        // реальный запрос из моей таблицы
    //    SELECT * FROM orders inner JOIN attachment ON  (orders.attachment_id = attachment.attach_id)  WHERE description_attach  LIKE '%har%'   ;
    }
}
