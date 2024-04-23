package task4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DuplicateDeleter {
    private final String url;
    private final String username;
    private final String password;

    public DuplicateDeleter(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void deleteDuplicate() {

        String sql = "DELETE FROM smarterCalculatorResults" +
                "WHERE operation_type = ?" +
                "  AND left_operand = ?" +
                "  AND right_operand = ?" +
                "  AND operation = ?" +
                "  AND result = ?" +
                ";";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
