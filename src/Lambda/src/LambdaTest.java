

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * 9 * В этой программе демонстрируется
 * 10 * применение лямбда-выражений
 * 11 * @version 1.0 2015-05-12
 * 12 * @author Сау Horstmann
 * 13
 */
public class LambdaTest {
    public static void main(String[] args) {

        String[] planets = new String[]{"Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn",
                "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());

        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000,
                event -> System.out.println("The time is" + new Date()));
        t.start();

        //выполнять программу до тех пор, пока пользователь
        //не выберет экранную кнопку "ОК"
        JOptionPane.showMessageDialog(null,
                "Quit program?");
        System.exit(0);


    }
}



