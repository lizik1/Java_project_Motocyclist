package ammunition;

public class Helmet extends Ammunition {

    private String name = "NoName";
    private String sex;

    public Helmet(String sex, int cost, int weight) {
        super(cost, weight);
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String noname = "";
        if (!name.equals("NoName")) {
            noname = "Name: " + name + ". ";
        }
        return "\n" + "#Helmet." + noname + "Sex: " + sex + ". " + super.toString();
    }
}
