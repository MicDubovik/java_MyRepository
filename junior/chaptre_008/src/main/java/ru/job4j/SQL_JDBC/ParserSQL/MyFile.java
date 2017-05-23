package ru.job4j.SQL_JDBC.ParserSQL;

/**
 * MyFile.
 */
class MyFile {
    /**
     * Name.
     */
    private String name;
    /**
     * URL.
     */
    private String url;
    /**
     * Date.
     */
    private String time;

    /**
     * Constructor.
     * @param name
     * @param url
     * @param time
     */
    public MyFile(String name, String url, String time) {
        this.name = name;
        this.url = url;
        this.time = time;
    }

    /**
     * Constructor.
     * @param name
     * @param url
     */
    public MyFile(String name, String url) {
        this.name = name;
        this.url = url;
    }

    /**
     * Get.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get.
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set.
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get.
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     * Set.
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * toString.
     * @return
     */
    @Override
    public String toString() {
        return "MyFile{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}