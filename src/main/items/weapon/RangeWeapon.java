package main.items.weapon;

public class RangeWeapon extends Weapon {
    private final int BASE_DAMAGE = 5;

    public RangeWeapon(String name, int level) {
        super(name, level);
    }

    @Override
    public void print() {
        System.out.println("Weapon type: Ranged");
        System.out.println("Weapon level: " + level);
        System.out.println("Damage: " + damage());
    }

    @Override
    public int damage() {
        return BASE_DAMAGE + level * 3;
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.Ranged;
    }
}
