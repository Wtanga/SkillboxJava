package core;

import java.util.ArrayList;
import java.util.List;

public class Line {
    String number;
    String lineName;
    private List<Station> stations;

    public Line(String number, String name)
    {
        this.number = number;
        this.lineName = name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getLineName()
    {
        return lineName;
    }

}
