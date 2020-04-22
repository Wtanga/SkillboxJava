import java.util.Date;

public class Operation {
    private String typeOfAccount;
    private String numberOfAccount;
    private String value;
    private Date dateOfOperation;
    private String wiringReference;
    private String operationDescription;
    private Double income;
    private Double loss;

    public Operation(String operationDescription, Double income, Double loss) {
        this.operationDescription = operationDescription;
        this.income = income;
        this.loss = loss;
    }

    public Double getIncome() {
        return income;
    }

    public Double getLoss() {
        return loss;
    }

    public String getDescription() {
        return operationDescription;
    }

    private static class Summary {
        double income;
        double withdraw;

        Summary(double income, double withdraw) {
            this.income = income;
            this.withdraw = withdraw;
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

