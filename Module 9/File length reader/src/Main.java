import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static final int KB_MULTIPLIER = 1024;
    private static final int MB_MULTIPLIER = 1024 * 1024;
    private static final int GB_MULTIPLIER = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input path");
        String path = scanner.nextLine();
        Path folder = Paths.get(path);
        System.out.println(Files.size(folder));
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();
        System.out.println(size + " - bytes");
        System.out.println((float) size / (float) KB_MULTIPLIER + " - kilobytes");
        System.out.println((float) size / (float) MB_MULTIPLIER + " - megabytes");
        System.out.println((float) size / (float) GB_MULTIPLIER + " - gigabytes");
    }
}

