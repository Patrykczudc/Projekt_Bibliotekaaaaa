// Główna klasa uruchamiająca aplikację
// Pokazuje menu i reaguje na wybory użytkownika

import java.util.Scanner;

public class BibliotekaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteka biblioteka = new Biblioteka();
        // Dodanie książki bez ingerencji użytkownika
        biblioteka.dodajKsiazke("Bracia Lwie Serce", "Astrid Lindgren");

        System.out.print("Podaj swoje imię: ");
        String imie = scanner.nextLine();
        Uzytkownik uzytkownik = new Uzytkownik(imie);

        int wybor = 0;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dodaj książkę");
            System.out.println("2. Wyświetl książki");
            System.out.println("3. Wypożycz książkę");
            System.out.println("4. Zwróć książkę");
            System.out.println("5. Usuń książkę");
            System.out.println("6. Szukaj książki");
            System.out.println("7. Zmień tytuł książki");
            System.out.println("8. Moje wypożyczone książki");
            System.out.println("9. Wyjście");
            System.out.print("Wybierz opcję: ");

            try {
                wybor = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy wybór.");
                continue;
            }

            switch (wybor) {
                case 1 -> biblioteka.dodajKsiazke(scanner);
                case 2 -> biblioteka.wyswietlKsiazki();
                case 3 -> biblioteka.wypozyczKsiazke(scanner, uzytkownik);
                case 4 -> biblioteka.zwrocKsiazke(scanner);
                case 5 -> biblioteka.usunKsiazke(scanner);
                case 6 -> biblioteka.szukajKsiazke(scanner);
                case 7 -> biblioteka.zmienTytulKsiazki(scanner);
                case 8 -> uzytkownik.wyswietlWypozyczoneKsiazki();
                case 9 -> System.out.println("Zamykanie programu...");
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        } while (wybor != 9);
    }
}
