package ru.maltsev.main;

import ru.maltsev.weapons.Weapon;

public class Shooter {

    private String name;
    private Weapon weapon;

    public Shooter(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");

        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon != null) {
            System.out.println(name + ": ");
            weapon.shoot();
        }
        else
            System.out.println(name + ": не могу участвовать в перестрелке");
    }

    @Override
    public String toString() {
        return "Стрелок: " + name + ", оружие: " + (weapon == null ? "нет" : weapon.getClass().getSimpleName());
    }
}