import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import core.*;
import org.jsoup.select.Elements;

import java.util.*;

public class Main {
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static List<Line> linesList = new ArrayList<>();
    public static Map<String, Station> metroMap = new LinkedHashMap<>();

    public static void main(String[] args)  {
        String metro = "https://www.moscowmap.ru/metro.html#lines";
        try {
            Document doc = Jsoup.connect(metro).maxBodySize(0).get();
            Elements namesOfLines = doc.getElementsByClass("js-metro-line");
            namesOfLines.forEach(el -> {
                linesList.add(new Line(el.attr("data-line"), el.text()));
            });

            Elements namesOfStations = doc.getElementsByClass("js-metro-stations");
            namesOfStations.forEach(el -> {
                el.children().forEach(element -> {
                    metroMap.put(el.attr("data-line"),
                           new Station(element.getElementsByClass("name").text()));
                });
            });
        } catch (IOException e) {
            System.out.println("Проблема при загрузке страницы");
        }

        File path = new File("src/main/resources/map.json");
        try {
            objectMapper.writeValue(path, metroMap);
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }
}


