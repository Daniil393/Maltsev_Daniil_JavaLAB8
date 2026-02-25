package zadanie_2_1;

/**
 * Класс, представляющий кошку, реализующую интерфейс {@link Meowable}.
 * <p>
 * Поддерживает подсчет количества "мяуканий" и предоставляет возможность
 * мяукать один раз или несколько раз подряд.
 */
public class Cat implements Meowable {

    /** Имя кошки */
    private String name;

    /** Счетчик количества мяуканий */
    private int meowCount = 0;

    /**
     * Создает объект кошка с указанным именем.
     *
     * @param name имя кошки
     */
    public Cat(String name) {
        this.name = name;
    }

    /**
     * Кошка издает один звук "мяу" и увеличивает счетчик мяуканий на 1.
     */
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    /**
     * Кошка издает звук "мяу" n раз подряд, разделяя их дефисом.
     * <p>
     * Счетчик {@link #meowCount} увеличивается на n.
     * Если n <= 0, выводится предупреждение, и счетчик не изменяется.
     *
     * @param n количество мяуканий
     */
    public void meow(int n) {
        if (n <= 0) {
            System.out.println(name + ": (не может мяукать такое количество раз)");
            return;
        }

        StringBuilder s = new StringBuilder();
        s.append(name).append(": ");
        for (int i = 0; i < n; i++) {
            s.append("мяу");
            if (i < n - 1)
                s.append("-");
        }
        s.append("!");
        System.out.println(s.toString());

        meowCount += n;
    }

    /**
     * Возвращает общее количество мяуканий, произведенных этой кошкой.
     *
     * @return количество мяуканий
     */
    public int getMeowCount() {
        return meowCount;
    }

    /**
     * Возвращает строковое представление кошки.
     *
     * @return строка вида "кот(кошка): {имя}"
     */
    @Override
    public String toString() {
        return "кот(кошка): " + name;
    }
}