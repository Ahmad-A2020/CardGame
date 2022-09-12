import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plz enter the string value:");
        String input= scanner.nextLine();

        PermutnGenerator(input, "");


    }
    static void PermutnGenerator(String value, String com)
    {

        if (value.length() == 0) {
            System.out.print(com + " ");
            return;
        }

        for (int i = 0; i < value.length(); i++) {

            char cha = value.charAt(i);

            String parti = value.substring(0, i) +
                    value.substring(i + 1);

            // Recursive call
            PermutnGenerator(parti, com + cha);
        }
    }
}
