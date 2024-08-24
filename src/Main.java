import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 1 + 3):");
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) throw new Exception("Неверный формат!");

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) throw new Exception("Число вне диапазона!");

        return switch (parts[1]) {
            case "+" -> Integer.toString(a + b);
            case "-" -> Integer.toString(a - b);
            case "*" -> Integer.toString(a * b);
            case "/" -> {
                if (b == 0) throw new Exception("Деление на ноль!");
                yield Integer.toString(a / b);
            }
            default -> throw new Exception("Неверный оператор!");
        };
    }
}