package zadanie_1_1;

public class Box<T> {
    private T content;

    public Box() {
        this.content = null;
    }

    public Box(T content) {
        this.content = content;
    }

    public void put(T item) {
        if (content != null)
            throw new IllegalStateException("Коробка уже содержит объект: " + content);
        this.content = item;
    }

    public T get() {
        if (content == null)
            throw new IllegalStateException("Коробка пуста");
        T item = content;
        content = null;
        return item;
    }

    public boolean isFull() {
        return content != null;
    }

    public T peek() {
        if (content == null)
            throw new IllegalStateException("Коробка пуста");
        return content;
    }


    public void clear() {
        content = null;
    }

    @Override
    public String toString() {
        if (content == null)
            return "Box{empty}";
        else
            return "Box{" + content + "}";
    }

    public T getContent() {
        return content;
    }

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