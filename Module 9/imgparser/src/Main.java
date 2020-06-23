import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        String lenta = "https://lenta.ru/";
        try {
            Document doc = Jsoup.connect(lenta).maxBodySize(0).get();
            doc.select("img")
                    .stream()
                    .filter(x -> x.attr("src")
                            .startsWith("https"))
                    .forEach(e -> {
                        try {
                            URL url = new URL(e.attr("src"));
                            InputStream in = new URL(url.toString()).openStream();
                            Path temp = Paths.get("");
                            Files.createDirectories(Paths.get(temp.toAbsolutePath() + url.getPath()));
                            Files.copy(in, Paths.get(temp.toAbsolutePath() + url.getPath().replace(" //", "")), StandardCopyOption.REPLACE_EXISTING);
                            in.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            System.out.println("Проблема при загрузке страницы");
        }

    }

}
