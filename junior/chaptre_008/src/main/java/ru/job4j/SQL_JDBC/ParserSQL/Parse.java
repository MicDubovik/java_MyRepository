package ru.job4j.SQL_JDBC.ParserSQL;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Katy on 11.05.2017.
 */
public class Parse   implements Job {
    /**
     * Logger log4g.
     */
    static Logger log = Logger.getLogger(Parse.class.getName());
    /**
     * List for keeping MyFiles.
     */
    List<MyFile> myFileList = new ArrayList<>();
    /**
     * List for keeping concat String.
     */
    List<String> mynewList = new ArrayList<>();

    String newdate = "17";
    int numPage = 1;
    boolean flag = true;

    // установить в true , если запуск не первый .
    // Устанавливается в true , при выполнении метода split().
    boolean isfirst = false;

    /**
     * Method for parse url.
     * @throws IOException
     * @throws ParseException
     */
    public void parse() throws IOException, ParseException {

        do {
            String urlSQL = "http://www.sql.ru/forum/actualsearch.aspx?search=java&sin=1&bid=66&a=&ma=0&dt=-1&s=1&so=1&pg=" + numPage;

            Document doc = Jsoup.connect(urlSQL).get();
            Elements tdElements = doc.getElementsByAttributeValue("class", "postslisttopic");

            for (Element element : tdElements) {

                    String time = element.parent().child(6).text();

                    if (!time.contains("вчера") && !time.contains("сегодня") ) {
                        SimpleDateFormat oldTime = new SimpleDateFormat("d MMM yy, HH:mm", Locale.getDefault());
                        SimpleDateFormat newTime = new SimpleDateFormat("yy", Locale.getDefault());

                        Date date = oldTime.parse(time);
                        newdate = newTime.format(date);
                    } else {
                        newdate = "17";
                    }

                    Element aelem = element.child(0);
                    String url = aelem.attr("href");
                    String name = aelem.text();


                    if (newdate.equals("17") && name.toLowerCase().contains("java")|| (  name.toLowerCase().contains("javascript") && (name.indexOf("java")!=name.indexOf("javascript"))|| (name.toLowerCase().contains("java script") && (name.indexOf("java")!=name.indexOf("javascript"))))) {
                        myFileList.add(new MyFile(name, url, time));

                    } else {
                        flag = false;

                    }
                }
                if (isfirst){
                    numPage++;
                } else {
                    flag =false;
                }

        } while (flag);
    }

    /**
     * Method for show all ads.
     */
    public void show(){
        for (MyFile myFile : myFileList) {
            System.out.println(myFile);
        }
    }

    /**
     * Method for split String.
     */
    public void split(){
        this.flag=true;
        for (MyFile myFile : myFileList) {
          String file =  myFile.getName()+"////"+myFile.getTime()+"////"+myFile.getUrl();
            mynewList.add(file);
        }
    }

//    public static void main(String[] args) throws IOException, ParseException {
//        Parse parse = new Parse();
//
//            parse.parse();
//
////        parse.show();
//        parse.splt();
//        for (String s : parse.mynewList) {
//            log.info(s);
//        }
//        System.out.println("====================================================");
//        System.out.println(parse.mynewList.get(40));
//    }

    /**
     * Schedule-method
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Parse parse = new Parse();
        try {
            parse.parse();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        parse.show();
        parse.split();
        /**
         * Write String into log.
         */
        for (String s : parse.mynewList) {
            log.warn(s);
        }

    }
}





