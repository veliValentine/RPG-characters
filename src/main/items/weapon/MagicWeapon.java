package main.items.weapon;

public class MagicWeapon extends Weapon {
    private final int BASE_DAMAGE = 25;

    public MagicWeapon(String name, int level) {
        super(name, level);
    }

    @Override
    public void print() {
        System.out.println("Weapon type: Magic");
        System.out.println("Weapon level: " + level);
        System.out.println("Damage: " + damage());
    }

    @Override
    public int damage() {
        return BASE_DAMAGE + level * 2;
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.Magic;
    }
}
