import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Pavlik on 10/20/15.
 */
public class Main {

    public static void main (String[] args) {

        String line = "Александр Лукашенко считает, что «сегодня самое лучшее время для эффективной работы». «Вы всегда говорили, что очень высокие цены на энергоносители и сырье, которых у нас нет. Все остальное имеется — технологии, грамотные, подготовленные люди. Сегодня цены на сырье самые низкие. Производите и продавайте», — заявил руководитель государства. Он также продолжил: «В банках надо снять всякий жир вплоть до доведения конкретных показателей по зарплате и оплате труда в зависимости от того, сколько они привезли в страну дешевых денег».";
        String[] mass = line.split(" +");
        int count = 0;



                Arrays.sort(mass, new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return +(s.length()-t1.length());
                    }
                });
            for (String it: mass)

                System.out.print(" "+ it);

        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        }
    }