import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String lenta = "https://lenta.ru/";
        try {
            Document doc = Jsoup.connect(lenta).maxBodySize(0).get();

            doc.select("img").forEach(e -> {
                URL url = null;
                try {
                    url = new URL(e.attr("src"));
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
                InputStream inputStream = null;
                try {
                    inputStream = url.openStream();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    Path temp = Paths.get("");
                    Files.copy(inputStream, new File(temp.toAbsolutePath().toString() + url.getPath()).toPath());
                    inputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.out.println("Проблема при загрузке страницы");
        }

    }

}
