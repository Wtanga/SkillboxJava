package core;


import java.util.List;

public class Line {
    String number;
    String lineName;

    public Line() {
    }

    public Line(String number, String name) {
        this.number = number;
        this.lineName = name;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLineName() {
        return lineName;
    }

    public String getNumber() {
        return number;
    }
}
