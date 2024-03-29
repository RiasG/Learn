package pair;

import pair.employye.Employee;
import pair.employye.Manager;

public class PairTest {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus", 8000000, 2003, 12, 15);
        Manager cfo = new Manager("Sid", 600000, 2003, 12, 15);

        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);
        System.out.println("first: "
                + result.getFirst().getName() + ", second: "
                + result.getSecond().getName());

        maxminBonus(managers, result);
        System.out.println("first: "
                + result.getFirst().getName() + ", second: "
                + result.getSecond().getName());
    }

    private static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and "
                + second.getName() + " are buddies.");

    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a == null || a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result);
    }

}
