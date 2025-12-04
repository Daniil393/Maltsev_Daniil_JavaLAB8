package zadanie_3;

@FunctionalInterface
public interface MyFunction<T, P> {
    P apply(T t);
}