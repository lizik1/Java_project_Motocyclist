package wear;

import java.util.ArrayList;
import ammunition.*;

public class Wear {

    public void buy(ArrayList<Ammunition> inventory, String... ammun) {
        Ammunition temp;
        for (int i = 0; i < ammun.length; i++) {
            temp = defineAmmunition(ammun[i]);
            if (temp != null) {
                inventory.add(temp);
            }
        }
    }

    private Ammunition defineAmmunition(String type) {
        switch (type) {
            case "Gloves_M_300_100":
                return new Gloves("M", 300, 100);
            case "Gloves_S_300_100":
                return new Gloves("S", 300, 100);
            case "Gloves_S_400_110":
                return new Gloves("S", 400, 110);
            case "Helmet_F_1200_600":
                return new Helmet("F", 1200, 600);
            case "Helmet_M_1500_650":
                return new Helmet("M", 1500, 650);
            case "Helmet_M_1300_600":
                return new Helmet("M", 1300, 600);
            default:
                System.out.println("Sir, I haven`t " + type + ".");
                return null;
        }


    }
}

