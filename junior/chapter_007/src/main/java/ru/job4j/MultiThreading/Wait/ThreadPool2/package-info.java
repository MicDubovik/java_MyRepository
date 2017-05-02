/**
 * Реализация ThreadPool.
 * 1.Я создаю производителя Tasker который генерирует новую задачу.
 * 2.Создаю буфер QueueTasks , куда складываю эти задачи .
 * 3. Создаю рабочих Worker ,число равное кол-ву ядер, и отдаю им эти задачи на выполнение .
 * В QueueTasks в методе put мы добавляем задачу для исполнителей и будим исполнителя.
 * В методе get проверяем условие , если задачи нет - ждем, иначе - берем задачу из буфера .
 */
package ru.job4j.MultiThreading.Wait.ThreadPool2;