import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String staffFile = "data/movementList.csv";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Operation> operations = loadStaffFromFile();
        System.out.println(operations.get(85).getLoss());

    }
    private static ArrayList<Operation> loadStaffFromFile() {
        ArrayList<Operation> operations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split(",");
                if(line.contains("\"")){
                    fragments[7] = (fragments[7] + "." + fragments[8]);
                    fragments[7] = fragments[7].replace("\"", "");
                    fragments[8] = "";

                }
                if (fragments.length != 8 && !fragments[8].equals("")) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                operations.add(new Operation(
                        (new SimpleDateFormat(dateFormat)).parse(fragments[3]),
                        fragments[5],
                        Double.parseDouble(fragments[6]),
                        Double.parseDouble(fragments[7])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return operations;
    }
}
