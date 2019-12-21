import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static ArrayList<String> numbers = new ArrayList<>();
    private static HashSet<String> hash = new HashSet<>();
    private static TreeSet<String> tree = new TreeSet<>();

    public static void main(String[] args) {
        numberGenerate(numbers);
        System.out.print("Введите номер для поиска: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        binarySearch(search);
        directSearch(search);
        hashSearch(search);
        treeSearch(search);
    }

    public static void numberGenerate(ArrayList numbers) {
        String number;
        char[] letters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х',};
        for (int i = 1; i < 201; i++) {
            for (int j = 0; j < 12; j++)
                for (int k = 0; k < 12; k++)
                    for (int l = 0; l < 12; l++)
                        for (int m = 0; m < 10; m++) {
                            number = String.valueOf(i);
                            number = String.valueOf(letters[j]) + String.valueOf(m) + String.valueOf(m) + String.valueOf(m) + String.valueOf(letters[k]) + String.valueOf(letters[l]) + number;
                            numbers.add(number);
                        }
        }
        hash.addAll(numbers);
        tree.addAll(numbers);
    }

    public static void directSearch(String search) {
        long time = System.nanoTime();
        numbers.contains(search);
        System.out.println("Потраченное время при прямом поиске: " + (System.nanoTime() - time));
    }
    public static void binarySearch(String search){
        long time = System.nanoTime();
        Collections.binarySearch(numbers, search);
        System.out.println("Потраченное время при бинарном поиске: " + (System.nanoTime() - time));
    }
    public static void hashSearch(String search){
        long time = System.nanoTime();
        hash.contains(search);
        System.out.println("Потраченное время при хэш поиске поиске: " + (System.nanoTime() - time));
    }
    public static void treeSearch(String search){
        long time = System.nanoTime();
        tree.contains(search);
        System.out.println("Потраченное время при три поиске: " + (System.nanoTime() - time));
    }
}
// A999ВН111 АВЕКМНОРСТУХ