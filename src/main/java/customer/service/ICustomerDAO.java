package customer.service;

import customer.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    public void add(Customer customer)throws SQLException;
    public Customer findById(int id);
    public List<Customer> findAll();
    public void delete(int id)throws SQLException;
    public boolean update(Customer customer)throws SQLException;
    public List<Customer> findByName(String name);
}
