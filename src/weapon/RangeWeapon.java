package weapon;

public class RangeWeapon {
    private final int BASE_DAMAGE = 5;
    private String name;
    private int level;

    public RangeWeapon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int damage() {
        return BASE_DAMAGE + 3 * level;
    }
}
