import java.util.*;

 class Konkurs {
    private Set<String> listaUczestnikow;
    private Queue<String> kolejka;
    private Map<String, Integer> numery;
    private Random generatorNumerow;

    public Konkurs() {
        listaUczestnikow = new HashSet<>();
        kolejka = new ArrayDeque<>();
        numery = new TreeMap<>();
        generatorNumerow = new Random();

    }

    public void dodajOsobe(String uczestnik) {
        if (listaUczestnikow.add(uczestnik)) {
            kolejka.add(uczestnik);
            numery.put(uczestnik, przydzielNumer());
            System.out.println("Dodano: " + uczestnik);


        } else {
            System.out.println("Uczestnik już istnieje: " + uczestnik);



        }
    }

    public void pokazUczestnikow() {

        System.out.println("Lista uczestników:");
        numery.forEach((uczestnik, numer) ->
                System.out.println(uczestnik + " - Numer: " + numer)


        );
    }

    public void usunOsobe(String uczestnik) {
        if (listaUczestnikow.remove(uczestnik)) {
            kolejka.remove(uczestnik);
            numery.remove(uczestnik);
            System.out.println("Usunięto: " + uczestnik);
        } else {


            System.out.println("Nie znaleziono: " + uczestnik);
        }
    }


    public void pokazNumer(String uczestnik) {
        if (numery.containsKey(uczestnik)) {
            System.out.println(uczestnik + " - Numer startowy: " + numery.get(uczestnik));
        }
        else {

            System.out.println("Nie znaleziono uczestnika: " + uczestnik);
        }
    }

    private int przydzielNumer() {
        return generatorNumerow.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Konkurs konkurs = new Konkurs();

        while (true) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1 - Dodaj uczestnika");
            System.out.println("2 - Wyświetl listę uczestników");
            System.out.println("3 - Usuń uczestnika");
            System.out.println("4 - Sprawdź numer startowy uczestnika");
            System.out.println("5 - Wyjście");
            System.out.print("Twój wybór: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    System.out.print("Podaj imię i nazwisko: ");
                    String nowyUczestnik = scanner.nextLine();
                    konkurs.dodajOsobe(nowyUczestnik);
                    break;

                case 2:
                    konkurs.pokazUczestnikow();
                    break;

                case 3:
                    System.out.print("Podaj imię i nazwisko do usunięcia: ");
                    String usun = scanner.nextLine();
                    konkurs.usunOsobe(usun);
                    break;
                case 4:
                    System.out.print("Podaj imię i nazwisko: ");
                    String uczestnik = scanner.nextLine();
                    konkurs.pokazNumer(uczestnik);
                    break;
                case 5:
                    System.out.println("Zakończono program.");

                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
            }
        }
    }
}
