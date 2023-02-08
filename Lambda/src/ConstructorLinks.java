import worker.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorLinks {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Stream<Person> stream = names.stream().map(Person::new);
        //List<Person> people = stream.collect(Collectors.toList());

        var persons = stream.toArray(Person[]::new);

        repeatMessage("Hello", 1000);

    }

    public static void repeatMessage(String text, int delay) {
        ActionListener listener = event -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };

        new Timer(delay, listener).start();
    }
}

