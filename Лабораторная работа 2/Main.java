import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1.2) человек
        System.out.println("Задание 1.2: ");
        Person cleopatra = new Person("Клеопатра", 152);
        Person pushkin = new Person("Пушкин", 167);
        Person vladimir = new Person("Владимир", 189);

        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(vladimir + "\n");

        // 1.3) имена
        System.out.println("Задание 1.3: ");
        Name cleopatra_name = new Name(null,"Клеопатра", null);
        Name pushkin_name = new Name("Пушкин", "Александр", "Сергеевич");
        Name mayakovsky_name = new Name("Маяковский", "Владимир", null);

        System.out.println(cleopatra_name);
        System.out.println(pushkin_name);
        System.out.println(mayakovsky_name + "\n");

        // 2.4) сотрудники и отделы
        System.out.println("Задание 2.4: ");
        Department it = new Department("IT");

        Employee petrov = new Employee("Петров", it);
        Employee kozlov = new Employee("Козлов", it);
        Employee sidorov = new Employee("Сидоров", it);

        it.setChief(kozlov);

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
        System.out.println("\n");

        // 3.4) сотрудники и отделы
        System.out.println("Задание 3.4: ");
        Department2 it2 = new Department2("IT");

        Employee2 petrov2 = new Employee2("Петров", it2);
        Employee2 kozlov2 = new Employee2("Козлов", it2);
        Employee2 sidorov2 = new Employee2("Сидоров", it2);

        it2.setChief(kozlov2);

        System.out.println(petrov2);
        System.out.println(kozlov2);
        System.out.println(sidorov2);

        System.out.println("\nСотрудники отдела IT через Петрова:");
        for (Employee2 e : petrov2.getColleagues())
            System.out.println(" - " + e.getName());

        // 4.5) создаем имена
        System.out.println("\nЗадание 4.5: ");
        Name2 n1 = new Name2("Клеопатра");
        Name2 n2 = new Name2("Александр", "Пушкин", "Сергеевич");
        Name2 n3 = new Name2("Владимир", "Маяковский");
        Name2 n4 = new Name2("Христофор", "Бонифатьевич");

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);


        // 5.1) пистолет стреляет
        System.out.println("\nЗадание 5.1: ");
        Pistol pistol = new Pistol(3);
        System.out.println(pistol);

        for (int i = 0; i < 5; i++)
            pistol.shoot();

        System.out.println("Осталось патронов: " + pistol.getBullets());
    }
}