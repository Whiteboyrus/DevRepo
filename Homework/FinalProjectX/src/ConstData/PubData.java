package ConstData;

import java.util.Scanner;

/**
 * Created by DMX101 on 25/10/15.
 */


                                /*
     Абстрактный класс ConstData.PubData, содержащий переменные с URL адресами и некоторые служебные
                                */
public abstract class PubData {

    public static String JSON_URL = "http://kiparo.ru/t/student.json";
    public static String XML_URL = "http://kiparo.ru/t/student.xml";

    public String input ="";
    public boolean chk = false;
}
