import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person{


    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year,
            int month, int day) {
        super(name);


        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);

    }




    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;

    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String getDescription() {
        return "an employee with a salary of " + getSalary();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return Double.compare(employee.salary, salary) == 0
//                && hireDay.equals(employee.hireDay);
//    }

    @Override
    public boolean equals(Object o){
        return  o != null
                && getClass() == o.getClass()
                && Objects.equals(super.getName(), ((Employee) o).getName())
                && salary == ((Employee) o).salary
                && Objects.equals(hireDay, ((Employee) o).hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), salary, hireDay);

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + super.getName() +
                "salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

}
