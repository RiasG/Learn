import worker.Employee;
import worker.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodLinks {
    public static void main(String[] args) {
        String str = "asd";
        String str2 = "sss";

        System.out.println(str.concat(str2));

        BiFunction<String, String, String> concat = String::concat;
        System.out.println(concat.apply(str, str2));

        String[] arr = new String[]{"g", "sd", "dds", "vvfsz"};
        Arrays.sort(arr, String::compareToIgnoreCase);


        ArrayList<String> names = new ArrayList<>();
        Stream<Employee> stream =  names.stream().map(Employee::new);
        List<Employee> people = stream.collect(Collectors.toList());


        var t = new Timer(1000, System.out::println);
        Runnable task = System.out::println;


        var greeter = new RepeatGreeter();




    }
}

class Greeter {
    public void greet(ActionEvent event) {
        System.out.println("time is" + Instant.ofEpochMilli(event.getWhen()));

    }

}

class RepeatGreeter extends Greeter {
    public void greet(ActionEvent event) {
        var timer = new Timer(1000, super::greet);
    }

}

