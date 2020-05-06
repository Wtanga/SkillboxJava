import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

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
                    Files.copy(inputStream, new File(url.getPath()).toPath());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.out.println("Проблема при загрузке страницы");
        }
    }

}
