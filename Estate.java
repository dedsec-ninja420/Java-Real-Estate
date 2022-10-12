
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
            return "In vendita.";
        } else {
            return "In affitto.";
        }
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "; Tipo: " + getType() + "; Prezzo: " + getPrice() + "€; Contratto: "
                + isForSale()
                + "\n";
    }

    public String toCsv() {
        return this.id + ";" + this.type + ";" + this.price + ";" + this.toSell + ";\n";
    }

}
