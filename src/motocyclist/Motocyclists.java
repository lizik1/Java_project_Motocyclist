package motocyclist;


import java.util.ArrayList;
import ammunition.Ammunition;
import motocyclist.Motocyclist;
import wear.Wear;

public class Motocyclists {

    public static void main(String[] args) {
        Motocyclist motocyclist = new Motocyclist("Flying kite", new ArrayList<Ammunition>(), "Roland", 29);
        Wear shop = new Wear();
        shop.buy(motocyclist.getAmmunition(), "Gloves_M_300_100", "Helmet_M_1500_650", "Helmet_M_1300_600");

        System.out.println("General information about motocyclist:");
        System.out.println(motocyclist);
        System.out.println("Ammunition is sorted by weight: ");
        motocyclist.sortAmmunitionByWeight();
        System.out.println(motocyclist);
        ArrayList<Ammunition> f = motocyclist.findAmmunitionByCost(300, 1500);
        StringBuilder k = new StringBuilder();
        System.out.println("Ammunition at a price: ");
        if (!f.isEmpty()) {
            for (Ammunition ammunition : f) {
                k.append(new StringBuilder(ammunition.toString()));
            }
        }
        System.out.println(k);
        System.out.println("The cost of all ammo: ");
        System.out.println(motocyclist.summAmmun());
    }
}

//Мотоциклист. Определить иерархию амуниции. Экипировать мотоциклиста.
// Подсчитать стоимость. Провести сортировку амуниции на основе веса.
//
//Найти элементы амуниции, соответствующие заданному диапазону пара-
//метров цены.