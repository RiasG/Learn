import java.util.Comparator;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaWorking {
    public static void main(String[] args) {
        repeat(10, () -> System.out.println("Runnable work"));
        repeat(10, (i) -> System.out.println("Countdown: " + (9 - i)));

    }

    public static void repeat(int n, Runnable action){
        for (int i = 0; i < n; i++) action.run();
    }

    public static void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++) action.accept(i);
    }
}
