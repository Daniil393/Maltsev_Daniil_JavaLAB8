package zadanie_2_1;

public class Cat implements Meowable {

    private String name;
    private int meowCount = 0; // новое поле для подсчёта мяуканий

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

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

        meowCount += n; // увеличиваем счётчик на n
    }

    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}