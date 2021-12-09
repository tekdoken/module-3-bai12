package ktra.service.implement;

import ktra.model.Category;
import ktra.service.CategoryService;

import java.sql.*;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }return connection;
    }
    @Override
    public void add(Category customer) throws SQLException {

    }

    @Override
    public Category findById(int id) throws SQLException {
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id=?");) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            int idData = rs.getInt("id");
            String name = rs.getString("name");
            Category category=new Category(id,name);
            return category;

        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }
}
