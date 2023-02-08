import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.printf("%8.2f", 1000.0 / 3.0);
        System.out.printf("%8.2f", 1000.0 / 3.0);
        System.out.println();
        String name = "Andrey";
        int age = 20;
        System.out.printf("Hey, %s. Next year, you'll be %d", name, age);
        System.out.println();
        System.out.printf("%1$s %2$tB %2$te, %2$tY", "Due date:", new Date());
        System.out.println();


        var b = new A();
        A.setI(2);
        System.out.println(A.getI());


        System.out.println(B.getI());

        for (int j = 0; j < 100; j++) {
            var i = new Random();
            System.out.print(i.nextInt(10) + " ");
        }
        System.out.println();


    }



}



