public class ArrayTest {
    public static void main(String[] args) {
        ArrayAlg alg = new ArrayAlg();
        ArrayAlg.Pair pair = ArrayAlg.Pair.minmax(new double[]{32,55,121});
        System.out.println(pair.getSecond() + " " +
        pair.getFirst());

    }
}
