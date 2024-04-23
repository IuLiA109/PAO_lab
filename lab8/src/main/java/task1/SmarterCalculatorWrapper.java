package task1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import smartCalculator.CalculationRequest;
import smartCalculator.calculatorResult.CalculationResult;

public class SmarterCalculatorWrapper {
    private final String url;
    private final String username;
    private final String password;

    private Connection connection;

    public SmarterCalculatorWrapper(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void insertResult(CalculationRequest request, CalculationResult result) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            CalculationRequest.RequestType operationType = request.getRequestType();

            String sql = "INSERT INTO smarterCalculatorResults(operation_type, left_operand, right_operand, operation, result) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, operationType.name());
                statement.setString(2, String.valueOf(request.getLeftOperand()));
                statement.setString(3, String.valueOf(request.getRightOperand()));
                statement.setString(4, request.getOperation());
                statement.setString(5, String.valueOf(result.computeResult()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save result", e);
        }
    }
}
