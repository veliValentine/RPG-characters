package main.items.weapon;

public class MeleeWeapon extends Weapon {
    private final int BASE_DAMAGE = 15;

    public MeleeWeapon(String name, int level) {
        super(name, level);
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

}
