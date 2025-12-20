package zadanie_6_5;

import java.util.*;

public class QueueReverser {

    /**
     * Переписывает элементы из исходной очереди original в целевую очередь target
     * в обратном порядке, добавляя в конец target.
     *
     * @param original Исходная очередь
     * @param target   Целевая очередь, в конец которой добавляются элементы
     * @param <T>      Тип элементов очереди
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