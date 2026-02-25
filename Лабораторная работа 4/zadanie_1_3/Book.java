package zadanie_1_3;

/**
 * Класс {@code Book} представляет книгу с названием, годом издания,
 * автором и ценой.
 * <p>
 * Реализует интерфейс {@link Сравнимое}, сравнивая книги по цене.
 */
public class Book implements Сравнимое<Book> {

    /** Название книги. */
    private String title;

    /** Год издания книги. */
    private int year;

    /** Автор книги. */
    private String author;

    /** Цена книги. */
    private double price;

    /**
     * Создаёт книгу с пустыми полями и ценой 0.0.
     */
    public Book() {
        this.title = "";
        this.author = "";
        this.price = 0.0;
    }

    /**
     * Создаёт книгу с указанными названием, годом, автором и ценой.
     *
     * @param title название книги
     * @param year год издания
     * @param author автор книги
     * @param price цена книги
     */
    public Book(String title, int year, String author, double price) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
    }

    /**
     * Возвращает название книги.
     *
     * @return название
     */
    public String getTitle() {
        return title;
    }

    /**
     * Устанавливает название книги.
     *
     * @param title название
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Возвращает автора книги.
     *
     * @return автор
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Устанавливает автора книги.
     *
     * @param author автор
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Возвращает цену книги.
     *
     * @return цена
     */
    public double getPrice() {
        return price;
    }

    /**
     * Устанавливает цену книги.
     *
     * @param price цена
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Возвращает год издания книги.
     *
     * @return год
     */
    public int getYear() {
        return year;
    }

    /**
     * Устанавливает год издания книги.
     *
     * @param year год
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Сравнивает текущую книгу с другой книгой по цене.
     * <p>
     * Возвращает отрицательное число, если текущая книга дешевле {@code other},
     * положительное число, если дороже, и 0 если цены равны.
     *
     * @param other другой объект {@code Book} для сравнения
     * @return результат сравнения по цене
     */
    @Override
    public int сравнить(Book other) {
        if (this.price < other.price)
            return -1;
        else if (this.price > other.price)
            return 1;
        else
            return 0;
    }

    /**
     * Возвращает строковое представление книги.
     *
     * @return строка формата "Book{title = ..., author = ..., price = ...}"
     */
    @Override
    public String toString() {
        return "Book{title = " + title + ", author = " + author + ", price = " + price + "}";
    }
}
