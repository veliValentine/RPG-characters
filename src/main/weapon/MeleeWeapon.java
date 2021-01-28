package main.weapon;

public class MeleeWeapon implements Weapon {
    private final int BASE_DAMAGE = 15;
    private final String name;
    private final int level;

    public MeleeWeapon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        System.out.println("Weapon type: Melee");
        System.out.println("Weapon level: " + level);
        System.out.println("Damage: " + damage());
    }

    @Override
    public int damage() {
        return BASE_DAMAGE + level * 2;
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.Melee;
    }

    @Override
    public String getName() {
        return name;
    }
}
