package weapon;

public class RangeWeapon implements Weapon {
    private final int BASE_DAMAGE = 5;
    private String name;
    private int level;

    public RangeWeapon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        System.out.println("Weapon type: Ranged");
        System.out.println("Weapon level: " + level);
        System.out.println("Damage: " + damage());
    }

    @Override
    public int damage() {
        return BASE_DAMAGE + 3 * level;
    }
}
