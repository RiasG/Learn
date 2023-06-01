package pair;

public class Pair<T> {
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

    public void setSecond(T second) {
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;

    }
}
