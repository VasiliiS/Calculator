import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String string = scanner.nextLine();
        String arab[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        String rim[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
        String rimsolution[] = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String exp[] = {"+", "-", "*", "/"};
        int arab1 = 0;
        int arab2 = 0;
        int rim1 = 0;
        int  rim2 = 0;
        int solution = 0;
        String sing = "";
        int space = 0;
        int equalityarab = 0;
        int equalityrim = 0;

        for (int i = 0; i < arab.length; i++) {
            if (string.startsWith(arab[i]) == true)
                arab1 = i + 1;
        }
        for (int i = 0; i < arab.length; i++) {
            if (string.endsWith(arab[i]) == true)
                arab2 = i + 1;
        }
        for (int i = 0; i < rim.length; i++) {
            if (string.startsWith(rim[i]) == true)
                rim1 = i + 1;
        }

        for (int i = 0; i < rim.length; i++) {
            if (string.endsWith(rim[i]) == true)
                rim2 = i + 1;
        }

        for (int i = 1; i < string.length(); i++) {
            if (string.regionMatches(i, "IV", 0, 2) == true) {
                rim2 = 4;
            } else if (string.regionMatches(i, "IX", 0, 2) == true) {
                rim2 = 9;
            }
        }

        for (int i = 0; i < exp.length; i++) {
            for (int j = 1; j < string.length(); j++) {
                if (string.regionMatches(j, exp[i], 0, 1) == true) {
                    sing = exp[i];
                }
            }
        }

        if (sing.equals("") == true ) {
            System.out.println("Введены не корректные данные");
            System.exit(0);
        }

        for (int i = 0; i < string.length(); i++) {
            if (string.regionMatches(i, " ", 0, 1) == true)
                space++;
        }

        if (arab1 > 0 & arab2 > 0)
            equalityarab = space + arab[arab1 - 1].length() + arab[arab2 - 1].length() + 1;

        if (rim1 > 0 & rim2 > 0)
            equalityrim = space + rim[rim1 - 1].length() + rim[rim2 - 1].length() + 1;

        if (equalityarab != string.length() & equalityrim != string.length()) {
            System.out.println("Введены не корректные данные");
            System.exit(0);
        }

        if ((arab1 > 0 & arab1 < 11) & (arab2 > 0 & arab2 < 11)) {
            switch (sing) {
                case "+":
                    System.out.println(arab1 + arab2);
                    break;
                case "-":
                    System.out.println(arab1 - arab2);
                    break;
                case "*":
                    System.out.println(arab1 * arab2);
                    break;
                case "/":
                    System.out.println(arab1 / arab2);
                    break;
            }
        } else if ((rim1 > 0 & rim1 < 11) & (rim2 > 0 & rim2 < 11)) {
            switch (sing) {
                case "+":
                    System.out.println(rimsolution[rim1 + rim2]);
                    break;
                case "-":
                    if (rim1 - rim2 < 0) {
                        System.out.println("Введены не корректные данные");
                        System.exit(0);
                    } else System.out.println(rimsolution[rim1 - rim2]);
                    break;
                case "*":
                    System.out.println(rimsolution[rim1 * rim2]);
                    break;
                case "/":
                    System.out.println(rimsolution[rim1 / rim2]);
                    break;
            }

        } else {
            System.out.println("Введены не корректные данные");
            System.exit(0);
        }
    }
}
