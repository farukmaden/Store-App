import java.sql.SQLException;

public interface IRepository <T>{
    void add(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void list(T entity) throws SQLException;
    void cart(T entity) throws SQLException;
}
