package motocyclist;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ammunition.Ammunition;

public class Motocyclist extends Human {

    private String title;
    private ArrayList<Ammunition> ammunitions;

    public Motocyclist(String title, ArrayList<Ammunition> ammun,
                  String name, int age) {
        super(name, age);
        this.title = title;
        this.ammunitions = ammun;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Ammunition> getAmmunition() {
        return ammunitions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmmunition(ArrayList<Ammunition> ammu) {
        this.ammunitions = ammu;
    }

    public void sortAmmunitionByCost() {
        Collections.sort(ammunitions, new Comparator() {
            public int compare(Object o1, Object o2) {
                Ammunition a1 = (Ammunition) o1;
                Ammunition a2 = (Ammunition) o2;
                if (a1.getCost() > a2.getCost()) {
                    return 1;
                }
                if (a2.getCost() > a1.getCost()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void sortAmmunitionByWeight() {
        Collections.sort(ammunitions, new Comparator() {
            public int compare(Object o1, Object o2) {
                Ammunition a1 = (Ammunition) o1;
                Ammunition a2 = (Ammunition) o2;
                if (a1.getWeight() > a2.getWeight()) {
                    return 1;
                }
                if (a2.getWeight() > a1.getWeight()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public ArrayList<Ammunition> findAmmunitionByCost(int lLim, int rLim) {
        ArrayList<Ammunition> needed = new ArrayList<>();
        sortAmmunitionByCost();
        int lIndex = bSearch(ammunitions, lLim, 0, ammunitions.size());
        int rIndex = bSearch(ammunitions, rLim, 0, ammunitions.size());
        if (lIndex < 0) {
            lIndex = -1 * (lIndex + 1);
        }
        if (rIndex < 0) {
            rIndex = -1 * (rIndex + 1);
        }
        for (int i = 0; i < ammunitions.size(); i++) {
            if (i >= lIndex && i < rIndex) {
                needed.add(ammunitions.get(i));
            }
        }
        return needed;
    }

    private static int bSearch(ArrayList<Ammunition> list, Integer key,
                               int left, int right) {

        if (left >= right) {
            return -(left + 1);
        } else {
            int mid = (left + right) / 2;
            if (list.get(mid).getCost() == key) {
                int i = 1;
                while (true) {
                    if (mid - i >= 0) {
                        if (list.get(mid - i).getCost() == key) {
                            mid--;
                        } else {
                            return mid;
                        }
                    } else {
                        return mid;
                    }
                }

            }
            if (list.get(mid).getCost() > key) {
                right = mid;
            } else {
                left = mid + 1;
            }
            return bSearch(list, key, left, right);
        }
    }

    public int summAmmun(){
        int summ = 0;
        for (Ammunition ammun: ammunitions){
            summ += ammun.getCost();
        }
        return summ;
    }

    @Override
    public String toString() {
        StringBuilder knightDescription = new StringBuilder(super.toString() + " Title: " + title + ".");
        if (!ammunitions.isEmpty()) {
            knightDescription.append("\n" + "----------AMMUNITIONS----------");
            for (Ammunition ammunition : ammunitions) {
                knightDescription.append(new StringBuilder(ammunition.toString()));
            }
        }
        return new String(knightDescription);
    }
}

