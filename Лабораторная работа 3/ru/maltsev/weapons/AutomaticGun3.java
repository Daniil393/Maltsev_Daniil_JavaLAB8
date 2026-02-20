package ru.maltsev.weapons;

public class AutomaticGun3 extends Weapon2 {

    private final int rateOfFire;

    public AutomaticGun3(int ammo, int rateOfFire) {
        super(ammo);

        if (rateOfFire <= 0)
            throw new IllegalArgumentException("Скорострельность должна быть положительной");

        this.rateOfFire = rateOfFire;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < rateOfFire; i++) {
            if (ammo > 0) {
                ammo--;
                System.out.println("Бах!");
            } else {
                System.out.println("Клац!");
                break;
            }
        }
    }

    public void shoot(int seconds) {
        if (seconds <= 0)
            throw new IllegalArgumentException("Время должно быть положительным");

        for (int i = 0; i < seconds * rateOfFire; i++) {
            if (ammo > 0) {
                ammo--;
                System.out.println("Бах!");
            } else {
                System.out.println("Клац!");
                break;
            }
        }
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    @Override
    public String toString() {
        return "Автомат [патроны: " + ammo + ", скорострельность: " + rateOfFire + "]";
    }
}