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
        String metro = "https://www.moscowmap.ru/metro.html#lines";
        try {
            Document doc = Jsoup.connect(metro).maxBodySize(0).get();

            doc.select("span.name")
                    .forEach(element -> {
                        System.out.println(element.text());
                        try {
                            Document doc1 = Jsoup.connect(metro).maxBodySize(0).get();
                            doc1.select("span").forEach(element1 -> {
                                System.out.println(element.text());
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            doc.select("span[data-line]")
                    .forEach(element -> {
                        System.out.println(element.text());
                    });
        } catch (IOException e) {
            System.out.println("Проблема при загрузке страницы");
        }
    }
}
