public class ArrayAlg {


    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public static Pair minmax(double[] values) {
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            for (double v : values) {
                if (min > v) min = v;
                if (max < v) max = v;
            }
            return new Pair(min, max);
        }

        public static void minmax(int i, int i1) {
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }


}
