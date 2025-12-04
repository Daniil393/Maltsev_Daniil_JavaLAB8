package zadanie_3;

public interface Reducer<T> {
    T apply(T a, T b);
}