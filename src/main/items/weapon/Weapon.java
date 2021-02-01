package main.items.weapon;

import main.Printable;

public abstract class Weapon implements Printable {
    private final String name;
    protected final int level;

    public Weapon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public abstract int damage();

    public abstract WeaponType getWeaponType();

    public String getName() {
        return name;
    }
}
