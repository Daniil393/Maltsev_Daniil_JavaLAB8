package zadanie_3;

public interface Collector<P, T> {
    void add(P collection, T value);
}