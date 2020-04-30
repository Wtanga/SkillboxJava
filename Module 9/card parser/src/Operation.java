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


}

