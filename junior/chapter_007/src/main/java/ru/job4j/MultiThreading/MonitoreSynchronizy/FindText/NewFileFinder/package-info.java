/**
 * Поиск текста в текстовых файлах.
 * MyFinder , finderFiles() - парсим диск и кидаем текстовые файлы в лист.
 * reader() - читаем содержимое файла и ложим в map . key - имя файла, value - содержимое файла.
 * Далее используем паттерн producer-consumer .
 * Создаем буфер в который закидываем нашу карту.
 * Создаем Checker - который в несколько потоков проверяет содержимое файла взятого из буфера.
 * Запускаем это все в Start.
 */
package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.NewFileFinder;