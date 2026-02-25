package zadanie_1_1;

import java.lang.reflect.Method;

/**
 * Класс для обработки аннотации {@link Invoke}.
 * <p>
 * Позволяет автоматически вызывать все методы объекта, помеченные аннотацией {@link Invoke}.
 * Использует рефлексию для доступа к приватным и защищённым методам.
 */
public class InvokeProcessor {

    /**
     * Выполняет все методы объекта {@code obj}, которые помечены аннотацией {@link Invoke}.
     * <p>
     * Методы вызываются через рефлексию, включая приватные и защищённые.
     * В случае возникновения исключения оно выводится в стандартный поток ошибок.
     *
     * @param obj объект, методы которого необходимо вызвать
     * @throws NullPointerException если {@code obj} равен {@code null}
     */
    public static void process(Object obj) {
        Class<?> clas = obj.getClass();

        for (Method method : clas.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}