import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import core.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static List<Station> stationsList = new ArrayList<>();

    public static void main(String[] args)  {
        String metro = "https://www.moscowmap.ru/metro.html#lines";
        try {
            Document doc = Jsoup.connect(metro).maxBodySize(0).get();

            doc.select("span[data-line]")
                    .forEach(line -> {
                        doc.select("span.name").forEach(station -> {
                           // stations.put(line.text(), station.text());
                            stationsList.add(new Station(line.text(),
                                    new Line(station.attr("data-line"), station.text())));
                        });
                    });
        } catch (IOException e) {
            System.out.println("Проблема при загрузке страницы");
        }

        File path = new File("src/main/resources/map.json");
        try {
            objectMapper.writeValue(path, stationsList);
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }
}


