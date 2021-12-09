package demo_8_12.service.implement;

import demo_8_12.model.Blog;
import demo_8_12.model.Category;
import demo_8_12.service.BlogService;
import product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from blog");) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tittle = rs.getString("tittle");
                String content = rs.getString("content");
                int categoryId = rs.getInt("categoryId");
                blogs.add(new Blog(id, tittle, content, categoryId));
            }
        } catch (SQLException e) {
        }
        return blogs;
    }


    public void add(Blog blog) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into blog(id,tittle,content,categoryId) values (?,?,?,?);");) {
            preparedStatement.setInt(1, blog.getId());
            preparedStatement.setString(2, blog.getTittle());
            preparedStatement.setString(3, blog.getContent());
            preparedStatement.setInt(4, blog.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Blog findById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Blog blog) throws SQLException {
        return false;
    }
}
