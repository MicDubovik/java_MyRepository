package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText;


import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class FindFiles {
    /**
     * Text for find in fileName.
     */
    String text;
    /**
     * Input path.
     */
    File file;

    MyRunable myRunable;

    List<File> fileList = new LinkedList<>();

    /**
     * Constructor.
     *
     * @param text
     * @param file
     */
    public FindFiles(String text, File file) {
        this.myRunable = new MyRunable(text);
        this.text = text;
        this.file = file;
    }
    // Если понадобится перебор по дискам.

//    /**
//     * Array contain name path a-z.
//     *
//     * @param num
//     * @return
//     */
//    public char isAvaliblePath(int num) {
//
//        char[] arrayPath = new char[26];
//
//        char alpha = 'a';
//        for (char i = 0; i < 26; i++) {
//            arrayPath[i] = alpha++;
//        }
//
//        char pathName = arrayPath[num];
//
//        return pathName;
//    }
//
//

    public void cutDirectory(File file) {

        for (File file1 : file.listFiles()) {

            // убираю $RECYCLE.BIN и System Volume Information по причине прав доступа.
            if (file1.isDirectory() && !file1.getName().equals("$RECYCLE.BIN") && !file1.getName().equals("System Volume Information")) {
                this.myRunable.getFindFiles().add(file1);

                System.out.println(file1);
            }
        }
    }


    public static void main(String[] args) {
        // Однопоточный режим.
        String text = "FindFiles";

        File file = new File("d:/");

        FindFiles files = new FindFiles(text, file);
//        long start = System.currentTimeMillis();
//        File temp = files.addFiles(file);                        // для одногопотока
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(temp.getAbsolutePath());              // для одного потока

        files.cutDirectory(file);


        // Вариант с Runable !!!
//         for (int i = 0; i < files.myRunable.getFindFiles().size(); i++) {
//
//             files.myRunable.getNum() = i;
//
//             Thread thread = new Thread(files.myRunable);
//
//             thread.start();
//             try {
//                 thread.join();
//
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
////        System.out.println(System.currentTimeMillis()-start);
//        if (files.myRunable.getTemp() != null) {
//            System.out.println(files.myRunable.getTemp());
//        }

        ExecutorService executor = Executors.newSingleThreadExecutor();

        List<Future<File>> list = new ArrayList<Future<File>>();
//        for (int i = 0; i < files.myRunable.getFindFiles().size(); i++) {
//            files.myRunable.setNum(i);
//
//            Callable<File> callable = files.myRunable;
//            Future<File> submit = executor.submit(callable);
//
//            list.add(submit);
//
//        }

        List<MyRunable> tasks = new ArrayList<>();
        for (int i = 0; i < files.myRunable.getFindFiles().size(); i++) {
            files.myRunable.setNum(13);
            tasks.add(files.myRunable);
        }
        System.out.printf("%s - number directories",files.myRunable.getFindFiles().size());

        try {
            List<Future<File>> futureList = executor.invokeAll(tasks);
            executor.shutdownNow();
            for (Future<File> future : futureList) {
                if (future.get() != null) {
                    System.out.println(future.get());
                    return;
                } else {
                    System.out.println("file not found!!!");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//
//        for (Future<File> future : list) {
//
//            try {
//                if (future.get() != null) {
//                    System.out.println(future.get());
//                    return;
//                } else {
//                    System.out.println("file not found!!!");
//                }
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }

//    }

    }

}












