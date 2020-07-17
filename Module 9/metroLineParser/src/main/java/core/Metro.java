package core;

import java.util.List;
import java.util.Map;

public class Metro {
    private Map<String, List<Station>> stations;
    private List<Line> lines;

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Map<String, List<Station>> getStations() {
        return stations;
    }

    public void setStations(Map<String, List<Station>> stations) {
        this.stations = stations;
    }
}
