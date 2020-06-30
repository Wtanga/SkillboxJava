package core;

public class Station {
    Line line;
    String StationName;

    public Station(String name, Line line)
    {
        this.StationName = name;
        this.line = line;
    }

    public Line getLine()
    {
        return line;
    }

    public String getStationName()
    {
        return StationName;
    }
}
