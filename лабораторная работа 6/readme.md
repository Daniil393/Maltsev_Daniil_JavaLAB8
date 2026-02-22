# Лабораторная работа 6. ИКНТ, Мальцев Даниил ИТ18 – группа LAB8

Лабораторная работа представляет из себя:

# Класс Main - главный класс, который вызывает в себе классы заданий 1 - 8.

# Классы и аннотации к заданиям 1 - 8:

1) public @interface Invoke
   public class InvokeProcessor
   public class TestClass

2) public @interface Default
   public class DefaultProcessor
   public class TestClass2

3) public enum Mode
   public @interface ToString
   public class ToStringProcessor
   public class Person

4) public @interface Validate
   public class ValidateProcessor
   public class TestClass3

5) public @interface Two
   public class TwoProcessor
   public class TestClass4

6) public @interface Cache
   public class CacheProcessor
   public class TestClass5
   public class TestClass6

7)

8)

Рассмотрим каждый класс и аннотацию индивидуально

# Класс Main
Класс Main демонстрирует работу всех разработанных классов, выполняя требования заданий. Основная роль класса - создать объекты различных типов, вызвать их методы и визуально показать пользователю результаты работы.

Программа последовательно демонстрирует решения задач: функциональность пистолета, автомата, пистолета, который наследует класс Weapon; создание имен, телефонного справочника, стрелков; сравнение точек; возведение
чисел в степень.

> Задание 1 – (аннотация @Invoke)

Разработайте аннотацию @Invoke, со следующими характеристиками:
• Целью может быть только МЕТОД
• Доступна во время исполнения программы
• Не имеет свойств
Создайте класс, содержащий несколько методов, и проаннотируйте хотя бы один из них 
аннотацией @Invoke.
Реализуйте обработчик (через Reflection API), который находит методы, отмеченные 
аннотацией @Invoke, и вызывает их автоматически.
___

В ходе выполнения данного задания были разработаны классы InvokeProcessor и TestClass, аннотация Invoke.

### Класс InvokeProcessor
В класс входит один метод

*Метод*:
public static void process(Object obj):
  - Получает класс переданного объекта.
  - Находит все объявленные методы этого класса.
  - Проверяет наличие аннотации @Invoke.
  - Делает такие методы доступными (в том числе private).
  - Вызывает их с помощью method.invoke().

### Класс TestClass













Результат выполнения задания:

```java

```












