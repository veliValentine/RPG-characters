package main;

import main.hero.*;
import main.weapon.*;
import main.armor.*;

public class Main {

    public static void main(String[] args) {
        Armor plate = new ClothArmor("testName", 10, SlotType.Legs);
        plate.print();
    }
}
