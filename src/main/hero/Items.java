package main.hero;

import main.Utils;
import main.armor.Armor;
import main.armor.SlotType;
import main.weapon.Weapon;
import main.weapon.WeaponType;

public class Items {
    private Weapon weapon;
    private Armor bodyArmor;
    private Armor helmet;
    private Armor leggings;

    public void addWeapon(Weapon weapon) {
        if (weapon == null) {
            return;
        }
        this.weapon = weapon;
    }

    public void addArmor(Armor armor) {
        if (armor == null) return;

        SlotType armorSlot = armor.getSlot();
        if (armorSlot == SlotType.Head) {
            helmet = armor;
        }
        if (armorSlot == SlotType.Body) {
            bodyArmor = armor;
        }
        if (armorSlot == SlotType.Legs) {
            leggings = armor;
        }
    }

    public void clearArmor(SlotType slot) {
        if (slot == SlotType.Head) {
            helmet = null;
        }
        if (slot == SlotType.Body) {
            bodyArmor = null;
        }
        if (slot == SlotType.Legs) {
            leggings = null;
        }
    }

    public void clearWeapon() {
        weapon = null;
    }

    public int attack(int strength, int dexterity, int intelligence) {
        if (weapon != null) {
            int totalDamage = weapon.damage();
            // check weapon type and scale damage accordingly
            if (weapon.getWeaponType() == WeaponType.Melee) {
                totalDamage += Utils.roundDown(1.5 * strength);
            }
            if (weapon.getWeaponType() == WeaponType.Ranged) {
                totalDamage += Utils.roundDown(2 * dexterity);
            }
            if (weapon.getWeaponType() == WeaponType.Magic) {
                totalDamage += Utils.roundDown(3 * intelligence);
            }
            System.out.println("Attacking for " + totalDamage);
            return totalDamage;
        }
        return 0;
    }

    public int itemsHP() {
        int totalBonus = 0;
        if (helmet != null) {
            totalBonus += helmet.getHealth();
        }
        if (bodyArmor != null) {
            totalBonus += bodyArmor.getHealth();
        }
        if (leggings != null) {
            totalBonus += leggings.getHealth();
        }
        return totalBonus;
    }

    public int itemsStrength() {
        int totalBonus = 0;
        if (helmet != null) {
            totalBonus += helmet.getStrength();
        }
        if (bodyArmor != null) {
            totalBonus += bodyArmor.getStrength();
        }
        if (leggings != null) {
            totalBonus += leggings.getStrength();
        }
        return totalBonus;
    }

    public int itemsDexterity() {
        int totalBonus = 0;
        if (helmet != null) {
            totalBonus += helmet.getDexterity();
        }
        if (bodyArmor != null) {
            totalBonus += bodyArmor.getDexterity();
        }
        if (leggings != null) {
            totalBonus += leggings.getDexterity();
        }
        return totalBonus;
    }

    public int itemsIntelligence() {
        int totalBonus = 0;
        if (helmet != null) {
            totalBonus += helmet.getIntelligence();
        }
        if (bodyArmor != null) {
            totalBonus += bodyArmor.getIntelligence();
        }
        if (leggings != null) {
            totalBonus += leggings.getIntelligence();
        }
        return totalBonus;
    }
}
