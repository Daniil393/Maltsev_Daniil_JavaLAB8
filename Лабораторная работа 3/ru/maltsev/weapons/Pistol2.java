package ru.maltsev.weapons;

public class Pistol2 extends Weapon {

    private final int capacity;

    public Pistol2(int capacity) {
        super(0); // изначально пистолет разряжен
        if (capacity < 0)
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        this.capacity = capacity;
    }

    @Override
    public void shoot() {
        if (getAmmo())
            System.out.println("Бах!");
        else
            System.out.println("Клац!");
    }

    public void shoot(int times) {
        if (times < 0)
            throw new IllegalArgumentException("Количество выстрелов не может быть отрицательным");

        for (int i = 0; i < times; i++)
            shoot();
    }

    public int reload(int bulletsToLoad) {
        if (bulletsToLoad < 0)
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");

        int currentAmmo = ammo();
        int spaceleft = capacity - currentAmmo;

        if (bulletsToLoad <= spaceleft) {
            load(currentAmmo + bulletsToLoad);
            return 0;
        }
        else {
            load(capacity);
            return bulletsToLoad - spaceleft;
        }
    }

    public int unload() {
        int currentAmmo = ammo();
        load(0);
        return currentAmmo;
    }

    public boolean isLoaded() {
        return ammo() > 0;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Пистолет [патроны: " + ammo() + "]";
    }
}