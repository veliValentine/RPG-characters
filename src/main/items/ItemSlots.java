package main.items;

import main.Stats;
import main.RoundDown;
import main.items.armor.Armor;
import main.items.armor.SlotType;
import main.items.weapon.Weapon;
import main.items.weapon.WeaponType;

public class ItemSlots implements Stats, UseWeapon, UseArmor {
    private Weapon weapon;
    private Armor bodyArmor;
    private Armor helmet;
    private Armor leggings;

    @Override
    public void addWeapon(Weapon weapon) {
        if (weapon == null) {
            return;
        }
        this.weapon = weapon;
    }

    @Override
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

    @Override
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

    @Override
    public void clearWeapon() {
        weapon = null;
    }

    public int attack(int strength, int dexterity, int intelligence) {
        if (weapon != null) {
            int totalDamage = weapon.damage();
            // check weapon type and scale damage accordingly
            if (weapon.getWeaponType() == WeaponType.Melee) {
                totalDamage += RoundDown.roundDown(1.5 * strength);
            }
            if (weapon.getWeaponType() == WeaponType.Ranged) {
                totalDamage += RoundDown.roundDown(2 * dexterity);
            }
            if (weapon.getWeaponType() == WeaponType.Magic) {
                totalDamage += RoundDown.roundDown(3 * intelligence);
            }
            System.out.println("Attacking for " + totalDamage);
            return totalDamage;
        }
        return 0;
    }

    @Override
    public int getHealth() {
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

    @Override
    public int getStrength() {
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

    @Override
    public int getDexterity() {
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

    @Override
    public int getIntelligence() {
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
