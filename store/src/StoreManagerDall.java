import java.sql.*;
import java.util.Scanner;

public class StoreManagerDall implements IRepository<StoreManager>{
    @Override
    public void add(StoreManager entity) throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection connection = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        ResultSet resultSet;
        try {
            connection=dataBaseHelper.getConnection();
            System.out.println("Enter brand :");
            String newBrand = in.next();
            System.out.println("Enter price :");
            int newPrice = in.nextInt();
            String mySql= "INSERT INTO store (brand, price ) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(mySql);
            statement.setString(1,newBrand);
            statement.setString(2,String.valueOf(newPrice));
            statement.executeUpdate();
            System.out.println("A new user was inserted successfully!");
        }catch (SQLException exception) {
            dataBaseHelper.showErrorMassage(exception);
        } finally {
            connection.close();
        }
    }

    @Override
    public void delete(StoreManager entity) throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection connection = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = dataBaseHelper.getConnection();
            System.out.println("Enter id :");
            int selectId= in.nextInt();
            String mySql = "delete from store where  id=?";
            statement = connection.prepareStatement(mySql);
            statement.setString(1,String.valueOf(selectId));
            statement.executeUpdate();

            System.out.println("A user was deleted successfully!");

        }catch (SQLException exception) {
            dataBaseHelper.showErrorMassage(exception);
        } finally {

            connection.close();
        }
    }

    @Override
    public void update(StoreManager entity) throws SQLException {
        Connection connection = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            Scanner in = new Scanner(System.in);
            connection = dataBaseHelper.getConnection();
            System.out.println("Enter brand :");
            String selectBrand = in.next();
            System.out.println("Enter new price :");
            int newPrice = in.nextInt();
            String mySql = "update store set price = ? where brand = ?";
            statement = connection.prepareStatement(mySql);
            statement.setString(1,String.valueOf(newPrice) );
            statement.setString(2, selectBrand);
            statement.executeUpdate();
            System.out.println("A new user was update successfully!");
        } catch (SQLException exception) {
            dataBaseHelper.showErrorMassage(exception);
        } finally {

            connection.close();
        }
    }

    @Override
    public void list(StoreManager entity) throws SQLException {
        Connection connection = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dataBaseHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id,brand,price from store");
            while (resultSet.next()){
                System.out.println("İD = "+resultSet.getString("id")+"  "+"Brand = "+resultSet.getString("brand")+" "+"Price = "+resultSet.getString("price")+"$");
            }

        }catch (SQLException exception) {
            dataBaseHelper.showErrorMassage(exception);
        } finally {
            connection.close();
        }
    }

    @Override
    public void cart(StoreManager entity) throws SQLException {
        Connection connection = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        Statement statement = null;
        ResultSet resultSet ;
        try {
            Scanner in = new Scanner(System.in);
            connection= dataBaseHelper.getConnection();
            statement = connection.createStatement();
            System.out.println("Enter id :");
            int selectid = in.nextInt();

            resultSet = statement.executeQuery("SELECT price from store.store where id = \""+selectid+"\";");
            while (resultSet.next()){
                System.out.println("Price of the product: "+resultSet.getString("price")+"$");
            }
        }catch (SQLException exception) {
            dataBaseHelper.showErrorMassage(exception);
        } finally {
            assert connection != null;
            connection.close();
        }
    }
}
