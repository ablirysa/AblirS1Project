import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Wordle!");
        System.out.print("What's your name? ");
        String name = scan.nextLine();
        System.out.print("What level do you want (1 to 3)? ");
        int mode = scan.nextInt();

        Wordle game1 = new Wordle(name, mode);

        // NOT GIVING TIME TO TYPE IN INPUT
    }
}