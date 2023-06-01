import person.Employee;


import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Harry", 2323);
        staff[1] = new Employee("Carl", 1000);
        staff[2] = new Employee("Tony", 32134);
        Arrays.sort(staff);

        for (Employee e : staff){
            System.out.println("n = " + e.getName() + ", salary = " + e.getSalary());
        }



    }
}
