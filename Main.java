
// Metodo toString() per tenere traccia del profitto dell'azienda e delle case a disposizione, distinguendo affitto e vendita X
// Gestire profitto dell'azienda in base a una percentuale a seguito di una vendita o un affitto X
// Funzioni inserimento proprietà e vendita proprietà X
// Funzione ricerca per tipologia e prezzo massimo desiderato X
// Lettura/scrittura su .csv X

public class Main {
    public static void main(String[] args) {
        String[] paths = { "estates.csv", "estates2.csv", "estates3.csv" };
        try {
            // Lettura file .csv
            Agency a = new Agency(paths);
            a.readFile();
            // Case a disposizione dell'agenzia
            System.out.println(a.toString());
            System.out.println(a.getEstates());
            // Ricerca per tipo "house"
            System.out.println("\nElenco case:\n");
            a.searchByType("House");
            // Ricerca per tipo "flat"
            System.out.println("Elenco appartamenti:\n");
            a.searchByType("Flat");
            // Ricerca per prezzo (Massimo 600 euro)
            System.out.println("Ricerca per prezzo (Massimo 600):\n");
            a.searchByPrice(600);
            // Creazione nuova agenzia e aggiunta nuove proprietà
            Agency b = new Agency(0, 0, 0, 0);
            Estate e = new Estate(123456, "House", 250000, true);
            Estate f = new Estate(654321, "Flat", 400, false);
            b.addEstates(e);
            b.addEstates(f);
            System.out.println("Azienda con due proprietà disponibili:\n");
            System.out.println(b.toString());
            // Vendità con un profitto del 10% sul prezzo totale;
            b.sellEstate(e);
            System.out.println("\nVendita proprietà 1:\n");
            System.out.println(b.toString());
            // Affitto con un profitto del 5% sul prezzo totale;
            b.sellEstate(f);
            System.out.println("\nVendita proprietà 2:\n");
            System.out.println(b.toString());
            // Scrittura file .csv
            b.addEstates(e);
            b.addEstates(f);
            b.saveEstates("sample.csv");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
