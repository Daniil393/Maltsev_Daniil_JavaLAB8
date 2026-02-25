package ru.maltsev.weapons;

/**
 * Класс {@code Pistol} представляет пистолет с ограниченной вместимостью магазина.
 * <p>
 * Пистолет может быть перезаряжен, разряжен и выполнять одиночные
 * или множественные выстрелы.
 */
public class Pistol {

    /** Текущее количество патронов в магазине. */
    private int bullets;

    /** Максимальная вместимость магазина. */
    private final int capacity;

    /**
     * Создаёт пистолет с указанной вместимостью магазина.
     *
     * @param capacity максимальное количество патронов (не может быть отрицательным)
     * @throws IllegalArgumentException если {@code capacity < 0}
     */
    public Pistol(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        this.capacity = capacity;
        this.bullets = 0;
    }

    /**
     * Производит выстрел.
     * <p>
     * Если патроны есть — выводится "Бах!" и количество уменьшается.
     * Если патронов нет — выводится "Клац!".
     */
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        }
        else
            System.out.println("Клац!");
    }

    /**
     * Производит несколько выстрелов подряд.
     *
     * @param times количество выстрелов (не может быть отрицательным)
     * @throws IllegalArgumentException если {@code times < 0}
     */
    public void shoot(int times) {
        if (times < 0)
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");

        for (int i = 0; i < times; i++) {
            if (bullets > 0) {
                System.out.println("Бах!");
                bullets--;
            }
            else {
                System.out.println("Клац!");
            }
        }
    }

    /**
     * Загружает патроны в магазин.
     *
     * @param bulletsToLoad количество патронов для загрузки
     *                      (не может быть отрицательным)
     * @return количество патронов, которые не поместились в магазин
     * @throws IllegalArgumentException если {@code bulletsToLoad < 0}
     */
    public int reload(int bulletsToLoad) {
        if (bulletsToLoad < 0)
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");

        int total = bullets + bulletsToLoad;

        if (total <= capacity) {
            bullets = total;
            return 0;
        }
        else {
            bullets = capacity;
            return total - capacity;
        }
    }

    /**
     * Разряжает пистолет.
     *
     * @return количество извлечённых патронов
     */
    public int unload() {
        int returned = bullets;
        bullets = 0;
        return returned;
    }

    /**
     * Проверяет, заряжен ли пистолет.
     *
     * @return {@code true}, если есть хотя бы один патрон,
     *         иначе {@code false}
     */
    public boolean isLoaded() {
        return bullets > 0;
    }

    /**
     * Возвращает максимальную вместимость магазина.
     *
     * @return вместимость
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Возвращает текущее количество патронов.
     *
     * @return количество патронов
     */
    public int getBullets() {
        return bullets;
    }

    /**
     * Возвращает строковое представление пистолета.
     *
     * @return строка в формате:
     * "Пистолет [патроны: X]"
     */
    @Override
    public String toString() {
        return "Пистолет [патроны: " + bullets + "]";
    }
}
