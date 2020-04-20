import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class Main {
    public static void main(String[] args) throws IOException {
        Path originalPath = Paths.get("example");
        Path copiedPath = Paths.get("exampleCopied/");
        Files.walk(originalPath)
                .forEach(file -> {
                    Path currentPath = Paths.get(file.toAbsolutePath().toString());
                    if (Files.isDirectory(file)) {
                        try {
                            Files.createDirectory(copiedPath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {

                        try {
                            Path temp = Paths.get("exampleCopied/" + originalPath.toAbsolutePath().relativize(currentPath).toString());
                            Files.copy(currentPath, temp, StandardCopyOption.REPLACE_EXISTING);// копируем файл в папку относительно destination
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}