import java.io.File;
import java.util.Scanner;

public class Main {

    private static final int KB_MULTIPLIER = 1024;
    private static final int MB_MULTIPLIER = 1024 * 1024;
    private static final int GB_MULTIPLIER = 1024 * 1024 * 1024;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input path");
        String path = scanner.nextLine();

        File folder = new File(path);
        if(folder.isDirectory()) {
            System.out.println(folder.length() + " - bytes");
            System.out.println(folder.length() / KB_MULTIPLIER + " - kilobytes");
            System.out.println(folder.length() / MB_MULTIPLIER + " - megabytes");
            System.out.println(folder.length() / GB_MULTIPLIER + " - gigabytes");
        } else {
            System.out.println("Invalid path");
        }
    }
}
