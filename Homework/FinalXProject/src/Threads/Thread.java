package Threads;

import Students.Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Pavlik on 10/18/15.
 */
public class Thread extends java.lang.Thread{

    private URL downloader;
    private Students students;
    private String doc;

    public static final String json= "http://kiparo.ru/t/student.json";
    public static final String xml= "http://kiparo.ru/t/student.xml";

    public URL getDownloader() {
        return downloader;
    }

    public void setDownloader(URL downloader) {
        this.downloader = downloader;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    @Override
    public void run() {
        super.run();
    }

    public BufferedReader URLConnection () {

        HttpURLConnection connect;
        BufferedReader input = null;
        try {
            downloader = new URL(json);
            connect = (HttpURLConnection)downloader.openConnection();
            input = new BufferedReader(new InputStreamReader((connect.getInputStream())));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
