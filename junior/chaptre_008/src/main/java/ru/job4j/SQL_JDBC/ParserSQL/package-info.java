/**
 * Парсер объявлений с sql.ru
 * Парсим сайт и закидываем данные в лист myFileList.
 * MyFile хранит заголовок объявления , дату и url.
 * Затем склеиваю поля и отдаю логеру .
 * Логер разрезает их и закидывает в таблицу.
 * Перед первым запуском создать таблицу
 *  CREATE TABLE logs (
 *  message  VARCHAR(10),
 *  text    VARCHAR(200),
 *  date VARCHAR(20),
 *  url_name VARCHAR(200) UNIQUE
 *  );
 *
 */
package ru.job4j.SQL_JDBC.ParserSQL;