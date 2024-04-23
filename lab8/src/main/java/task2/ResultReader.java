package task2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import smartCalculator.CalculationRequest;
import smartCalculator.calculatorResult.BooleanCalculationResult;
import smartCalculator.calculatorResult.CalculationResult;
import smartCalculator.calculatorResult.DoubleCalculationResult;
import smartCalculator.calculatorResult.IntegerCalculationResult;

public class ResultReader {
    private final String url;
    private final String username;
    private final String password;

    public ResultReader(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<CalculationResult> readResults() {
        List<CalculationResult> results = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT operation_type, left_operand, right_operand, operation, result FROM smarterCalculatorResults";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String operationType = resultSet.getString("operation_type");
                        String leftOperand = resultSet.getString("left_operand");
                        String rightOperand = resultSet.getString("right_operand");
                        String operation = resultSet.getString("operation");
                        String result = resultSet.getString("result");

                        CalculationRequest request = new CalculationRequest(leftOperand, rightOperand, operation);
                        CalculationResult calculationResult = null;
                        if(operationType.equals("Integer"))
                            calculationResult = new IntegerCalculationResult(request);
                        if(operationType.equals("Double"))
                            calculationResult = new DoubleCalculationResult(request);
                        if(operationType.equals("Boolean"))
                            calculationResult = new BooleanCalculationResult(request);
                        results.add(calculationResult);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
