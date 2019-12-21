import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static TreeMap<String, String> directory = new TreeMap<>();

    public static void main(String[] args) {
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        while (exit) {
            System.out.println("Введите номер или имя");
            String same = scanner.nextLine();
            if (same.equals("LIST")) {
                printDirectory();
            } else if (same.matches("^^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{3,10}$") == true) {
                String phone = same;
                if (directory.containsValue(phone)) {
                    printNameByNumber(phone);
                } else {
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();
                    directory.put(name, same);
                }
            } else if (same.matches("^^[а-яА-ЯёЁa-zA-Z]+$") == true) {
                String name = same;
                if (directory.containsKey(name)) {
                    printPhoneByName(name);
                } else {
                    numberCheck(name);
                }
            } else {
                System.out.println("Неверный формат ввода");
            }
            if (same.equals("0")) {
                exit = false;
            }
        }
    }


    private static void printDirectory() {
        for (String key : directory.keySet()) {
            System.out.println(key + " +=> " + directory.get(key));
        }
    }

    private static void printPhoneByName(String key) {
        System.out.println(directory.get(key));
    }

    private static void printNameByNumber(String value) {
        for (String key : directory.keySet()) {
            if (directory.get(key).equals(value)) {
                System.out.println(key);
            }
        }
    }

    private static void numberCheck(String same) {
        boolean exit = false;
        String number;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("Введите цифры: ");
            number = scanner.nextLine();
            if (number.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{3,10}$")) {
                directory.put(same, number);
                exit = true;
            }
        }
    }
}
