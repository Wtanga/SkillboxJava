import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static String staffFile = "data/movementList.csv";

    public static void main(String[] args) {
        ArrayList<Operation> operations = loadStaffFromFile();
        Double totalIncome = 0.0;
        Double totalLoss = 0.0;
        Double balance;
        for(int i = 0; i < operations.size(); i++){
            totalIncome += operations.get(i).getIncome();
            totalLoss += operations.get(i).getLoss();
        }
        balance = totalIncome - totalLoss;
        System.out.println(totalIncome);
        System.out.println(totalLoss);
        System.out.println(balance);
        operations.stream()
                .collect(Collectors.groupingBy(Operation::getDescription,
                        Collectors.mapping(Summary::fromTransaction, Collectors.reducing(Summary::merge))
        )).forEach((s, summ) -> System.out.println(s + "\t" + summ.income + "\t" + summ.withdraw));

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
    public static class Summary {
        static double income;
        static double withdraw;

        Summary(double income, double withdraw) {
            this.income = income;
            this.withdraw = withdraw;
        }

        static double getIncome (){
            return income;
        }

        static double getWithdraw (){
            return income;
        }

        // сложение сумм
        static Summary merge(Summary s1, Summary s2) {
            return new Summary(s1.income + s2.income, s1.withdraw + s2.withdraw);
        }
        // mapper - конвертация из Transaction
        static Summary fromTransaction(Operation t) {
            return new Summary(t.getIncome(), t.getLoss());
        }

    }
}
