package core;

import java.util.ArrayList;
import java.util.List;

public class Station {
    String line;
    String StationName;
    private List<Station> stations;


    public Station(String name)
    {
        this.StationName = name;
        stations = new ArrayList<>();
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }

    public String getStationName()
    {
        return StationName;
    }
}
