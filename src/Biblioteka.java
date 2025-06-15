// Zarządza listą książek – dodawanie, usuwanie, wypożyczanie itd.

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {
    private ArrayList<Ksiazka> ksiazki = new ArrayList<>();

    // Dodawanie nowej książki do biblioteki
    public void dodajKsiazke(Scanner scanner) {
        System.out.print("Podaj tytuł książki: ");
        String tytul = scanner.nextLine();
        System.out.print("Podaj autora książki: ");
        String autor = scanner.nextLine();
        ksiazki.add(new Ksiazka(tytul, autor));
        System.out.println("Dodano książkę.");
    }

    // Przeciążona metoda: dodaje książkę bez ingerencji użytkownika
    public void dodajKsiazke(String tytul, String autor) {
        ksiazki.add(new Ksiazka(tytul, autor));
        System.out.println("Dodano książkę przez przeciążoną metodę.");
    }

    public void wyswietlKsiazki() {
        if (ksiazki.isEmpty()) {
            System.out.println("Brak książek w bibliotece.");
            return;
        }
        for (int i = 0; i < ksiazki.size(); i++) {
            System.out.println(i + ". " + ksiazki.get(i));
        }
    }

    // Wypożyczenie książki – zmiana jej statusu na niedostępną
    public void wypozyczKsiazke(Scanner scanner, Uzytkownik uzytkownik) {
        wyswietlKsiazki();
        System.out.print("Podaj numer książki do wypożyczenia: ");
        try {
            int indeks = Integer.parseInt(scanner.nextLine());
            Ksiazka ksiazka = ksiazki.get(indeks);
            if (ksiazka.czyDostepna()) {
                ksiazka.wypozycz();
                uzytkownik.wypozyczKsiazke(ksiazka);
                System.out.println("Wypożyczono książkę.");
            } else {
                System.out.println("Książka jest już wypożyczona.");
            }
        } catch (Exception e) {
            System.out.println("Nieprawidłowy indeks.");
        }
    }

    public void zwrocKsiazke(Scanner scanner) {
        wyswietlKsiazki();
        System.out.print("Podaj numer książki do zwrotu: ");
        try {
            int indeks = Integer.parseInt(scanner.nextLine());
            Ksiazka ksiazka = ksiazki.get(indeks);
            if (!ksiazka.czyDostepna()) {
                ksiazka.zwroc();
                System.out.println("Zwrócono książkę.");
            } else {
                System.out.println("Ta książka nie jest wypożyczona.");
            }
        } catch (Exception e) {
            System.out.println("Nieprawidłowy indeks.");
        }
    }

    public void usunKsiazke(Scanner scanner) {
        wyswietlKsiazki();
        System.out.print("Podaj numer książki do usunięcia: ");
        try {
            int indeks = Integer.parseInt(scanner.nextLine());
            Ksiazka ksiazka = ksiazki.get(indeks);
            if (!ksiazka.czyDostepna()) {
                System.out.println("Nie można usunąć książki, ponieważ jest wypożyczona.");
                return;
            }
            ksiazki.remove(indeks);
            System.out.println("Usunięto książkę.");
        } catch (Exception e) {
            System.out.println("Nieprawidłowy indeks.");
        }
    }

    // Szuka książki po tytule lub autorze
    public void szukajKsiazke(Scanner scanner) {
        System.out.print("Wpisz tytuł lub autora: ");
        String fraza = scanner.nextLine().toLowerCase();
        for (Ksiazka ksiazka : ksiazki) {
            if (ksiazka.getTytul().toLowerCase().contains(fraza) ||
                    ksiazka.getAutor().toLowerCase().contains(fraza)) {
                System.out.println(ksiazka);
            }
        }
    }

    public void zmienTytulKsiazki(Scanner scanner) {
        wyswietlKsiazki();
        System.out.print("Podaj numer książki do zmiany tytułu: ");
        try {
            int indeks = Integer.parseInt(scanner.nextLine());
            System.out.print("Podaj nowy tytuł: ");
            String nowyTytul = scanner.nextLine();
            ksiazki.get(indeks).setTytul(nowyTytul);
            System.out.println("Zmieniono tytuł.");
        } catch (Exception e) {
            System.out.println("Nieprawidłowy indeks.");
        }
    }
}
