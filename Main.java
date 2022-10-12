public class Main {
    public static void main(String[] args) {
        String[] paths = { "estates.csv", "estates2.csv", "estates3.csv" };
        try {
            // Reading from .csv
            Agency a = new Agency(paths);
            a.readFile();
            // Calling toString() method to display all properties owned by the agency
            System.out.println(a.toString());
            System.out.println(a.getEstates());
            // Searching by type "house"
            System.out.println("\nHouses:\n");
            a.searchByType("House");
            // Searching by type "flat"
            System.out.println("Flats:\n");
            a.searchByType("Flat");
            // Searching by price
            System.out.println("Search by price (600 max):\n");
            a.searchByPrice(600);
            // Creating a new agency and adding some properties to it 
            Agency b = new Agency(0, 0, 0, 0);
            Estate e = new Estate(123456, "House", 250000, true);
            Estate f = new Estate(654321, "Flat", 400, false);
            b.addEstates(e);
            b.addEstates(f);
            System.out.println("This agency owns two properties:\n");
            System.out.println(b.toString());
            // Selling property with a 10% profit;
            b.sellEstate(e);
            System.out.println("\nSelling property 1:\n");
            System.out.println(b.toString());
            // Renting property with a 5% profit;
            b.sellEstate(f);
            System.out.println("\nRenting property 2:\n");
            System.out.println(b.toString());
            // Writing everything on a new .csv file
            b.addEstates(e);
            b.addEstates(f);
            b.saveEstates("sample.csv"); // Your new file name here 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
