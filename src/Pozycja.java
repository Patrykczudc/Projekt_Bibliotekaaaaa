// Klasa bazowa – zawiera tytuł i metodę do jego wyświetlania

public class Pozycja {
    private String tytul;

    public Pozycja(String tytul) {
        this.tytul = tytul;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void wyswietlInfo() {
        System.out.println("Tytuł: " + tytul);
    }
}
