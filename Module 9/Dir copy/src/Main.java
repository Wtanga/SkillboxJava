import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws Exception {
        Path originalPath = Paths.get("example/");
        Path copiedPath = Paths.get("exampleCopied/");
        Files.walk(originalPath)
                .forEach(file -> {
                    if (Files.isDirectory(file)) {
                        File folder = new File(copiedPath.getFileName().toString());
                        folder.mkdir();
                    } else {
                        Path currentPath = Paths.get(file.toAbsolutePath().toString());
                        try {
                            Files.copy(currentPath, copiedPath, StandardCopyOption.REPLACE_EXISTING);// копируем файл в папку относительно destination
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}