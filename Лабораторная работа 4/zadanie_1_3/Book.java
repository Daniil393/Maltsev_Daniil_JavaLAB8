package zadanie_1_3;

public class Book implements Сравнимое<Book> {
    private String title;
    private int year;
    private String author;
    private double price;

    public Book() {
        this.title = "";
        this.author = "";
        this.price = 0.0;
    }

    public Book(String title, int year, String author, double price) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int сравнить(Book other) {
        if (this.price < other.price)
            return -1;
        else if (this.price > other.price)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "zadanie_1_3.Book{title = " + title + ", author = " + author + ", price = " + price + "}";
    }
}