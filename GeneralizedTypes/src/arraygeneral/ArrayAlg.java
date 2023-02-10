package arraygeneral;

public class ArrayAlg {


    public static class Pair<T> {
        private T first;
        private T second;

        public Pair() {
            first = null;
            second = null;
        }

        public Pair(T f, T s) {
            first = f;
            second = s;
        }


        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }
    }

    public static Pair<String> minmax(String[] values) {
        if (values == null || values.length == 0) return null;
        String min = values[0];
        String max = values[0];


        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
            if (max.compareTo(values[i]) < 0) max = values[i];
        }
        return new Pair<>(min, max);
    }


    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++)
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        return smallest;
    }


}
