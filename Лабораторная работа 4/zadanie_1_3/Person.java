package zadanie_1_3;

public class Person implements Сравнимое<Person> {
    private String name;
    private int age;
    private String city;

    public Person() {
        this.name = "";
        this.age = 0;
        this.city = "";
    }

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int сравнить(Person other) {
        if (this.age < other.age)
            return -1;
        else if (this.age > other.age)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Person{name = " + name + ", age = " + age + ", city = " + city + "}";
    }
}