import java.util.InputMismatchException;
import java.util.Scanner;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

 class ExceptionHandler {

    public static int divideNumbers(int a, int b) {
        if (b == 0) {

            throw new ArithmeticException("Nie można dzielić przez zero.");
        }

        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Podaj pierwszą liczbę: ");
            int a = scanner.nextInt();

            System.out.print("Podaj drugą liczbę: ");
            int b = scanner.nextInt();

            if (a < 0 || b < 0) {
                throw new NegativeNumberException("Liczby nie moga byc ujemne");
            }

            int result = divideNumbers(a, b);
            System.out.println("Wynik dzielenia: " + result);
        } catch (ArithmeticException | InputMismatchException e) {

            System.out.println("Błąd: " + e.getMessage());
        } catch (NegativeNumberException e) {

            System.out.println("Błąd: " + e.getMessage());

        } finally {
            scanner.close();

            System.out.println("Zakończono działanie programu.")
            ;
        }
    }
}
