package ru.maltsev.weapons;

public class AutomaticGun extends Pistol {

    private final int fireRate;

    public AutomaticGun() {
        super(30);
        this.fireRate = 30;
    }

    public AutomaticGun(int capacity) {
        super(capacity);
        this.fireRate = capacity / 2;
    }

    public AutomaticGun(int capacity, int fireRate) {
        super(capacity);

        if (fireRate <= 0)
            throw new IllegalArgumentException("Скорострельность должна быть положительной");

        this.fireRate = fireRate;
    }

    @Override
    public void shoot() {
        super.shoot(fireRate);
    }

    public void shoot(int seconds) {
        if (seconds <= 0)
            throw new IllegalArgumentException("Время должно быть положительным");

        super.shoot(seconds * fireRate);
    }

    public int getFireRate() {
        return fireRate;
    }
}