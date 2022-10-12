import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

public class Agency {
    public ArrayList<Estate> estates = new ArrayList<>();
    public int availableEstates, toRent, toSell = 0;
    public double income = 0;
    private String[] paths = {};

    Agency(int availableEstates, int toRent, int toSell, int income) {
        this.availableEstates = availableEstates;
        this.toRent = toRent;
        this.toSell = toSell;
        this.income = income;
    }

    public Agency(String[] paths) {
        this.paths = paths;
    }

    public void addEstates(Estate estate) {
        availableEstates += 1;
        if (estate.toSell) {
            toSell += 1;
        } else {
            toRent += 1;
        }
        estates.add(estate);
    }

    public void sellEstate(Estate estate) {
        availableEstates -= 1;
        if (estate.toSell) {
            toSell -= 1;
            income += (estate.price / 100) * 10;
        } else {
            toRent -= 1;
            income += (estate.price / 100) * 5;
        }
        estates.remove(estate);
    }

    public String searchByType(String textOfSearch) {
        Estate[] filteredEstates = new Estate[estates.size()];
        String response = "";
        for (int i = 0; i < this.estates.size(); i++) {
            Estate e = this.estates.get(i);
            if (e != null && (e.type.toLowerCase().contains(textOfSearch.toLowerCase()))) {
                filteredEstates[i] = e;
                response += this.estates.get(i).toString();
            }
        }
        System.out.println(response);
        return response;
    }

    public String searchByPrice(int userPrice) {
        Estate[] filteredEstates = new Estate[estates.size()];
        String response = "";
        for (int i = 0; i < this.estates.size(); i++) {
            Estate e = this.estates.get(i);
            if (e != null & e.price <= userPrice) {
                filteredEstates[i] = e;
                response += this.estates.get(i).toString();
            }
        }
        System.out.println(response);
        return response;
    }

    public double getIncome() {
        return this.income;
    }

    public int getAvailableEstates() {
        return this.availableEstates;
    }

    public int getToRent() {
        return this.toRent;
    }

    public int getToSell() {
        return this.toSell;
    }

    @Override
    public String toString() {
        return "Il guadagno totale dell'agenzia è pari a " + getIncome() + "€. Le proprietà disponibili sono "
                + getAvailableEstates() + ", di cui " + getToRent() + " disponibili in contratto di affitto e "
                + getToSell()
                + " disponibili in contratto di vendita.";
    }

    public void readFile() {
        for (String path : paths) {
            try {
                File f = new File(path);
                Scanner s = new Scanner(f);
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    try {
                        String[] items = line.split(";");
                        Estate e = new Estate(Integer.parseInt(items[0]), items[1], Integer.parseInt(items[2]),
                                Boolean.parseBoolean(items[3]));

                        addEstates(e);
                    } catch (Exception e) {
                    }
                }
                s.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void saveEstates(String pathF) {
        for (Estate estate : estates) {
            try {
                FileWriter f = new FileWriter(pathF, true);
                f.append(estate.toCsv());
                f.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public ArrayList<Estate> getEstates() {
        return estates;
    }
}