package zadanie_1_1;

/**
 * Универсальная коробка, способная хранить один объект типа {@code T}.
 * <p>
 * Коробка может быть пустой или содержать объект. Предоставляет методы
 * для добавления, извлечения, проверки состояния и обработки содержимого.
 *
 * @param <T> тип объекта, который может храниться в коробке
 */
public class Box<T> {

    /** Содержимое коробки. */
    private T content;

    /**
     * Создаёт пустую коробку.
     */
    public Box() {
        this.content = null;
    }

    /**
     * Создаёт коробку с начальным содержимым.
     *
     * @param content объект для хранения в коробке
     */
    public Box(T content) {
        this.content = content;
    }

    /**
     * Кладёт объект в коробку.
     *
     * @param item объект для помещения в коробку
     * @throws IllegalStateException если коробка уже содержит объект
     */
    public void put(T item) {
        if (content != null)
            throw new IllegalStateException("Коробка уже содержит объект: " + content);
        this.content = item;
    }

    /**
     * Извлекает объект из коробки и делает её пустой.
     *
     * @return объект, который был в коробке
     * @throws IllegalStateException если коробка пуста
     */
    public T get() {
        if (content == null)
            throw new IllegalStateException("Коробка пуста");
        T item = content;
        content = null;
        return item;
    }

    /**
     * Проверяет, заполнена ли коробка.
     *
     * @return {@code true}, если коробка содержит объект, иначе {@code false}
     */
    public boolean isFull() {
        return content != null;
    }

    /**
     * Возвращает содержимое коробки без извлечения.
     *
     * @return объект в коробке
     * @throws IllegalStateException если коробка пуста
     */
    public T peek() {
        if (content == null)
            throw new IllegalStateException("Коробка пуста");
        return content;
    }

    /**
     * Очищает коробку.
     */
    public void clear() {
        content = null;
    }

    /**
     * Возвращает строковое представление коробки.
     *
     * @return строка {@code Box{empty}}, если пусто,
     *         иначе {@code Box{content}}
     */
    @Override
    public String toString() {
        if (content == null)
            return "Box{empty}";
        else
            return "Box{" + content + "}";
    }

    /**
     * Возвращает текущее содержимое коробки.
     *
     * @return объект в коробке или {@code null}, если пусто
     */
    public T getContent() {
        return content;
    }

    /**
     * Обрабатывает коробку:
     * выводит её содержимое и извлекает объект, если он есть.
     * <p>
     * Если коробка пустая, выводится соответствующее сообщение.
     */
    public void processBox() {
        System.out.println("Передана коробка: " + this);
        if (isFull()) {
            T value = get();
            System.out.println("Извлечено значение: " + value);
        }
        else {
            System.out.println("Коробка пуста, нечего извлекать");
        }
    }
}
