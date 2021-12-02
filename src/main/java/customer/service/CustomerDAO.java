package customer.service;

import customer.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private static final String DELETE_CUSTOMERS_SQL = "delete from customer where id = ?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customer set name = ?,age= ? where id = ?;";

    public CustomerDAO() {
    }

    public boolean update1(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update customer set name = ?,age= ? where id = ?;");) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setInt(3, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_bai12?useSSL=false", "root", "123456");
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
    public void add(Customer customer) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into customer (id,name,age) value (?,?,?)");) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();

        } catch (SQLException e) {
        }
    }

    @Override
    public Customer findById(int id) {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idData = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                customers.add(new Customer(idData, name, age));
            }
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getId() == id) {
                    return customers.get(i);
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from customer WHERE name LIKE ?;");
        ) {  preparedStatement.setString(1, "%" + name + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idData = rs.getInt("id");
                String name1 = rs.getString("name");
                int age = rs.getInt("age");
                customers.add(new Customer(idData, name1, age));
            }
            return customers;
        } catch (SQLException e) {
        }
        return null;
    }


    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select *from customer order by name");) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                customers.add(new Customer(id, name, age));
            }
        } catch (SQLException e) {
        }
        return customers;
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update customer set name = ?,age= ? where id = ?;");) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setInt(3, customer.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
