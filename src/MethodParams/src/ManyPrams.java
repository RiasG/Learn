public class ManyPrams {
    public static void main(String[] args) {

        System.out.println(max(3.2,23,44,2));
        System.out.println(max(3));
    }

    public static double max(double... values){

        double largest = values[0];
        for (double v : values) {
            if (v > largest) largest = v;
        }
        return largest;
    }
}
