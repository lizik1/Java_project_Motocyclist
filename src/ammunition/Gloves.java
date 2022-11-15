package ammunition;

public class Gloves extends Ammunition {

    private String name = "NoName";
    private String size;

    public Gloves(String size, int cost, int weight) {
        super(cost, weight);
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String noname = "";
        if (!name.equals("NoName")) {
            noname = "Name: " + name + ". ";
        }
        return "\n" + "#Gloves." + noname + "Size: " + size + ". " + super.toString();
    }
}
