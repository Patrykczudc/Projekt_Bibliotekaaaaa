// Reprezentuje osobę, która wypożycza książki
//Czytelnik może mieć maksymalnie 5 książek wypożyczonych jednocześnie.

public class Uzytkownik {
    private String imie;
    private Ksiazka[] wypozyczoneKsiazki = new Ksiazka[5];
    private int licznik = 0;

    public Uzytkownik(String imie) {
        this.imie = imie;
    }

    public void wypozyczKsiazke(Ksiazka ksiazka) {
        if (licznik < wypozyczoneKsiazki.length) {
            wypozyczoneKsiazki[licznik++] = ksiazka;
        } else {
            System.out.println("Osiągnięto limit wypożyczeń.");
        }
    }

    public void wyswietlWypozyczoneKsiazki() {
        System.out.println("Wypożyczone książki przez " + imie + ":");
        for (int i = 0; i < licznik; i++) {
            System.out.println("- " + wypozyczoneKsiazki[i]);
        }
    }
}
