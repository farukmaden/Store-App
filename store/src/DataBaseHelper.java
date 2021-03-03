import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHelper {
    private String userName = "root";
    private String password = "farukmdn80";
    private String dataBaseUrl ="jdbc:mysql://localhost:3306/store?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dataBaseUrl,userName,password);
    }

    public void showErrorMassage(SQLException exception){
        System.out.println("error : " + exception.getMessage());
        System.out.println("Error code : " + exception.getErrorCode());
    }
}
