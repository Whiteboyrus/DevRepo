package Threads;

import Students.Students;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Pavlik on 10/18/15.
 */
public abstract class Threads extends Thread  {

    URL downloader;
    private Students students;
    private String doc;


    String fileName = "";

    public static final String json= "http://kiparo.ru/t/student.json";
    public static final String xml= "http://kiparo.ru/t/student.xml";

    public Threads(String downloader) {
        this.setDownloader(downloader);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public URL getDownloader() {
        return downloader;
    }

    public void setDownloader(String downloader) {
        this.doc = downloader;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    @Override
    public void run() {
        parse();
    }

    public String URLConnection (String fileLink) {


        InputStream in = null;
        OutputStream out = null;


        try {

            URL url = new URL (fileLink);
            HttpURLConnection connect = (HttpURLConnection)url.openConnection();

            if (fileLink.equals(json)) {
                fileName= "students.json";
            }

            if (fileLink.equals(xml)) {
                fileName= "students.xml";
            }

            int status = connect.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                in = connect.getInputStream();
                File file = new File(fileName);
                out = new FileOutputStream(file);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in !=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                     out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        return String.valueOf(out);
        }

    public abstract void parse();
    }
