
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var object = scanner.nextLine();
        ArrayList<String> blocks = new ArrayList<>();
        char[] charArray = object.toCharArray();
        for (int i = 0; i < object.length(); i++) {
            String str = String.valueOf(charArray[i]);
            while (blocks.contains(str)) {
                i++;
                str = String.valueOf(charArray[i]);
            }
            blocks.add(str);
        }
        for (String block : blocks){
            System.out.println(block);
        }
    }
}

