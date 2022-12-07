import java.sql.*;


public class DataBase {
    String DB_URL = "jdbc:mysql://localhost/myfirstdb?serverTimezone=UTC"; //"jdbc:mysql://localhost:3306/mysql";
    String USERNAME = "root";
    String PASSWORD = "root";

    public void addUserToDataBase(String name, int arrowHours, int arrowMinuts, int cost) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO user (arrowHours, arrowMinuts, cost, name) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, arrowHours);
            preparedStatement.setInt(2, arrowMinuts);
            preparedStatement.setInt(3, cost);
            preparedStatement.setString(4, name);

            int addedRows = preparedStatement.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
