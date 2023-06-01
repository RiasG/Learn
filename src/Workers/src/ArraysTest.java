

import java.util.ArrayList;

public class ArraysTest {
    public static void main(String[] args) {
        var staff = new ArrayList<Employee>();
        //staff.ensureCapacity(100); // если заранее известно количство элементов
        //staff.trimToSize();// размер блока памяти точно будет соответствовать количеству элементов
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        Employee[] e = new Employee[staff.size()];
        staff.toArray(e);
        Integer n = 3;








    }
}
