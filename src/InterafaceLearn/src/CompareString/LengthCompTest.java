package CompareString;

import java.util.Arrays;
import java.util.Comparator;

public class LengthCompTest {
    public static void main(String[] args) {
        String[] str = {"dadkpaodk", "name212", "dsa", "3213213"};
        Arrays.sort(str, new LengthComparator());
        System.out.println(Arrays.toString(str));


    }


}
