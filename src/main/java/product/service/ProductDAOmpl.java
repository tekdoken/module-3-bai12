package product.service;

import customer.model.Customer;
import product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOmpl implements IProductDAO {


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo20062?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product (id,name,price,quantity) value (?,?,?,?)");) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();

        } catch (SQLException e) {
        }
    }

    @Override
    public List<Product> findByName(String name) {
      return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select *from product");) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                products.add(new Product(id, name, price,quantity ));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> sortByQuantity() {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }
}
