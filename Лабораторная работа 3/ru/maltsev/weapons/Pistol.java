package ru.maltsev.weapons;

public class Pistol {

    private int bullets;
    private final int capacity;

    public Pistol(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        this.capacity = capacity;
        this.bullets = 0;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        }
        else
            System.out.println("Клац!");
    }

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

    public int unload() {
        int returned = bullets;
        bullets = 0;
        return returned;
    }

    public boolean isLoaded() {
        return bullets > 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBullets() {
        return bullets;
    }

    @Override
    public String toString() {
        return "Пистолет [патроны: " + bullets + "]";
    }
}