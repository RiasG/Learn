public class Starter {



    public static void main(String[] args) {
        byte a = 1;
        byte b = 3;

        int i = a | b;
        System.out.println(i);
        i = a & b;
        System.out.println(i);

        System.out.println(~a);
        System.out.println(~b);

        i = 1;
        while (i < 256){
            System.out.print(i + " ");
            i = i << 1;
        }
        System.out.println();

        i = 1;
        while (i <= 256){
            System.out.print(i + " ");
            i = i << 2;
        }
        System.out.println();

        i = 256;
        while (i >= 1){
            System.out.print(i + " ");
            i = i >> 2;
        }
        System.out.println();

        String s = "hgfdsad egwagr3eg cods nhgskc";
        System.out.println(stringTransform(s, UPPER + REVERSE + ASD));


    }

    /**
     * числа должны быть четными
     */
    private static final int UPPER = 1;
    private static final int SPACE = 2;
    private static final int REVERSE = 4;
    private static final int ASD = 10;

    private static String stringTransform(String s, int flags){

        if ((flags & UPPER) != 0){
            s = s.toUpperCase();
        }

        if ((flags & SPACE) != 0){
            s = s.replaceAll("\\s+", "");
        }

        if ((flags & REVERSE) != 0){
            s = new StringBuilder(s).reverse().toString();
        }

        if ((flags & ASD) != 0){
            System.out.println("ASD WORK");
        }

        return s;

    }
}
