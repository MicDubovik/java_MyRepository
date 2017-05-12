package ru.job4j.SQL_JDBC.ParserSQL;

/**
 * Created by Katy on 12.05.2017.
 */
class MyFile {
    private String name;
    private String url;
    private String time;

    public MyFile(String name, String url, String time) {
        this.name = name;
        this.url = url;
        this.time = time;
    }

    public MyFile(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}