package zadanie_6_5;

import java.util.*;

/**
 * Утилитный класс для работы с очередями.
 * <p>
 * Содержит метод для обращения элементов одной очереди и переноса их в другую очередь.
 */
public class QueueReverser {

    /**
     * Обращает порядок элементов исходной очереди {@code original} и помещает
     * их в целевую очередь {@code target}.
     * <p>
     * Метод использует {@link Stack} для временного хранения элементов, чтобы
     * обеспечить обратный порядок. Исходная очередь {@code original} при этом
     * не изменяется.
     *
     * @param <T> тип элементов очереди
     * @param original исходная очередь
     * @param target целевая очередь, куда будут добавлены элементы в обратном порядке
     */
    public static <T> void reverseQueueToAnother(Queue<T> original, Queue<T> target) {
        Stack<T> stack = new Stack<>();

        // Переносим элементы original в стек (обратный порядок)
        for (T elem : original) {
            stack.push(elem);
        }

        // Добавляем элементы из стека в конец target
        while (!stack.isEmpty()) {
            target.offer(stack.pop());
        }
    }
}