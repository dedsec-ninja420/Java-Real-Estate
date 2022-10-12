
public class Estate {
    int id;
    String type;
    int price;
    boolean toSell;

    Estate(int id, String type, int price, boolean toSell) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.toSell = toSell;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String isForSale() {
        if (toSell == true) {
            return "For sale.";
        } else {
            return "For rent.";
        }
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "; Type: " + getType() + "; Price: " + getPrice() + "$; Contract: "
                + isForSale()
                + "\n";
    }

    public String toCsv() {
        return this.id + ";" + this.type + ";" + this.price + ";" + this.toSell + ";\n";
    }

}
