package main.items;

import main.items.armor.Armor;
import main.items.armor.SlotType;

public interface UseArmor {
    public void addArmor(Armor armor);

    public void clearArmor(SlotType slot);
}
