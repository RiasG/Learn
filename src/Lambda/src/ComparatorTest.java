import worker.Person;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Person("Pers1");
        people[1] = new Person("sofja");
        people[2] = new Person("cscpwe");
        people[3] = new Person("ascw");
        Arrays.sort(people, Comparator.comparing(Person::getName));
        for (Person p : people) {
            System.out.println(p.getName());

        }



    }
}
