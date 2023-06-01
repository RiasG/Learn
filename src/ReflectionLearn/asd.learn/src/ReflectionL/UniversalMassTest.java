package ReflectionL;

import ReflectionL.person.Employee;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class UniversalMassTest {
    public static void main(String[] args) {
        var a = new Employee[100];
        for (int i = 0; i < a.length; i++){
            a[i] = new Employee(Integer.toString(i), i, 2000, 1, 4 );

        }

        a = (Employee[]) copyOf(a, 2 * a.length);
        System.out.println(Arrays.toString(a));

        int[] n = {1,2,3};
        n = (int[]) copyOf(n,10);
        System.out.println(Arrays.toString(n));
    }

    public static Object copyOf(Object a, int newLength){
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
