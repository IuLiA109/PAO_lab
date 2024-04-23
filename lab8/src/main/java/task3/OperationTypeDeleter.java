package task3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class OperationTypeDeleter {
    private final String url;
    private final String username;
    private final String password;

    public OperationTypeDeleter(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void deleteOperation(String operationType) {
        String sql = "DELETE FROM smarterCalculatorResults WHERE operation_type = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
             statement.setString(1, operationType);
             statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
