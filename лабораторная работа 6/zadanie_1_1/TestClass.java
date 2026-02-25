package zadanie_1_1;

/**
 * Тестовый класс для демонстрации работы аннотации {@link Invoke}.
 * <p>
 * Содержит несколько методов, некоторые из которых помечены {@link Invoke}.
 * При обработке через {@link InvokeProcessor} будут вызваны только методы с аннотацией {@code @Invoke}.
 */
public class TestClass {

    /**
     * Первый метод, помеченный аннотацией {@link Invoke}.
     * <p>
     * При вызове через {@link InvokeProcessor#process(Object)} этот метод будет автоматически выполнен.
     */
    @Invoke
    public void methodOne() {
        System.out.println("Method one invoked");
    }

    /**
     * Второй метод без аннотации.
     * <p>
     * Не будет вызван при обработке {@link InvokeProcessor}.
     */
    public void methodTwo() {
        System.out.println("Method two invoked");
    }

    /**
     * Третий метод, помеченный аннотацией {@link Invoke}.
     * <p>
     * При вызове через {@link InvokeProcessor#process(Object)} этот метод будет автоматически выполнен.
     */
    @Invoke
    public void methodThree() {
        System.out.println("Method three invoked");
    }
}