// Klasa książki – dziedziczy po Pozycja
// Ma autora i informację, czy jest dostępna

public class Ksiazka extends Pozycja {
    private String autor;
    private boolean dostepna = true;

    public Ksiazka(String tytul, String autor) {
        super(tytul);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public boolean czyDostepna() {
        return dostepna;
    }

    public void wypozycz() {
        dostepna = false;
    }

    public void zwroc() {
        dostepna = true;
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("Tytuł: " + getTytul() + ", Autor: " + autor);
    }

    // Pokazuje książkę w formacie: tytuł - autor (dostępna/wypożyczona)
    @Override
    public String toString() {
        return getTytul() + " - " + autor + (dostepna ? " (dostępna)" : " (wypożyczona)");
    }
}
