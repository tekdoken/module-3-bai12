package ktra.service.implement;


import ktra.model.Category;
import ktra.model.Product;
import ktra.service.ProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id,name ,price,quantity,color,description,categoryId) values (?,?,?,?,?,?,?);");) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setInt(7, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Product findById(int id) throws SQLException {
        Product products = new Product();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");
            String color = rs.getString("color");
            String description = rs.getString("description");
            int categoryId = rs.getInt("categoryId");
            products = new Product(name, price, quantity, color, description, categoryId);
            return products;
        } catch (SQLException e) {
        }
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
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String name = rs.getString("name");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("categoryId");
                products.add(new Product(id, name, price, quantity, color, description, categoryId));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from product where id = ?;");) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        }
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update product set name = ?,price= ? ,quantity= ?,color=?,description=?,categoryId=? where id = ?;");) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());
            statement.setInt(7, product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public List<Product> findByName(String name){
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product WHERE name LIKE ?;");
        ) {  preparedStatement.setString(1, "%" + name + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String nameFind = rs.getString("name");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("categoryId");
                products.add(new Product(id, nameFind, price, quantity, color, description, categoryId));
            }
            return products;
        } catch (SQLException e) {
        }
        return null;
    }
}
